package io.github.llfrometa89.infrastructure.configuration

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class JacksonConfiguration {

  @Bean
  def defaultScalaModule: Module = DefaultScalaModule
}
