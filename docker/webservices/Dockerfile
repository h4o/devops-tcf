FROM tomee:8-jre-1.7.2-plus
ADD webservicesmodule-1.0-SNAPSHOT.war /usr/local/tomee/webapps/webservicesmodule-1.0-SNAPSHOT.war
COPY tomcat-users.xml /usr/local/tomee/conf/tomcat-users.xml
RUN cat /usr/local/tomee/conf/tomcat-users.xml
RUN ls /usr/local/tomee/conf/
RUN cat /usr/local/tomee/conf/tomcat-users.xml