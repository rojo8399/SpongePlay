name := "sponge-play"

organization := "org.spongepowered"

version := "1.0.0-SNAPSHOT"

lazy val `spongeplay` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(specs2 % Test)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "javax.mail" % "mail" % "1.4.7"
)
