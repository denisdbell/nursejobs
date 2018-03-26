#!/bin/bash

ROOT_DIR=$(pwd)

cd $ROOT_DIR/job_client

#Build angular project
npm run build && \
#Buid angular docker image
docker image build --tag denisdbell/job_client:latest .

#Push docker angular image
#docker image push denisdbell/job_client:latest


