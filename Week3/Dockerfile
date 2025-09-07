# Dùng Tomcat 9 + JDK 17
FROM tomcat:9.0.108-jdk17-temurin

WORKDIR /usr/local/tomcat

# Xóa webapp mặc định của Tomcat
RUN rm -rf webapps/*

# Copy WAR đã build sẵn từ thư mục host (TomCat/webapps) vào container
COPY TomCat/webapps/*.war webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
