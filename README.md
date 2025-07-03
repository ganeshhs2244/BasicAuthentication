this is readme file of Spring basic authenication POc project

to test the application we can directly start the applicationa and base user will be added automatically
with username and password 
username=> admin
passsword => admin123

------------------------------
This POC is started as mentioned above and continued as below

now after instroduing JWt tocken, we have have jwt tocken generated and that jwt token is used to validate 
future authentication

JwtAuthFilter is as part of initial entry point to application and if that does not contain barer tocken
then it will pass it to BasicAuthentication.

api like "auth/jwt" is exclued form authentication so that it can generate JWT tocken

