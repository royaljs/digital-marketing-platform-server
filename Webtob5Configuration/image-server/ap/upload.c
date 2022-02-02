#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <dirent.h>
#include <time.h>
#include <usrinc/atmi.h>
#include <usrinc/wbapi.h>
#include <uuid/uuid.h>

void removeChar(char *str, char ch){
	for(; *str != '\0'; str++){
		if(*str == ch){
			strcpy(str, str + 1);
			str--;
		}
	}
}

//uuid 생성함수
char* generateUuid(int size){
	uuid_t binuuid;
	char *uuid = malloc(size+5);//하이픈 4개, 마지막 \0 1개 
	uuid_generate_random(binuuid);
	uuid_unparse_lower(binuuid, uuid);
	removeChar(uuid, '-');

	return uuid;
}

//확장자 제외 파일명 추출 함수
char* extractTitle(char* filename){
	char *pos;
	static __thread char title[100]; //static: local 변수 바로 사라지지 않게 __thread: 멀티스레드 환경에서 스레드별로 static 변수 사용

	strcpy(title, filename);
	pos = strchr(title, '.');
	*pos = '\0';

	return title;
}

//확장자 추출 함수(예: .png)
char* extractExtension(char* filename){
	char *pos;
	static __thread char ext[100];//파일명 및 확장자

	pos = strchr(filename, '.');
	strcpy(ext, pos);

	return ext;
}

int upload(WBSVCINFO *rqst) {
	char *filename, *key, *imageRoot;

	fprintf(stdout, "method=%s\n",wbGetMethod(rqst));
	int count = wbGetDataCount(rqst); //count: 요청 body의 key-value 쌍의 수. 이 API에서는 업로드 하는 이미지의 개수가 된다.

	fprintf(stdout, "count=%d\n",count);
	//오류 응답 - 요청 Request에 이미지 파일이 없는 경우(빈 body)
	if(count == 0){
		wbPutHdr(rqst, "Content-Type", "application/json");
		wbSetStatus(rqst, 400, NULL);
		wbPrint(rqst, "{ \"desc\": \"Any image file received. Please attach image files.\" }");
		wbReturn(rqst, WBSUCCESS);
	}

	char root[200] = "/home/webtob/webtob/campaignImages/";
	imageRoot = root;

	char *imageJson = calloc(2 * 32 * count, sizeof(char));
	
	//Request 이미지 파일 처리 loop
	for(int k=1; k<=count; k++){
		key = wbGetNthKey(rqst, k);

		/* 이미지 uuid 발급 */
		char *uuid = generateUuid(32);
		fprintf(stdout, "uuid=%s\n", uuid);
		filename = wbGetFileName(rqst, key);
		
		/* image key - image uuid JSON 객체 작성 */
		if(strcmp(imageJson, "") == 0){
			strcat(imageJson, "{ \"");
		} else {
			strcat(imageJson, ", \"");
		}
		strcat(imageJson, key);
		strcat(imageJson, "\": \"");
		strcat(imageJson, uuid);
	    	strcat(imageJson, "\" ");
		
		/* 이미지 파일 저장 */

		//이미지 파일명 uuid로 변경 및 파일 시스템에 저장
		char uploadImageName[255];
		strcpy(uploadImageName, uuid);
		strcat(uploadImageName, extractExtension(filename));
		fprintf(stdout, "uploaded image name=%s\n", uploadImageName);

		char imagePath[255];
		sprintf(imagePath, "%s%s", imageRoot, uploadImageName);
		fprintf(stdout, "파일 imagePath=%s\n", imagePath);

		int rtn = wbSaveFile(rqst, key, imagePath);
	
		if( rtn < 0 ){ 
			wbPutHdr(rqst, "Content-Type", "application/json");
		wbSetStatus(rqst, 400, NULL);
			wbPrint(rqst, "{ \"desc\": \"Image %s Upload failed.\"", filename);
			wbReturn(rqst, WBSUCCESS);
		}
	}
	
	strcat(imageJson, "}");
	fprintf(stdout, "json=%s\n", imageJson);
	
	//생성된 이미지  key - uuid JSON 객체 전송
	wbSetStatus(rqst, 200, NULL);
	wbPutHdr(rqst, "Content-Type", "application/json");
	wbPrint(rqst, imageJson);	
	wbReturn(rqst,WBSUCCESS);
}
