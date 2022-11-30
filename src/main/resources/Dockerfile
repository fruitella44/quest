# selet parent image
FROM tomcat:9.0-alpine
LABEL maintainer="zelenij24@yandex.ru"

# add war
ADD step_by_step-1.0-SNAPSHOT.war /usr/local/tomcat/webapps

EXPOSE 8080
CMD ["catalina.sh", "run"]