# Overview

Kafka has many moving pieces, but also has a ton of helpful resources to learn available online. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Kafka help solve? Use a specific use case in your answer 
* Helpful resource: [Confluent Motivations and Use Cases](https://youtu.be/BsojaA1XnpM)

Kafka solves the problem of real time event streaming / event driven architecture.
It allows data to be seen and used in real time rather than after the fact.
For example, a credit card company can tell you in real time when your
credit card looks like it is being used fraudulently by using real time event streaming.

#### What is Kafka?
* Helpful resource: [Kafka in 6 minutes](https://youtu.be/Ch5VhJzaoaI) 

Kafka is an open source event storage and streaming platform that 
handles data in real time and makes the data available
to applications in real time via a messaging system. 
#### Describe each of the following with an example of how they all fit together: 
 * Topic - a group of partitions handling the same type of data. Similar to a table in a database.
 * Producer - reads data updates and writes them into the queue/messaging system or partition
 * Consumer - application consuming the data, ex. web or mobile application
 * Broker - a server holding one or more partitions
 * Partition - a message queue, where the events are written to. When creating a topic, you must specify how many partitions you want within it.

The producer reads a data update and puts it onto the partition.  The consumer will then update based on the new message 
added to the partition.  A topic can have multiple partitions to hold events and the partitions are spread across multiple brokers. If the broker were to go down, the partition will have been replicated
to another broker as a backup.  

#### Describe Kafka Producers and Consumers

The producer is an application that will write or publish an event to Kafka.
The consumer is an application that will read and process these events.  Producers 
and consumers work independently of each other, meaning they never need to wait
for one another.


#### How are consumers and consumer groups different in Kafka? 
* Helpful resource: [Consumers](https://youtu.be/lAdG16KaHLs)
  
* Helpful resource: [Confluent Consumer Overview](https://youtu.be/Z9g4jMQwog0)
  

Consumers read in parallel across partitions but in order based on partition.
Consumers within the same consumer group cannot read from the same partition.  Reading a message does not destroy it. The message will still be there to be read by any other consumer.
Rebalance and scale out happens automatically when you add more consumers to a group
and will still guarantee order by key.

#### How are Kafka offsets different than partitions? 
Each message within a partition gets an incremental ID which is called an offset.
Offsets only have meaning for a specific partition.  One partition will have many offsets. 

#### How is data assigned to a specific partition in Kafka? 
A producer can assign data to a specific partition using a partition key.  
If no key is given, Kafka will assign data in a round robin style.  The records will be distributed evenly
across all partitions.  However, ordering of the records cannot be guaranteed with this method.
#### Describe immutability - Is data on a Kafka topic immutable? 
Data in Kafka can never be changed or overwritten which means it is immutable.
Once an offset on a partition is assigned, that data remains assigned to that offset forever.
#### How is data replicated across brokers in kafka? If you have a replication factor of 3 and 3 brokers, explain how data is spread across brokers
* Helpful resource [Brokers and Replication factors](https://youtu.be/ZOU7PJWZU9w)

Partitions are replicated across brokers based on the replication factor.  So if you have 3 brokers and a 
replication factor of 3, then each partition will be replicated on each of the 3 brokers.
Only 1 broker can be the leader for a partition at any given time, meaning the partition on the leader is where the data is sent and received
for that partition and the other 2 partitions of the same number on the other two brokers will be in-sync replicas.

#### What was the most fascinating aspect of Kafka to you while learning? 
The most fascinating aspect is learning that Kafka is how many companies, big and small, show consumers real time data and are able to
do it on such a large scale.  This is my first time learning anything about this kind
of technology and now I will think of many of these companies / products in a different way
since I understand a little bit more about how it is working behind the scenes.
