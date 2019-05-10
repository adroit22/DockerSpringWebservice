# my-rest-service
A simple RESTful web service created using Java Spring boot with docker. Built using maven.

#### The service provides two GET APIs - 
- http://localhost:3600/marvel/characters (Shows json with collection of all marvel characters)
- http://localhost:3600/marvel/characters/{id} (Shows json for character with given id. The id is an integer from 1-18) 
- The url is robust to provide instructions to the user if the id entered is outside the range and if the id entered is non-numeric.

#### The steps to run are -
1. Clone and cd inside the project

2. Package the spring boot code -
   - mvn clean package

3. Create a docker image
   - docker build -t my-web-service . 

4. Verify if the image is created ( you should see the name you provided, eg: 'my-web-service' above)
   - docker image ls

5. Run the docker image
   - docker run -p 5000:8080 my-web-service

#### NOTE -
The code has been packaged locally and an docker image for it was created and pushed to my DockerHub account. 
So to run my-web-service, you can directly use my dockerhub image without having to perform all the packaging steps.

- docker run -p 3600:8080 adroit22/my-web-service:0.0.1-SNAPSHOT


