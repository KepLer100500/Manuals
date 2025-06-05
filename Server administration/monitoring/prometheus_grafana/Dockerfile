FROM maven:3.8.5-openjdk-17-slim
COPY ./artifact/app-1.0.jar /home/app/app.jar
WORKDIR /home/app/
EXPOSE 8089
CMD ["java","-jar", "app.jar"]
