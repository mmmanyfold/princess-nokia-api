FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/princess-nokia-api.jar /princess-nokia-api/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/princess-nokia-api/app.jar"]
