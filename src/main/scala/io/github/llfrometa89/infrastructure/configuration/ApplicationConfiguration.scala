package io.github.llfrometa89.infrastructure.configuration

import cats.effect.IO
import io.github.llfrometa89.application.converters.{ProjectConverter, TaskConverter}
import io.github.llfrometa89.application.services.{ProjectService, TaskService}
import io.github.llfrometa89.cross.IdentifierGenerator
import io.github.llfrometa89.domain.repositories.{ProjectRepository, TaskRepository}
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class ApplicationConfiguration {

  @Bean
  def beanProjectConverter(taskConverter: TaskConverter, identifierGenerator: IdentifierGenerator): ProjectConverter =
    new ProjectConverter(taskConverter, identifierGenerator)

  @Bean
  def beanTaskConverter: TaskConverter = new TaskConverter

  @Bean
  def beanProjectService(
      projectRepository: ProjectRepository[IO],
      projectConverter: ProjectConverter
  ): ProjectService[IO] =
    new ProjectService[IO](projectRepository, projectConverter)

  @Bean
  def beanTaskService(
      projectRepository: ProjectRepository[IO],
      taskRepository: TaskRepository[IO],
      taskConverter: TaskConverter
  ): TaskService[IO] =
    new TaskService[IO](projectRepository, taskRepository, taskConverter)
}
