package a11_Producers

import java.util.Properties

import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

import grizzled.slf4j.Logging

object ProducerExample3 extends Logging{
  
  /*def main(args: Array[String]) {
    
    val topic = "processinfo_string"
    
    println("Setting up properties")
    val prop = new Properties()
    prop.put("bootstrap.servers", "localhost:9092")
    prop.put("key.serializer", 
          "org.apache.kafka.common.serialization.StringSerializer")
    prop.put("value.serializer", 
          "org.apache.kafka.common.serialization.StringSerializer")  
    prop.put("schema.registry.url", "http://localhost:8081")    
    
    
    val producer:KafkaProducer[String, String] = 
                    new KafkaProducer(prop)
    
    while(true) {
      val processInfoLst : Seq[ProcessInfo] = 
              z11_ProcessChecker.getJavaProcessInfo()
              
      processInfoLst.foreach{ pInfo => 
        val mykey = pInfo.processId
        val myval = pInfo.memInfo     
        val data = new ProducerRecord[String, String](
                                                 topic, 
                                                 mykey, 
                                                 myval)
        println(s"Sending data : Key -> ${mykey}, Val -> ${myval}...")                                                                                          
        producer.send(data).get()   
      }
      
      Thread.sleep(3000)
    }
    
    debug("Exitting Application...")
  }*/
}


/*
./bin/kafka-avro-console-consumer --topic processtopic --zookeeper localhost:2181 --from-beginning
 */













/*
         
    val schemaString:String = 
        """{"namespace": "customerManagement.avro",
            "type":   "record",
            "name":   "Customer",
            "fields": [ {"name": "id", "type": "string"},
        						    {"name": "name", "type": "string"},
        						    {"name": "email", "type": ["null","string"], 
        						                              "default":"null" }
        					]}""";    
    
    debug(s"schemaString -> " + schemaString)
    
    val producer:KafkaProducer[String, GenericRecord] = 
                    new KafkaProducer(prop)
    val parser = new Schema.Parser()
    val schema:Schema = parser.parse(schemaString)
    
    val id = "id1"
    val name = "Raj"
    val email = "raj@raj.com"
    val customer:GenericRecord = new GenericData.Record(schema)
    customer.put("id", id)
    customer.put("name", name)
    customer.put("email", email)
    
    val data = 
        new ProducerRecord[String, GenericRecord]("customerContacts", 
                                                name, customer)   
    producer.send(data).get()                                                                                      
    
    debug("Exitting Application...")

 */








/*
./bin/kafka-avro-console-consumer --topic customerContacts \
         --zookeeper localhost:2181 \
         --from-beginning */
/*
 * http://software.clapper.org/grizzled-slf4j/
 * http://alvinalexander.com/scala/how-to-log-output-file-grizzled-slf4j-scala-simplelogger.properties
 */

/*
    val schemaString:String = 
        """{"namespace": "customerManagement.avro",
            "type":   "record",
            "name":   "Customer",
            "fields": [ {"name": "id", "type": "string"},
        						    {"name": "name", "type": "string"},
        						    {"name": "email", "type": ["null","string"], 
        						                              "default":"null" }
        					]}""";    
 
 */
