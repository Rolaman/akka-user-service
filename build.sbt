name := "Akka User Service"

version := "0.1"

scalaVersion := "2.13.6"

val AkkaVersion = "2.6.16"
val AkkaHttpVersion = "10.2.6"
val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,

  "com.pauldijou" %% "jwt-core" % "4.3.0",
  "com.zaxxer" % "HikariCP" % "4.0.3",
  "org.postgresql" % "postgresql" % "42.2.23",
  "com.typesafe.slick" %% "slick" % "3.3.3",

  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,

  "com.outr" %% "hasher" % "1.2.2"


)