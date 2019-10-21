Run the following commands below in order to bootstrap the application:

If you wish to run a sonar analysis of your project then, plese
follow the steps below:
Run:
1. > docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube
(If for any reasons there are the ports's conflict you can restart sonarqube image by running a command below:

>docker restart sonarqube

>)
2. In you project root run the command below:
>./gradlew build sonarqube

3. Goto a folder ./build/sonar
Open report-task.txt
Find a sonar dashboard url e.g.
dashboardUrl=http://localhost:9000/dashboard?id=techtest%3Aregistration

4. Open that URL in chrome.

In order to run the web app, please follow the steps below:

1) > ./gradlew clean build docker

2) > docker run -p 8080:8080 -t techtest/registration-spring-boot-docker

In order to run the tests, please run the command below from 
the project root folder.

> ./gradlew clean build test

In order to run a swagger APIs url, please follow the steps below:
1. > ./gradlew clean build bootRun
2. Open URL: http://localhost:8080/swagger-ui.html#/

