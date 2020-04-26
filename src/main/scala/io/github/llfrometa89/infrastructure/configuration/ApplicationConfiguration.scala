package io.github.llfrometa89.infrastructure.configuration

import cats.effect.IO
import io.github.llfrometa89.application.services.{ProjectService, TaskService}
import io.github.llfrometa89.domain.repositories.{ProjectRepository, TaskRepository}
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class ApplicationConfiguration {

  @Bean
  def beanProjectService(projectRepository: ProjectRepository[IO]): ProjectService[IO] =
    new ProjectService[IO](projectRepository)

  @Bean
  def beanTaskService(projectRepository: ProjectRepository[IO], taskRepository: TaskRepository[IO]): TaskService[IO] =
    new TaskService[IO](projectRepository, taskRepository)
}
