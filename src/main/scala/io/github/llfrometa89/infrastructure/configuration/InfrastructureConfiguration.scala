package io.github.llfrometa89.infrastructure.configuration

import cats.effect.IO
import io.github.llfrometa89.infrastructure.repositories.ProjectInMemoryRepository
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class InfrastructureConfiguration {

  @Bean
  def beanProjectInMemoryRepository: ProjectInMemoryRepository[IO] = new ProjectInMemoryRepository[IO]
}
