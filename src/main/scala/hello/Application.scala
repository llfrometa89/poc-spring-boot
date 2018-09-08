package hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure._

@SpringBootApplication
class Application

object Application extends App {
  SpringApplication.run(classOf[Application], args:_*)
}
