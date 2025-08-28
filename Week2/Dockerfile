# Bước 1: Build bằng Maven + JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Bước 2: Deploy lên Tomcat 9 + JDK 17
FROM tomcat:9.0.108-jdk17-temurin
WORKDIR /usr/local/tomcat

# Xóa webapp mặc định
RUN rm -rf webapps/*

# Copy WAR từ build sang ROOT.war
COPY --from=build /app/target/*.war webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
