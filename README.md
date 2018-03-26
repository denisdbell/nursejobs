# Nurse Jobs (http://138.68.173.197/)

Nurse Jobs is a web application which allows nurses to easily find their dream jobs.

## Pre-requisites:

If you are just interested in deploying the application then you will need:

 - docker ver 17.x.x
 - docker-compose ver 1.19.x
 
However, if you want to develop/modify the application you will also need the following:

- maven (mvn) ver 3.x
- node ver 6.x
- npm ver 3.x
- java 8.x

## Architecture Overview

The application utilizes a mircoservcie architecture consisting of four(4) main components:

1. **Web Client** - This is an Angular2 web client which communicates with two restful endpoints; the local **Job API** and the **search.gov API**.

2. **Job API** - This SpringBoot based Restful API application. It is utilized to faciliate the retrieval and saving of jobs  obtained from the **search.gov API**.

3. **My SQL Database** - The MySQL database is used to store user selected jobs. The **Job API** retrives and stores jobs in this database.

4. **Search.Gov API** - This API is used to retrieve nurse jobs currently being posted by the Federal, state, and local government agencies in the United States. 

The schematic diagram below shows the architecture of the system:

![alt text](https://github.com/denisdbell/nursejobs/raw/master/job_client/src/assets/NurseJobsArchitecture.png "Architecture")

## Docker Compose

Docker is used for application deployment and configuration management. The Details of how the various components of the system are configured can be viewed in the **docker-compose.yml** file, see below:

```
version: '3'
services:
  job_client:
    image: denisdbell/job_client:latest
    container_name: job_client
    hostname: job_client
    ports:
     - "80:80"
  job_api:
    image: denisdbell/job_api:latest
    container_name: job_api
    hostname: job_api
    depends_on:
      - db
    networks:
      vpcbr:
        ipv4_address: 10.5.0.5
  db:
    image: mysql:latest 
    container_name: db
    hostname: db
    environment:
      MYSQL_USER: nurse
      MYSQL_DATABASE: nursejobs_db
      MYSQL_ROOT_PASSWORD: password
      MYSQL_PASSWORD: password
    networks:
      vpcbr:
        ipv4_address: 10.5.0.6

networks:
  vpcbr:
    driver: bridge
    ipam:
     config:
       - subnet: 10.5.0.0/16
```
# Running The Application


To run the application execute the following commands:


1. Copy the docker-compose.yml file to a directory of your choice:
```
 curl https://raw.githubusercontent.com/denisdbell/nursejobs/master/docker-compose.yml > docker-compose.yml  
```
2. Run **docker-compose up**
```
docker-compose up
```
Navigate to http://localhost/ and you will see the application displayed, see below:

![alt text](https://github.com/denisdbell/nursejobs/raw/master/job_client/src/assets/search.png "Architecture")
![alt text](https://github.com/denisdbell/nursejobs/raw/master/job_client/src/assets/search_view.png "Architecture")


# Making Code Modifications

Code modifcations can be made to the front end (job_client) and backend (job-api)

## Making UI Modications

1. Clone the repository
```
git clone https://github.com/denisdbell/nursejobs.git
```
2. Open the **nursejobs/job_client** folder in an IDE or text editor of your choice.

3. Execute the following command to run the web client locally:
```
npm install && npm start
```
4. Navigate to http://localhost:3000 to view the application.

5. When you have finished making modifications to the code, execute the **build.sh** file located in the root directory of the project. This will rebuild the project and push the docker images to the dockerhub repository.

## Making Backend Modications

1. Clone the repository
```
git clone https://github.com/denisdbell/nursejobs.git
```
2. Open the **nursejobs/job_api** folder in an IDE or text editor of your choice.

3. Execute the following command to run the job api locally:
```
mvn spring-boot:run
```

4. Navigate to http://localhost:8080 to see if the application is up and running.

5. When you have finished making modifications to the code, execute the **build.sh** file located in the root directory of the project. This will rebuild the project and push the docker images to the dockerhub repository.



