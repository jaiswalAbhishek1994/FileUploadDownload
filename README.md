# FileUploadDownload
Run file FileapplicationApplication.java from package "com.file"
Open browser and type http://localhost:8080/swagger-ui.html it will ask for username and password for authentication then open SecurityConfig from package "com.file.security" and take the username and password(exclude {noop} from the password) and put it in the browser.
have fun with the application

if you are using postman 
enable basic authentication in Authentication header (for all the request)
and enter the credentials for post request
select content-type=multipart/form-data in headers
select body type form-data and key file (parameter defined for the request), select type file and choose the file and make the request.

