#Use openjdk21 image as base
FROM openjdk:21

#working dir is /app
WORKDIR /app

#copy the app.jar file to the container
COPY website-aqlabs.v.1.0.jar /app/app.jar

#set entry point
CMD ["java", "-jar", "app.jar"]