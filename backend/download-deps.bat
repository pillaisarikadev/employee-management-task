@echo off
curl -O https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-starter-web/3.1.3/spring-boot-starter-web-3.1.3.jar
curl -O https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-starter-data-jpa/3.1.3/spring-boot-starter-data-jpa-3.1.3.jar
curl -O https://repo1.maven.org/maven2/com/h2database/h2/2.1.214/h2-2.1.214.jar
curl -O https://repo1.maven.org/maven2/org/projectlombok/lombok/1.18.28/lombok-1.18.28.jar
mkdir lib
move *.jar lib/
