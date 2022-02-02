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

delete(WBSVCINFO *rqst)
{
	//Request URI로부터 요청 캠페인id 및 이미지 uuid 추출(uuid 맨 앞에 "/" 기호 삽입됨) 
        char *requestPath = wbGetPathInfo(rqst);
        requestPath++;

        if(strcmp(requestPath, "") == 0){ //Request URI가 빈 경우
                wbSetStatus(rqst, 400, NULL);
                wbPutHdr(rqst, "Content-Type", "application/json");
                wbPrint(rqst, "{ \"desc\": \"Missing image uuid. Image file request URI should be formatted as /:uuid.\" }");
                wbReturn(rqst, WBSUCCESS);
        }

        fprintf(stdout, "requestPath=%s\n", requestPath);

        char uuid[100] = "";
	strcpy(uuid, requestPath);
        if(strchr(uuid, '/')!= NULL){ // Request URI가 "/:uuid/dsada..." 형식으로 온 경우(경로 형식이 안맞음)
                wbSetStatus(rqst, 400, NULL);
                wbPutHdr(rqst, "Content-Type", "application/json");
                wbPrint(rqst, "{ \"desc\": \"image file request URI should be formatted as /:uuid.\" }");
                wbReturn(rqst, WBSUCCESS);
        }

        fprintf(stdout, "uuid=%s\n", uuid);
		
	//uuid와 같은 파일명 검색
	char imageRoot[255] = "/home/webtob/webtob/campaignImages/";

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
                } else { //파일 이름이 uuid와 동일한 경우
                        fprintf(stdout, "삭제할 파일명=%s\n", fileName);
                        break;
                }
        }

	//다운로드할 이미지 파일 경로 설정
	char imagePath[255];
	strcpy(imagePath, imageRoot);
	strcat(imagePath, fileName);
	fprintf(stdout, "imagePath=%s\n", imagePath);


	//이미지 파일 삭제
	if(remove(imagePath) == -1){
		wbSendError(rqst, 404, "No such image file has been uploaded!");
		wbReturn(rqst, WBSUCCESS);
	}
        wbPutHdr(rqst, "Content-Type", "application/json");
	wbPrint(rqst, "{ \"desc\": \"Successfully deleted image file(%s) from server!\" }", fileName);
	wbReturn(rqst, WBSUCCESS);
} 
