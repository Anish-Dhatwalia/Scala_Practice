ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.3"

lazy val root = (project in file("."))
  .settings(
    name := "Scala development"
  )

libraryDependencies +=
      "com.typesafe.akka" %% "akka-actor-typed" % "2.8.3"
