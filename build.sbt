
// Name of the project
name := "CalculatorScala"

// Project version
version := "0.0.1"

// Version of Scala used by the project
scalaVersion := "2.11.5"


// Add dependency on ScalaFX library, for use with JavaFX 8/Java 8
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.60-R9"


// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true