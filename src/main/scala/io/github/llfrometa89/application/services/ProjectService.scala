package io.github.llfrometa89.application.services

import cats.implicits._
import cats.effect.Sync
import io.github.llfrometa89.application.converters.{ProjectConverter, TaskConverter}
import io.github.llfrometa89.application.dtos.{CreateProjectDTO, ProjectDTO}
import io.github.llfrometa89.domain.repositories.ProjectRepository

class ProjectService[F[_]: Sync](projectRepository: ProjectRepository[F]) {

  def add(data: CreateProjectDTO): F[ProjectDTO] =
    for {
      project      <- Sync[F].pure(ProjectConverter.toModel(data))
      projectSaved <- projectRepository.add(project)
    } yield ProjectConverter.toDTO(projectSaved)

}
