# Nurse Jobs (http://138.68.173.197/)

Nurse Jobs is a web application which allows nurses to easily find their dream jobs.

## Architecture Overview

The application utilizes a mircoservcie architecture consisting of four(4) main components:

1. **Web Client** - This is an Angular2 web client which communicates with two restful endpoints; the Job API and the **search.gov API**.

2. **Job API** - This API is used to faciliate the retrieval and saving of jobs retrived from the **search.gov API**.

3. **Search.Gov API** - This API is used to retrive nurse jobs currently being posted by the Federal, state, and local government agencies in the united states. 

4. **My SQL Database** - The MySql database is used to store user selected jobs. The **Job API** retrives and stores jobs in this database.
