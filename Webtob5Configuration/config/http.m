*DOMAIN
webtob1

*NODE
jiwonlee	WEBTOBDIR="/home/webtob/webtob", 
		SHMKEY = 64000,
		DOCROOT="/home/webtob/webtob/docs",
		APPDIR = "/home/webtob/webtob/image-server/ap",
		PORT = "8080", 
		HTH = 10,
		NODENAME = "$(NODENAME)",
		HOSTNAME = "SET_HOST_IP_HERE",
		ERRORDOCUMENT = "503",
		METHOD = "GET,POST,HEAD,OPTIONS,PUT,DELETE",
		LOGGING = "log1",
		ERRORLOG = "log2",
		SYSLOG = "syslog",
		ServiceOrder = "uri,ext",
		URLRewrite = Y,
		URLRewriteConfig = "/home/webtob/webtob/config/rewrite.conf"

*HTH_THREAD
hth_worker
                  SendfileThreads = 4,
                  AccessLogThread = Y,
                  #ReadBufSize=1048576, #1M
                  #HtmlsCompression="text/html",
                  #SendfileThreshold=32768,
                  WorkerThreads=8


*SVRGROUP
webapg		NODENAME = "jiwonlee", SVRTYPE = WEBSTD, VhostName = image

*SERVER
upload		SVGNAME = webapg, MinProc = 2, MaxProc = 5
download	SVGNAME = webapg, MinProc = 2, MaxProc = 5
delete		SVGNAME = webapg, MinProc = 2, MaxProc = 5

*SERVICE
upload		SVRNAME = upload
download	SVRNAME = download
delete		SVRNAME = delete

*URI
webapiup	Uri = "/image/", Svrtype = WEBSTD, VhostName = image, SvrName = upload
webapidown	Uri = "/image/", Svrtype = WEBSTD, VhostName = image, SvrName = download
webapidelete	Uri = "/image/", Svrtype = WEBSTD, VhostName = image, SvrName = delete

*HEADERS
CORS_CREDENTIAL	ACTION = "AddResponse",
		FieldName = "Access-Control-Allow-Credentials",
		FieldValue = "true"

CORS_ORIGIN 	ACTION = "AddResponse",
		FieldName = "Access-Control-Allow-Origin",
		FieldValue = "*"

CORS_HEADER	ACTION = "AddResponse",
		FieldName = "Access-Control-Allow-Headers",
		FieldValue = "origin, x-requested-with, content-type, accept"

CORS_METHOD	ACTION = "AddResponse",
		FieldName = "Access-Control-Allow-Methods",
		FieldValue = "OPTIONS,GET,POST,PUT,DELETE"

CORS_MAXAGE	ACTION = "AddResponse",
		FieldName = "Access-Control-Max-Age",
		FieldValue = "3600"

*VHOST
image		HOSTNAME = "SET_HOST_IP_HERE",
		DOCROOT = "/home/webtob/webtob/image-server/docs",
		APPDIR = "/home/webtob/webtob/image-server/ap",
		METHOD = "OPTIONS,GET,POST,PUT,DELETE",
		HEADERS = "CORS_CREDENTIAL, CORS_ORIGIN, CORS_HEADER, CORS_METHOD, CORS_MAXAGE",
		PORT = "9090"

*EXT
css             MimeType = "text/css", SvrType = HTML
js              MimeType = "application/x-javascript", SvrType = HTML

*LOGGING
syslog		Format = "SYSLOG", FileName = "/home/webtob/webtob/log/system.log_%M%%D%%Y%",
			Option = "sync"
log1		Format = "DEFAULT", FileName = "/home/webtob/webtob/log/access.log_%M%%D%%Y%", 
			Option = "sync"
log2		Format = "ERROR", FileName = "/home/webtob/webtob/log/error.log_%M%%D%%Y%", 
			Option = "sync"

*ERRORDOCUMENT
404		status = 404,
		url = "/"
503			status = 503,
			url = "/503.html"


