package com.labs1904.hwe.homework

import java.time.Duration
import java.util.{Arrays, Properties, UUID}

import net.liftweb.json.DefaultFormats
import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.common.serialization.StringDeserializer

object KafkaHomework {
  /**
   * Your task is to try to understand this code and run the consumer successfully. Follow each step below for completion.
   * Implement all the todos below
   */

    //TODO: If these are given in class, change them so that you can run a test. If not, don't worry about this step
  val BootstrapServer = "change-me"
  val Topic: String = "change-me"

  implicit val formats: DefaultFormats.type = DefaultFormats

  def main(args: Array[String]): Unit = {

    // Create the KafkaConsumer
    //TODO: Write in a comment what these lines are doing. What are the properties necessary to instantiate a consumer?

    // Set the properties to be used by the Kafka Consumer and set up the consumer using those properties
    // The properties necessary to instantiate a consumer are the bootstrap server, the key and value deserializers, and the group Id
    val properties = getProperties(BootstrapServer)
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](properties)


    //TODO: What does this line mean? Write your answer in a comment below
    consumer.subscribe(Arrays.asList(Topic))
    // sets the consumer to subscribe to/receive messages from a certain topic of partitions

    while (true) {
      // TODO: Change this to be every 5 seconds
      val duration: Duration = Duration.ofSeconds(5)

      //TODO: Look up the ConsumerRecords class below, in your own words what is the class designed to do?
      val records: ConsumerRecords[String, String] = consumer.poll(duration)
      // class is designed to handle the records/messages/data coming from kafka as a key value pair
      // will also consist of the topic name, partition number, offset, and a timestamp from the producer record

      records.forEach((record: ConsumerRecord[String, String]) => {
        // Retrieve the message from each record
        //TODO: Describe why we need the .value() at the end of record
        val message = record.value()
        // the value will be the actual record contents

        //TODO: If you were given the values for the bootstrap servers in class, run the app with the green play button and make sure it runs successfully. You should see message(s) printing out to the screen
        println(s"Message Received: $message")
      })
    }
  }

  def getProperties(bootstrapServer: String): Properties = {
    // Set Properties to be used for Kafka Consumer
    val properties = new Properties
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer)
    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString)

    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    properties
  }

}
