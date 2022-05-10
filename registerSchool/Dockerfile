FROM maven:3.8.2-jdk-11
WORKDIR /registerSchool
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run