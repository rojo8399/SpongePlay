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

val repoHost = settingKey[String]("repo.host")

repoHost := sys.props("repo.host")

val repoName = settingKey[String]("repo.name")

repoName := sys.props.getOrElse("repo.name", "Sponge Repo")

val repoUsername = settingKey[String]("repo.user")

repoUsername := sys.props("repo.user")

val repoPassword = settingKey[String]("repo.pwd")

repoPassword := sys.props("repo.pwd")

crossPaths := false

publishTo <<= (version, repoHost, repoName, repoUsername, repoPassword) { (v: String,
                                                                           host: String,
                                                                           name: String,
                                                                           user: String,
                                                                           pwd: String) =>
  credentials += Credentials(name, host.replace("https://", "").replace("http://", "").replace("/", ""), user, pwd)
  Some(name at host)
}
