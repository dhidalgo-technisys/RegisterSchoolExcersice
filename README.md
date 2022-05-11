# RegisterSchoolExcersice
## IDE
This project uses the spring boot framework and use MySQL how database.
We can run this project importing the source code with and IDE how maven project and run it how spring boot aplication.


## Docker image 
We can easily run the whole with only a single command:

docker-compose up

Docker will pull the MySQL and Maven images (if our machine does not have it before).
The services can be run on the background with command:
 
docker-compose up -d

Now you can check the current working containers:

docker ps

We can test the web service for example use the curl command 

curl --location --request GET 'localhost:8080/courses/getAll'
