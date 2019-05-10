# my-rest-service
A simple RESTful web service created using Java Spring boot with docker. Built using maven.

### The steps to run are -
1. Clone and cd inside the project

2. Package the spring boot code -
* mvn clean package

3. Create a docker image
* docker build -t my-web-service

4. Verify if the image is created ( you should see the name you provided, eg: 'my-web-service' above)
* docker image ls

5. Run the docker image
* docker run -p 5000:8080 my-web-service
