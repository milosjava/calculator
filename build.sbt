
// Name of the project
name := "CalculatorScala"

// Project version
version := "0.5"

// Version of Scala used by the project
scalaVersion := "2.11.7"


// Add dependency on ScalaFX library, for use with JavaFX 8/Java 8

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scalafx" %% "scalafx" % "8.0.60-R9"
)

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"


// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true