Project Setup and testing Instructions steps
=============================================

1. Down load the project from Github and import to Eclipse.
2. Down load Apache Zookeeper and Kafka and 7-zip as instructed in the URL https://dzone.com/articles/running-apache-kafka-on-windows-os
3. Extract Zookeeper and Kafka using 7-zip.
4. Set ZOOKEEPER_HOME enviorenment variable and add bin to path.
5. Run ZooKeeper by opening a new cmd and type zkserver.
6. While Zookeeper is running , Go to your Kafka installation directory:    (Example C:\kafka_2.13-2.6.0\) , and run command .\bin\windows\kafka-server-start.bat .\config\server.properties and press Enter.

7. Now your Kafka Server is up and running, you can create topics to store messages using 

Creating Topic
==================
1.Open a new command prompt in the location C:\kafka_2.13-2.6.0\bin\windows.(use your Kafka installation location)

2. Type the following command and hit Enter:​

kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic novice-players

TESTING your APP
=====================

1. Build and run the application.
2. Down load and install Advance REST Client or POSTMAN.
3. Enter following
   Request URL -http://localhost:9000/TrueLogic/REST/recordPlayerEvents
   Method - POST
   Add headers content-type =application/json and accept=application/json
   Request Body
   {
  "players": [
    {
      "name": "Sub zero",
      "type": "expert"
    },
    {
      "name": "Scorpion",
      "type": "novice"
    },
    {
      "name": "Reptile",
      "type": "meh"
    }
  ]
}

 4. Hit "SEND" button
 
    You should get an " 200 OK" with the following response
    
    {
"results": [
  {
"outcome": "player Sub zero stored in DB"
},
  {
"outcome": "player Scorpion sent to Kafka topic"
},
  {
"outcome": "player Reptile did not fit"
}
],
"status": "OK",
"errorMsg": ""
}
    