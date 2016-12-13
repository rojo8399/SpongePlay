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

val repoUrl = settingKey[String]("repo.url")

repoUrl := sys.props("repo.url")

val repoName = settingKey[String]("repo.name")

repoName := sys.props.getOrElse("repo.name", "Sponge Repo")

val repoUsername = settingKey[String]("repo.user")

repoUsername := sys.props("repo.user")

val repoPassword = settingKey[String]("repo.pwd")

repoPassword := sys.props("repo.pwd")

crossPaths := false

publishTo <<= (repoUrl, repoName, repoUsername, repoPassword) { (url: String, name: String,
                                                                 user: String, pwd: String) =>
  println("URL      : " + url)
  println("Name     : " + name)
  println("User     : " + user)
  println("Password : " + pwd.replaceAll(".", "*"))
  credentials += Credentials(name, new URL(url).getHost, user, pwd)
  Some(name at url)
}
