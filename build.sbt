import Dependencies._

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
libraryDependencies ++= Seq(
  Libraries.springBootStarterWeb,
  Libraries.cats,
  Libraries.catsEffect,
  Libraries.logbackClassic,
  Libraries.scalaTest
)

scalacOptions ++= commonScalacOptions

enablePlugins(JavaAppPackaging)
