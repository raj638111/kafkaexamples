
lazy val root = (project in file(".")). 
  settings(
    name := "kafkaexamples",
    version := "1.0",  
    // Scal Version
    scalaVersion := "2.10.6",
    // Download source code(will come in handy to refer the code in eclipse)
    EclipseKeys.withSource := true,
    resolvers += "confluent" at "http://packages.confluent.io/maven/",
    libraryDependencies ++= Seq(
    	//'provided' - We do not want to ship these JARs to
    	//             worker nodes, as they will be already available
    	//             in the worked nodes
      "org.apache.kafka" % "kafka-clients" % "0.10.0.0",
      "io.confluent" % "kafka-avro-serializer" % "3.0.0",
      "org.clapper" %% "grizzled-slf4j" % "1.0.2",
      "org.apache.spark" % "spark-core_2.10" % "1.6.1" % "provided",
      "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.6.1",
      "org.apache.spark" % "spark-streaming_2.10" % "1.6.1"
    )
 )

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("javax", "el", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case PathList("org", "jboss", xs @ _*) => MergeStrategy.last
  case PathList("io", "netty", xs @ _*) => MergeStrategy.discard
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "META-INF/jboss-beans.xml" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
} 
