#include <stdio.h>
#include <string.h>
#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>
#include <usrinc/wbapi.h>
#include <usrinc/atmi.h>

#define UUID_LENGTH 32

//scandir용 filter함수
int excludeHidden(const struct dirent *entry){
	if(strcmp(entry->d_name, ".") == 0 || strcmp(entry->d_name, "..") == 0){
		return 0;
	} 
	return 1;
}

//확장자 추출 함수(예: .png)
char* extractExtension(char* fileName){
	char *pos;
	static __thread char ext[100];//파일명 및 확장자

	pos = strchr(fileName, '.');
	strcpy(ext, pos);

	return ext;
}

int download(WBSVCINFO *rqst)
{
	
	//Request URI로부터 이미지 uuid 추출(uuid 맨 앞에 "/" 기호 삽입됨)
	
	char *requestPath = wbGetPathInfo(rqst);
	requestPath++;

	if(strcmp(requestPath, "") == 0){ //Request URI가 빈 경우
		wbSetStatus(rqst, 400, NULL);
		wbPutHdr(rqst, "Content-Type", "application/json");
		wbPrint(rqst, "{ \"desc\": \"Missing image uuid. Image file request URI should be formatted as /:uuid.\" }");
		wbReturn(rqst, WBSUCCESS);

	}

	fprintf(stdout, "requestPath=%s\n", requestPath);

	char *pos;
	char uuid[100] = "";
	strcpy(uuid, requestPath);
	if(strchr(uuid, '/')!= NULL){ // Request URI가 "/:uuid/dsada..." 형식으로 온 경우(경로 형식이 안맞음)
		wbSetStatus(rqst, 400, NULL);
		wbPutHdr(rqst, "Content-Type", "application/json");
		wbPrint(rqst, "{ \"desc\": \"image file request URI should be formatted as /:uuid.\" }");
		wbReturn(rqst, WBSUCCESS);
	}

	fprintf(stdout, "uuid=%s\n", uuid);
	
	char imageRoot[255] = "/home/webtob/webtob/campaignImages/";
	fprintf(stdout, "imageRoot=%s\n", imageRoot);

	struct dirent **fileList;
	int numOfFile = scandir(imageRoot, &fileList, excludeHidden, NULL);
	if(numOfFile == 0 || numOfFile == -1){ // 디렉토리 자체가 없거나(-1) 업로드된 이미지가 없는 경우(0)
		wbSetStatus(rqst, 404, NULL);
		wbPutHdr(rqst, "Content-Type", "application/json");
		wbPrint(rqst, "{ \"desc\": \"Any image file has been uploaded.\" }");
		wbReturn(rqst, WBSUCCESS);
	}
	
	char fileName[50] = "", ext[10] = "";
	/* id 디렉토리에서 이미지 파일 검색 */
	for(int i = 0; i < numOfFile; i++){
		strcpy(fileName, fileList[i]->d_name);
		if(strncmp(fileName, uuid, UUID_LENGTH) != 0){ //파일 이름이 uuid가 아니면 스킵
			if(i == numOfFile - 1){//이미지 파일을 찾지 못한 경우
				wbSetStatus(rqst, 404, NULL);
				wbPutHdr(rqst, "Content-Type", "application/json");
				wbPrint(rqst, "{ \"desc\": \"Image not found.\" }");
				wbReturn(rqst, WBSUCCESS);
			}
			continue;
		} else { //파일 이름이 uuid인 경우 확장자 추출
			fprintf(stdout, "다운로드할 파일 이름=%s\n", fileName);
			strcpy(ext, extractExtension(fileName));
			fprintf(stdout, "확장자=%s\n", ext);
			break;
		}
	}

	/* 요청 이미지 파일 응답 */
	//이미지 파일 경로 설정
	char imagePath[255];
	strcpy(imagePath, imageRoot);
	strcat(imagePath, fileName);
	fprintf(stdout, "imagePath=%s\n", imagePath);

	char resHdrContentDisposition[255];
	//확장자별 Response header의 content-type 설정
	if(strcasecmp(ext, ".png") == 0){
		wbPutHdr(rqst, "content-type", "image/png");
	} else if(strcasecmp(ext, ".jpg") == 0){
		wbPutHdr(rqst, "content-type", "image/jpg");
	} else if(strcasecmp(ext, ".jpeg") == 0){
		wbPutHdr(rqst, "content-type", "image/jpeg");
	} else if(strcasecmp(ext, ".gif") == 0){
		wbPutHdr(rqst, "content-type", "image/gif");
	} else if(strcasecmp(ext, ".bmp") == 0){
		wbPutHdr(rqst, "content-type", "image/bmp");
	} else if(strcasecmp(ext, ".tif") == 0){
		wbPutHdr(rqst, "content-type", "image/tif");
	} else if(strcasecmp(ext, ".tiff") == 0){
		wbPutHdr(rqst, "content-type", "image/tiff");
	} else if(strcasecmp(ext, ".svg") == 0){
		wbPutHdr(rqst, "content-type", "image/svg+xml");
	} else if(strcasecmp(ext, ".webp") == 0){
		wbPutHdr(rqst, "content-type", "image/webp");
	} else if(strcasecmp(ext, ".ico") == 0){
		wbPutHdr(rqst, "content-type", "image/x-icon");
	} else { // 확장자가 지정된 것 이외의 것이면 octet-stream 사용
		wbPutHdr(rqst, "content-type", "application/octet-stream");
	}

	sprintf(resHdrContentDisposition, "inline; filename=%s", fileName);
	wbPutHdr(rqst, "content-disposition", resHdrContentDisposition); //content-disposition을 inline으로 하면 브라우저 접속시 화면에 표시해주고, attachment로하면 다운로드 시킨다. octet-stream은 해당 속성 적용 안됨
	fprintf(stdout, "downloaded file=%s\n", fileName);
	wbPutFile(rqst, imagePath);
	wbReturn(rqst, WBSUCCESS);
}
