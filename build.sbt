name := "pco-spring-boot"

organization := "io.github.llfrometa89"

version := "1.0.0"

scalaVersion := "2.13.2"

lazy val commonScalacOptions = Seq(
  "-feature",
  "-language:higherKinds",
  "-encoding",
  "UTF-8",
  "-deprecation",
  "-unchecked",
  "-Wunused:imports,patvars,locals",
  "-Wnumeric-widen",
  "-Xlint:-unused"
)

libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.0.4.RELEASE"

scalacOptions ++= commonScalacOptions

enablePlugins(JavaAppPackaging)
