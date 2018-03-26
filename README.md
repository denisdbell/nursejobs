# Nurse Jobs (http://138.68.173.197/)

Nurse Jobs is a web application which allows nurses to easily find their dream jobs.

## Architecture Overview

The application utilizes a mircoservcie architecture consisting of four(4) main components:

1. **Web Client** - This is an Angular2 web client which communicates with two restful endpoints; the Job API and the **search.gov API**.

2. **Job API** - This SpringBoot based Restful API application. It is utilized to faciliate the retrieval and saving of jobs  obtained from the **search.gov API**.

3. **My SQL Database** - The MySQL database is used to store user selected jobs. The **Job API** retrives and stores jobs in this database.

4. **Search.Gov API** - This API is used to retrieve nurse jobs currently being posted by the Federal, state, and local government agencies in the United States. 

The schematic diagram below shows the architecture of the system:

![alt text](https://github.com/denisdbell/nursejobs/raw/master/job_client/src/assets/NurseJobsArchitecture.png "Architecture")

## Docker Compose

Docker is used for application deployment and configuration management. The Details of how the various components of the system communicate can be viewed from the **docker-compose.yml** file, see below:

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
# Running the application


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

**Note: You will need the latest version of docker and docker-compose to execute the command above**


![alt text](https://github.com/denisdbell/nursejobs/raw/master/job_client/src/assets/search.png "Architecture")
![alt text](https://github.com/denisdbell/nursejobs/raw/master/job_client/src/assets/search_view.png "Architecture")




