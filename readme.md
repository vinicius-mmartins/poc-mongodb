
~~~
    docker run --name mongodb -p 27017:27017 -d mongodb/mongodb-community-server:latest
    docker exec -it mongodb bash
    docker start mongodb
~~~