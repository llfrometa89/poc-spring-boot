package io.github.llfrometa89.infrastructure.configuration

import cats.effect.IO
import io.github.llfrometa89.application.services.ProjectService
import io.github.llfrometa89.domain.repositories.ProjectRepository
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class ApplicationConfiguration {

  @Bean
  def beanProjectService(projectRepository: ProjectRepository[IO]): ProjectService[IO] =
    new ProjectService[IO](projectRepository)
}
