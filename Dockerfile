# Dockerfile
FROM tomcat:latest

ADD Server/out/artifacts/bot-or-not/not-or-not.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
