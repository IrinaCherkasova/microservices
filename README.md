# Microservices try-out

This project is based on microservices course: https://lineate.udemy.com/course/spring-boot-microservices-cqrs-saga-axon-framework

## Axon
To get it working, Axon server is needed:  

docker run --name axonserver -p 8024:8024 -p 8124:8124 -v "/home/icherkasova/projects/docker-data/data":/data -v "/home/icherkasova/projects/docker-data/eventdata":/eventdata -v "/home/icherkasova/projects/docker-data/config":/config axoniq/axonserver

**axonserver.properties** is in the project root just to be saved somewhere. It should be copied to the persistent docker data:  
sudo cp ~/projects/AxonServer-4.5.2/config/axonserver.properties ~/projects/docker-data/config

## Eureka
Eureka is started here: http://localhost:8761/


