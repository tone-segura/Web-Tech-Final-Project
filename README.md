# botornot



# running with docker
#### build an image

```docker build -t {whatever you name your image} .``` (the period at the end matters)

#### run the container
```docker run -p 8080:8080 {whatever you named your image}```

visit ```http://localhost:8080/Server_war/``` after your container is running to see the app running

# DB info
### The DB connection doesn't work yet. we still need to play with it
```
host: bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com
user: admin
password: webtechclass
database: bot_or_not```
