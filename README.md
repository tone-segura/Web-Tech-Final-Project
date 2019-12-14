# botornot-site

#### caveat: We did not use a package manager
We found this to be an interesting exercise that helped us really understand how JAR and WAR work. I might not ever do it again, but we are happy we struggled through it. 

# running with docker
#### build an image

```docker build -t {whatever you name your image} .``` (the period at the end matters)

#### run the container

```docker run -p 8080:8080 {whatever you named your image}```

visit ```http://localhost:8080/Server_war/``` after your container is running to see the app running
please checkout https://www.jetbrains.com/help/idea/deploying-a-web-app-into-an-app-server-container.html for more guidence.
#### running locally with tomcat
We followed this https://www.jetbrains.com/help/idea/run-debug-configuration-tomcat-server.html as reference 
and this post was also very helpful https://stackoverflow.com/questions/4041356/intellij-and-tomcat-howto

#Database
Maria DB hosted on RDS. its public for the time being!
```
host: bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com
user: admin
password: webtechclass
database: bot_or_not


Also, you can find our database migrations in the migrations file, in case you prefer
looking at the raw SQL or have trouble connecting to our DB. 