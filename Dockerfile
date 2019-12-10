# Dockerfile
FROM tomcat:latest

ADD Server/out/artifacts/Server_war/Server_war.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]