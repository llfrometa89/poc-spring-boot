package io.github.llfrometa89.infrastructure.repositories

import cats.effect.Sync
import io.github.llfrometa89.domain.models.Project
import io.github.llfrometa89.domain.repositories.ProjectRepository

class ProjectInMemoryRepository[F[_]: Sync] extends ProjectRepository[F] {

  def add(project: Project): F[Project] = {
    Database.projects = project :: Database.projects
    Sync[F].pure(project)
  }

  def update(project: Project): F[Project] = {
    Database.projects = project :: Database.projects.filter(_.id != project.id)
    Sync[F].pure(project)
  }

  def remove(project: Project): F[Unit] = {
    Database.projects = Database.projects.filter(_.id != project.id)
    Sync[F].unit
  }

  def findAll: F[List[Project]] = Sync[F].pure(Database.projects)

  def findById(projectId: String): F[Option[Project]] =
    Sync[F].pure(Database.projects.find(_.id == projectId))
}
