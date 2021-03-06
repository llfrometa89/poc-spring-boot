package io.github.llfrometa89.application.services

import cats.effect.Sync
import cats.implicits._
import io.github.llfrometa89.application.converters.ProjectConverter
import io.github.llfrometa89.application.dtos.{CreateProjectDTO, ProjectDTO, UpdateProjectDTO}
import io.github.llfrometa89.domain.models.Project.ProjectNotFound
import io.github.llfrometa89.domain.repositories.ProjectRepository

class ProjectService[F[_]: Sync](projectRepository: ProjectRepository[F], projectConverter: ProjectConverter) {

  def add(data: CreateProjectDTO): F[ProjectDTO] =
    for {
      project      <- Sync[F].pure(projectConverter.toModel(data))
      projectSaved <- projectRepository.add(project)
    } yield projectConverter.toDTO(projectSaved)

  def update(projectId: String, data: UpdateProjectDTO): F[ProjectDTO] =
    for {
      maybeProject    <- projectRepository.findById(projectId)
      project         <- maybeProject.liftTo[F](ProjectNotFound(projectId))
      projectToUpdate <- Sync[F].pure(project.copy(name = data.name, priority = data.priority))
      projectUpdated  <- projectRepository.update(projectToUpdate)
    } yield projectConverter.toDTO(projectUpdated)

  def remove(projectId: String): F[Unit] =
    for {
      maybeProject <- projectRepository.findById(projectId)
      project      <- maybeProject.liftTo[F](ProjectNotFound(projectId))
      _            <- projectRepository.remove(project)
    } yield ()

  def findAll: F[List[ProjectDTO]] =
    for {
      projects <- projectRepository.findAll
    } yield projects.map(projectConverter.toDTO)

  def findById(projectId: String): F[ProjectDTO] =
    for {
      maybeProject <- projectRepository.findById(projectId)
      project      <- maybeProject.liftTo[F](ProjectNotFound(projectId))
    } yield projectConverter.toDTO(project)

}
