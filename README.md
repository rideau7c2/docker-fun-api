# docker-fun-api
Springowe api do zabawy dokerem

## Docker
### Swagger for [docker](http://localhost:10080/api/swagger-ui.html), for [docker-tools](http://192.168.99.100:18080/api/swagger-ui.html) 
#### Build image from war file
`docker build -f Dockerfile -t docker-fun-api:v1 .`
#### Build image from [repo](https://github.com/rideau7c2/docker-fun-api)
`docker build -f Dockerfile_clone -t docker-fun-api:v1 .`
#### Show images
`docker images`
#### Run container in background
`docker run -d -p 18080:8080 --name fun-api-v1 docker-fun-api:v1`
#### Show running containers
`docker ps`
#### Stop container
`docker stop fun-api-v1`