#!/bin/bash

ROOT_DIR=$(pwd)

cd $ROOT_DIR/job_client

#Build angular project
npm run build && \

#Buid angular docker image
docker image build --tag denisdbell/job_client:latest .

cd $ROOT_DIR/job_api

#Build spring boot project docker image
mvn clean package docker:build  

#Push docker angular image
docker image push denisdbell/job_client:latest

#Push docker spring boot image
docker image push denisdbell/job_api:latest

