# Overview

Similar to the work you did for Kafka, this is your crash course into Spark through different questions. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like
* Spark By Examples is a great resources to start with - [Spark By Examples](https://sparkbyexamples.com/)

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Spark help solve? Use a specific use case in your answer 
* Helpful resource: [Apache Spark Use Cases](https://www.toptal.com/spark/introduction-to-apache-spark)
* [Overivew of Apache Spark](https://www.youtube.com/watch?v=znBa13Earms&t=42s)

Spark processes large scale data very fast by using Resilient Distributed Datasets and the computing is done in memory.  Can do both batch processing and real-time.
Fault-tolerant, fast processing, flexible in programmability, more advanced analytics.
An e-commerce company might use spark to analyze real time transaction details and browsing history so they can show
recommendations to their users.

#### What is Apache Spark?
* Helpful resource: [Spark Overview](https://www.youtube.com/watch?v=ymtq8yjmD9I)

Open source data processing tool used to store and process data in real time.  Used to rapidly query, analyze and transform data at scale.

#### What is distributed data processing? How does it relate to Apache Spark?  
[Apache Spark for Beginners](https://medium.com/@aristo_alex/apache-spark-for-beginners-d3b3791e259e)

Distributed data processing pertains to data residing on multiple nodes running in a cluster for processing.  The nodes can execute the data in parallel.  Spark uses RDDs, in which replication of data happens on different parts of a cluster.  These
represent an immutable, partitioned collection of elements operating in parallel.

#### On the physical side of a spark cluster, you have a driver and executors. Define each and give an example of how they work together to process data
Driver determines the possible tasks to be performed and generates a physical plan.  Uses a cluster manager to coordinate and schedule the tasks to run on the executors.
The executors run a task and return the result back to the driver.

#### Define each and explain how they are different from each other 
* RDD (Resilient Distributed Dataset) - abstraction of Spark, handles partitioning data across all the nodes in a cluster, which is held in the memory pool of the cluster as a single unit.
* DataFrame - overcomes the limitations of Spark RDD, DataSet organized into columns, so similar to a relational database. Allows processing of a large amount of structured data.
Allows user to impose a structure onto the data.
* DataSet - data structure in SparkSQL.  Datasets provide the convenience of RDD and performance optimization of DataFrame.
Overcomes limitations of RDD(data can't be altered without knowing it's structure) and Dataframe(no provision for compile-time safety).

#### What is a spark transformation?
[Spark By Examples-Transformations](https://sparkbyexamples.com/apache-spark-rdd/spark-rdd-transformations/)

Spark operations when executed on RDD.  Results in a new RDD or multiple new RDDs.

#### What is a spark action? How do actions differ from transformations? 
Actions are operators that return non RDD values. RDDs are lazy, meaning they will not execute the transformations until we call actions.

#### What is a partition in spark? Why would you ever need to repartition? 
[Spark Partitioning](https://sparkbyexamples.com/spark/spark-repartition-vs-coalesce/)

A partition in Spark is a chunk of data of a large distributed data set. 
You can repartition to increase or decrease partitions.

#### What was the most fascinating aspect of Spark to you while learning? 
