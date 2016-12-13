name := "sponge-play"

organization := "org.spongepowered"

version := "1.0.0-SNAPSHOT"

lazy val `spongeplay` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(ws, specs2 % Test)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "javax.mail" % "mail" % "1.4.7"
)

crossPaths := false

credentials += Credentials(
  sys.props.getOrElse("repo.name", "Sponge Repo"),
  new URL(sys.props("repo.url")).getHost,
  sys.props("repo.user"),
  sys.props("repo.pwd")
)

publishTo := Some(sys.props.getOrElse("repo.name", "Sponge Repo") at sys.props("repo.url"))
