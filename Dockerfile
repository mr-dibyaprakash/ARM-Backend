FROM openjdk:11
EXPOSE 8098
COPY /target/audit-request-management-0.0.1-SNAPSHOT.jar arm-api.jar
ENTRYPOINT ["java","-jar","/arm-api.jar"]