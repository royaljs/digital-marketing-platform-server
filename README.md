# digital-marketing-platform-server
A toy project of digital marketing platform servers with ProObject7 and Webtob5 wbapi

## 프로젝트 진행 기간
2020년 11월 3일 ~ 2021년 1월 15일

## DM(Digital Marketing) 애플리케이션 아키텍처 및 비즈니스 프로세스

![img](/docs/images/dmp-campaign-deploy.png)

![img](/docs/images/dmp-campaign-webserver.png)

![img](/docs/images/dmp-frontend-guide.png)

## DM 애플리케이션 서버
DM 서버는 Tmaxsoft의 비즈니스 프레임워크 제품인 ProObject7(PO) 기반으로 구현되었으며, 연결된 DB는 관계형 데이터베이스(RDB) 제품인 Tibero6를 사용한다. 

Jeus8 DAS 서버를 이용해 PO7 런타임 엔진을 사용한다.

이 README에서는 PO7 애플리케이션 서버를 기동하는데 필요한 모든 개발환경이 설치되었다고 가정한다.

### PO(ProObject7) 서비스 소스코드 구조
**해당 PO7 소스코드는 ProObject7 Studio에서 생성된 소스코드이므로, 수정을 하기 위해서는 ProObject7 Studio에 소스코드를 import 해야 한다.**

Campaign PO 서비스는 com.tmax.hyperdm 및 com.tmax.hyperdm.dto 패키지에 구성되어있으며, 모두 Complex Service로 구현되어있다. 

com.tmax.hyperdm 패키지에는 CRUD ServiceObject (SOCreate, SOGet, SOUpdate, SODelete) 및 ServiceObjectExecuter, Business Object (BO), Data Object Factory (DOF)가 포함되어있으며, com.tmax.hyperdm.dto 패키지에는 입출력에 사용될 Data Transfer Object (DTO)가 포함되어있다.

Campaign CRUD 최상위 로직은 SO에 구현되어 있으며, 각 CRUD 동작은 BO에 공통적으로 구현되어있다. BO는 Tibero RDB와 연동하고 실제 DB 쿼리를 하는 DOF를 이용하여 DB 동작을 수행한다.

상세한 내용은 소스코드를 참고한다.

### DM API 서버 서비스 구성
DM서버에 각종 ServiceObejct(SO)를 통한 REST API 호출을 통해 데이터의 CRUD 작업이 가능하다. 대상이 되는 데이터는 현재 Campaign이며, 향후 DM 기능 확장시 다양한 데이터에 대한 CRUD API를 제공할 예정이다.

현재 Campaign에 대한 SO는 DM서버 상에서 HyperDM 애플리케이션의 Campaign 서비스그룹 내에 CampaignSO 라는 이름으로 구현되어있다. 따라서 Campaign 에 대한 REST API 호출시 PO서버 호출 방식에 근거하여 “DM서버 URL/HyperDM/Campaign/CampaignSO”을 기본 URL 형식으로 한다.

### Campaign DB 스키마
현재 DM 스튜디오에서 사용될 캠페인 데이터를 Campaign DB 스키마에 적용했다. DM 서비스 
확장시 관련 데이터의 DB 스키마를 토대로 Tibero DB에 적용할 예정이다.

Campaign DB 스키마 내용은 아래와 같다.

| Column (Type/Size)    | Description  |
| ---------------| ------------------------------------------------ |
| **id** (Number(8)) _required_   | 캠페인을 구별하기 위한 id로, Tibero DB의 시퀀스 기능을 이용하여 자동 발급한다.     |
| **user_id** (Number(8)) _required_      | 캠페인을 소유한 사용자의 id이다.                          |
| **name** (Varchar(100 byte)) _required_      | 캠페인의 이름이다.
| **type** (Varchar(100 byte)) _required_      | 캠페인의 타입(이벤트, 광고, 배너, 카탈로그 등)이다.
| **keyword** (Varchar(100 byte)) _required_      | 캠페인과 관련된 키워드이다. 태그 기능을 위해 추가된 속성이다.
| **last_modified** (Timestamp(6)) _required_      | 캠페인을 마지막으로 수정한 날짜이다. YYYYMMDDHHMMSS 형식을 사용한다. (ex. 20200101000000)
| **date_begin** (Timestamp(6)) _required_      | 캠페인의 효력이 시작되는 날짜 및 시각이다.
| **date_end** (Timestamp(6)) _required_      | 캠페인의 효력이 종료되는 날짜 및 시각이다.
| **product_id** (Varchar(100 byte)) _required_      | 캠페인과 연관된 제품의 id이다.
| **contents** (Varchar(65532 byte)) _required_      | 캠페인의 뷰(html양식)를 생성하기 위해 사용된 스타일 속성(props)이다. 캠페인의 타입에 따라 이 속성들이 달라지는데, 매우 다양한 템플릿을 사용할 수 있으므로 현재 문자열 형태로 속성을 저장하고, DM 스튜디오에서는 JSON 형태로 파싱하여 속성을 사용하도록 한다.
| **goal** (Varchar(100 byte)) _required_      | 캠페인 목표 (ex. 방문, 전환)
| **platform** (Varchar(100 byte)) _required_      | 캠페인을 배포할 플랫폼 (ex. 와플, 카카오) 
| **material** (Varchar(100 byte)) _required_      | 캠페인 소재 (ex. 이미지, 비디오)
| **image_uuid** (Varchar(100 byte)) _required_      | 캠페인에 속한 이미지에 부여되는 고유한 uuid이다. DM 스튜디오에서는 이 uuid와 함께 이미지 파일을 이미지 서버에 업로드 요청을 하면 된다. (현재 이미지 서버는 캠페인 웹서버에 통합 되어있다.)

### 현재 제공되는 서비스 목록
* HyperDM(Application)
* Campaign(Service Group)
* CampaignSO(Service Object): 개별 Campaign CRUD
* CampaignListSO(Service Object): Campaign 목록 CRUD(현재 R만 구현)

### 현재 제공되는 API 목록
기재된 HTTP 메소드(GET, POST, PUT, DELETE), URL, header, body에 맞게 전문을 작성하여 API 호출을 한다.

### DM 애플리케이션 서버 TODO List
1. 캠페인 이미지에 대한 uuid인 image_uuid의 발급 주체가 초기엔 API 서버였으나, 최근에 이미지 서버로 변경함에 따라 기존 Tibero DB 스키마의 image_uuid와 REST API의 image_uuid 속성의 삭제를 고려해볼 필요가 있다. 

2. 현재 image_uuid는 이미지 서버에서 발급하며, 별도의 DB 없이 이미지 파일명을 image_uuid.확장자 형식으로 관리하고 있다. 따라서 캠페인 id와 image_uuid를 저장하는 별도의 DB 테이블을 만들지 고려해볼 필요가 있다.

## DM 웹서버/이미지 서버
DM 웹서버는 Tmaxsoft의 웹서버 제품인 Webtob5로 구축되었다. Webtob 버전은 webtob5#fix2이며, 개발/운영 환경은 x86_64 우분투18.04이다.

이 README에서는 webtob5가 설치되고 DM 웹서버에서 사용할 설정파일 및 서비스 소스코드가 적용되었다고 가정한다.

### DM 웹서버 서비스 구성
DM 웹서버는 브라우저로 접속시 집행된 캠페인 화면을 볼 수 있는 템플릿을 응답하는 기본적인 HTML 서비스를 제공한다.

현재 웹서버가 이미지 서버를 겸하고 있으며, WBAPI로 구현된 파일 업로드/다운로드 기능을 이용하여 이미지 파일을 업로드/다운로드 한다.

### DM 웹서버 소스코드 구조
DM 웹서버 소스코드는 크게 설정 파일(http.m 및 rewrite.conf), 서비스 소스코드(WBAPI로 구현된 c언어 파일)로 구성된다.

Config 파일은 webtob 서버의 홈 디렉토리, 문서 디렉토리(브라우저 접근시 보여줄 문서), 포트, 호스트명, 로그, URLRewrite, VHOST 등의 기본적인 서버 설정을 한다. webtob 서버 기동시엔 wscfl로해당 설정파일을 컴파일한 후에 wsboot로 기동한다.

서비스 소스코드는 webtob 서버에서 사용할 서비스를 구현한 것으로, webtob에서 제공하는 C언어 기반 API인 WBAPI를 이용해 구현되었기 때문에 기본적으로 c파일이다. 현재 이미지 upload, download, delete 기능이 각각의 c파일로 구성되어있다. Webtob 서버 기동시에 해당 서비스들이 로딩되므로, 기동되기 이전에 서비스들이 모두 컴파일 되어있어야 한다.

상세한 내용은 소스코드를 참고한다.

### 집행된 캠페인 페이지 웹서버 설정(http.m 파일 NODE절)
집행된 캠페인 페이지를 제공하는 웹서버가 DM 웹서버의 메인 기능이므로 http.m 서버 설정 파일의 NODE 절에 설정한다.

DOCROOT 경로에 집행된 캠페인 페이지를 보여주는 앱(React 프로젝트의 production 빌드)을 배포하면 되며, 해당 설정 후 웹서버 기동시 브라우저를 통해 DOCROOT에 배포된 페이지를 볼 수 있다.

![img](/docs/images/webtob-httpm-config.png)
 
웹서버 설정을 통해 모든 URI 접속을 react 앱의 index.html 파일로 연결시켜주어야 하므로 URLRewrite 기능을 이용한다. Webtob의 URLRewrite는 아파치 서버의 mod_rewrite와 유사하며, webtob에서는 일부 기능이 지원되지 않는다. 

적용한 URLRewrite 설정에 따르면, 웹서버에 요청하는 파일이 DOCROOT에 존재하면 그 파일을 브라우저로 전송하고, 존재하지 않으면 DOCROOT의 campaign/index.html을 전송한다.

이에 따르면, 브라우저에서 웹서버에 /campaign/:id URI로 접근했을 때 DOCROOT/campaign 디렉토리의 id라는 파일을 요청하게 되는데, id 라는 파일은 해당 경로에 존재하는 파일이 아니고 React 앱의 index.html에서 라우팅 해야 하므로 campaign/index.html 파일을 전송한다.

이때 “campaign”은 필요에 따라 다른 이름으로 수정해 사용하면 되며, 이때 사용하는 이름이 프론트 팀의 React 앱의 Router의 basename 값과 같아야 한다. 

자세한 rewrite 설정은 rewrite.conf 파일을 참고한다.

![img](/docs/images/webtob-rewrite-config.png)
 
### DM 이미지 서버 설정 및 서비스 개발
#### 기본 이미지 서버설정 (http.m 파일 VHOST절)
현재 하나의 webtob 웹서버에서 집행된 캠페인 페이지 호스팅과 이미지 서버 기능을 동시에 담당하고 있는데, 이미지 서버는 향후 분리될 여지가 있으므로 http.m 파일의 NODE가 아닌 VHOST 설정을 통해 이미지 서버로 사용할 포트 등을 설정한다.

이미지 업로드/다운로드 서비스를 등록하기 위해 http.m 파일에 SVRGROUP, SERVER, SERVICE, URI 절을 설정한다. 자세한 설명은 전달된 http.m 파일과 webtob5 가이드를 참고한다.

![img](/docs/images/webtob-httpm-image-config1.png)

![img](/docs/images/webtob-httpm-image-config2.png)
 
#### 이미지 업로드/다운로드/삭제 서비스 개발
이미지 업로드/다운로드 서비스는 C언어 기반 webtob 자체 API인 WBAPI를 이용해 구현한다.

WBAPI는 정적 기능을 제공하는 웹서버에서 동적인 서비스를 구현할 수 있도록 제공되는 API이며, 과거 웹서버에서 CGI(Common Gate Interface) 로 구현한 서비스의 성능 이슈를 개선하기 위해 만들어진 API이다. (CGI가 주로 C언어로 구현되었기 때문에 WBAPI도 C언어 API로 제공되는 것으로 보인다.)

CGI 방식이 서비스 호출시마다 해당 서비스의 바이너리를 실행하며 프로세스를 새로 fork 하는 성능상 문제가 있는데 반해, WBAPI로 구현된 서비스는 webtob 서버가 기동될 때 메모리에 로딩하여 서비스 호출시 새로운 프로세스를 fork하지 않는다.

webtob에서 해당 서비스가 WBAPI로 구현된 서비스임을 인지하기 위해 http.m 서버 설정파일에 SVRTYPE = WEBSTD로 설정한다.

WBAPI 에서 사용하는 헤더 파일은 webtob의 include 디렉토리에 존재한다. 사용할 수 있는 API 목록은 Tmaxsoft Technet의 WBAPI 가이드를 참고한다.

서비스를 구현한 c 파일을 빌드하는 절차는 다음과 같다.

1.	서버 설정 디렉토리(/config)에서 wscfl -i http.m
2.	서버 설정 디렉토리(/config)에서 wsgst (이때 서비스를 구현한 c 파일 컴파일에 필요한 c 일(서비스명_svctab.c) 이 SVCTDIR 경로에 생성된다. 따라서 3의 compile을 수행하기 전에 반드시 wsgst 를 수행해야한다.)
3.	서비스를 구현한 c 파일 위치에서 ./compile c {작성한 c 파일명(확장자 제외)} (이때 해당 위치에 compile.c 및 Makefile 파일이 있어야한다.)
4.	wsboot 명령을 통해 구현한 서비스를 로딩하고 webtob 서버 실행
3의 c 파일 컴파일에 실패하는 경우, Makefile.c에서 라이브러리 경로 등의 옵션을 잘 주었는지를 확인한다. (현재 구현된 이미지 업로드 기능에선 libuuid 라이브러리를 사용하므로 -luuid를 추가했다.)

### WBAPI로 개발된 서비스 컴파일시 발생할 수 있는 문제들
1. **Undefined reference to XXX 문제**

    주로 필요한 라이브러리를 Makefile.c에 link 옵션으로 주지 않거나 소스파일에서 헤더파일을 추가하지 않아서 발생한다. Makefile.c와 서비스 소스파일에서 라이브러리와 헤더를 포함시켰는지 확인한다.

    또한, 외부 라이브러리를 사용하는 경우엔 개발환경에 해당 라이브러리가 설치되었는지 확인한다. 예를 들어 upload 서비스에는 uuid.h를 사용하고 있고 이는 우분투 uuid 패키지에 내장되어 있으므로, libuuid나 libuuid-dev를 apt install 설치해야한다.

2. **libpcre.a PIC(Position-Independent Code) 관련 에러**

    libpcre.a 라이브러리는 webtob에서 기본적으로 lib 디렉토리에서 제공하는데, 이 라이브러리를 사용하여 WBAPI 서비스를 컴파일 하는 경우 -fPIC 옵션을 주어 다시 컴파일 하라는 에러가 발생할 수 있다. 이 경우 pcre 소스코드를 다운받아 -fPIC 옵션을 주어 컴파일 한 뒤에 생성된 libpcre.a 라이브러리로 원래있던 libpcre.a를 대체하면 된다.

3. **CORS (Cross-Origin Resource Sharing) 관련 헤더 설정**

    브라우저에서 집행된 웹페이지 웹서버에 접근하여 index.html을 받으면 해당 react 앱에서 캠페인에 포함된 이미지를 이미지 서버에 요청하게 되는데, index.html 파일을 받은 origin과 이미지를 요청하는 origin이 다르므로 CORS 요청을 하게 된다. (현재 웹서버와 이미지 서버가 같은 서버이지만 PORT가 다르므로 origin이 다르다.) 
    
    브라우저에서 preflight 방식으로 이미지 서버에 사용 가능한 메소드, 헤더 등을 확인하기 위해 OPTIONS 사전 HTTP 요청을 보내고, 실제 POST, GET 등의 HTTP 요청을 보내는데 OPTIONS 요청에 대한 응답에 Access-Control 관련 헤더가 없으면 CORS 에러가 발생한다.

    OPTIONS 메소드 기능 특성상 서비스가 호출되기 전의 사전 요청이므로 WBAPI 서비스 소스코드가 아닌 http.m 서버 설정파일에 OPTIONS 응답 헤더를 설정해야 한다. http.m 파일의 HEADERS절에 각종 CORS 관련 헤더 key-value를 정의하고, VHOST 절의 HEADERS에 등록한다.

![img](/docs/images/webtob-httpm-cors-config1.png)

![img](/docs/images/webtob-httpm-cors-config2.png)

### DM 웹서버 TODO List
* 이미지 서버에서 파일 검색 성능을 보장하기 위해 이미지 파일 디렉토리 구조의 설계가 필요하다. 파일 업로드된 시각이나, 파일명(혹은 uuid)을 2글자 정도씩 쪼개서 디렉토리를 짜는 설계가 가능하다. (ex. /2020/01/01/ar213fdvxcwe.png, /ar/21/3fdvxcwe.png) 이 설계에는 말단 디렉토리 하나당 들어가는 이미지 파일의 개수가 고르게 분산되도록 디렉토리 규칙과 depth가 고려되어야한다.
