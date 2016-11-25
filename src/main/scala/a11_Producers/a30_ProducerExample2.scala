package a11_Producers

import java.util.Properties

import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

import grizzled.slf4j.Logging

object ProducerExample2 extends Logging{
  
 def main(args: Array[String]) {
    
    val topic = "testtopic"
    
    println("Setting up properties")
    val prop = new Properties()
    prop.put("bootstrap.servers", "localhost:9092")
    prop.put("key.serializer", 
          "io.confluent.kafka.serializers.KafkaAvroSerializer")
    prop.put("value.serializer", 
          "io.confluent.kafka.serializers.KafkaAvroSerializer")  
    prop.put("schema.registry.url", "http://localhost:8081")    
    
    val schemaString:String = 
        """{"namespace": "processspace.avro",
            "type":"record",
            "name":"TestSchema",
            "fields":[{"name":"processid", "type":"string"},
                      {"name":"cpuconsumed", "type":"string"},
                      {"name":"memoryconsumed", "type":"string"},
                      {"name":"javaprocessname", "type":"string"}
            ]}
          """
    println(s"schemaString -> " + schemaString)
    
    val producer:KafkaProducer[String, GenericRecord] = 
                    new KafkaProducer(prop)
    val parser = new Schema.Parser()
    val schema:Schema = parser.parse(schemaString)    
    
    while(true) {
      val processInfoLst:Seq[ProcessInfo] = 
              z11_ProcessChecker.getJavaProcessInfo()
              
      processInfoLst.foreach{ pInfo => 
        val key = pInfo.processId
        val customer:GenericRecord = new GenericData.Record(schema)
        customer.put("processid", pInfo.processId)
        customer.put("cpuconsumed", pInfo.cpuInfo)
        customer.put("memoryconsumed", pInfo.memInfo)
        customer.put("javaprocessname", pInfo.javaProcessName)
        val data = new ProducerRecord[String, GenericRecord](
                                                 topic, 
                                                 key, 
                                                 customer)
        println(s"Sending data : ${pInfo}...")                                                                                          
        producer.send(data).get()   
      }
      
      Thread.sleep(3000)

    }
    
    debug("Exitting Application...")
  }
}


/*
./bin/kafka-avro-console-consumer --topic processtopic --zookeeper localhost:2181 --from-beginning


https://groups.google.com/forum/#!topic/confluent-platform/Z9iOQcgA8aQ
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

___Bascis______________________
___Access_Restriction__________

___Data_Type(Primitive)_______

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
