import sbt._

object Dependencies {

  object Versions {
    val cats       = "2.1.0"
    val catsEffect = "2.1.1"
    val scalaTest  = "3.2.0-M2"
    val logback    = "1.2.3"
    val springBoot = "2.0.4.RELEASE"
  }

  object Libraries {

    def springBoot(artifact: String): ModuleID = "org.springframework.boot" % artifact % Versions.springBoot

    val springBootStarterWeb = springBoot("spring-boot-starter-web")
    val cats                 = "org.typelevel" %% "cats-core" % Versions.cats
    val catsEffect           = "org.typelevel" %% "cats-effect" % Versions.catsEffect
    val logbackClassic       = "ch.qos.logback" % "logback-classic" % Versions.logback
    val scalaTest            = "org.scalatest" %% "scalatest" % Versions.scalaTest % Test
  }
}
