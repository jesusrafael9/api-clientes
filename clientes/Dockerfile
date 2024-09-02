# Description: Dockerfile for the base image of the project
# author: Jesus Cardozo
# date: 2021-09-01
# version: 1.0
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado al contenedor
COPY target/clientes-0.0.1-SNAPSHOT.jar /app/clientes.jar
COPY src/main/resources/BaseDatos.sql /app/schems.sql

# Exponer el puerto en el que la aplicación se ejecuta
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/clientes.jar"]

