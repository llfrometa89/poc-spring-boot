package io.github.llfrometa89

import cats.implicits._
import cats.effect.{ExitCode, IO, IOApp}
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure._

@SpringBootApplication
class Application

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    IO(SpringApplication.run(classOf[Application], args: _*))
      .as(ExitCode.Success)
}
