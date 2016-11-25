package a11_Producers

import grizzled.slf4j.Logging
import org.apache.kafka.clients.producer.KafkaProducer
import java.util.Properties
import org.apache.kafka.clients.producer.ProducerRecord

object ProducerExample1 extends Logging{
  
  /*def main(args: Array[String]) {
    
    debug("Setting up properties")
    val prop = new Properties()
    prop.put("bootstrap.servers", "localhost:9092")
    prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")  
 
    debug("Creating Producer")
    val producer:KafkaProducer[String, String] = 
          new KafkaProducer(prop)
    debug("Creating record for Producer")
    val record:ProducerRecord[String, String] = 
      new ProducerRecord("firstTopic", "key", "First ")
 
    debug("Writing record to Kafka Broker...")
    producer.send(record).get()
    
    debug("Exitting Application...")
  }*/
}

/*
 * http://software.clapper.org/grizzled-slf4j/
 * http://alvinalexander.com/scala/how-to-log-output-file-grizzled-slf4j-scala-simplelogger.properties
 */
