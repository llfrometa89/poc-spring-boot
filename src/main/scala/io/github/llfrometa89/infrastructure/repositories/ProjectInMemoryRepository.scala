package io.github.llfrometa89.infrastructure.repositories

import cats.effect.Sync
import io.github.llfrometa89.domain.models.{Project, Task}
import io.github.llfrometa89.domain.repositories.ProjectRepository

class ProjectInMemoryRepository[F[_]: Sync] extends ProjectRepository[F] {

  var projects = List.empty[Project]
  var tasks    = List.empty[Task]

  def add(project: Project): F[Project] = {
    projects = project :: projects
    Sync[F].pure(project)
  }

  def update(project: Project): F[Project] = {
    projects = project :: projects.filter(_.id != project.id)
    Sync[F].pure(project)
  }

  def remove(project: Project): F[Unit] = {
    projects = projects.filter(_.id != project.id)
    Sync[F].unit
  }

  def findAll: F[List[Project]] = Sync[F].pure(projects)

  def findById(projectId: String): F[Option[Project]] =
    Sync[F].pure(projects.find(_.id == projectId))
}
