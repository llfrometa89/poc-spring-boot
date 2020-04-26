package io.github.llfrometa89.infrastructure.repositories

import cats.effect.Sync
import io.github.llfrometa89.domain.{Project, Task}
import io.github.llfrometa89.domain.repositories.ProjectRepository

class ProjectInMemoryRepository[F[_]: Sync] extends ProjectRepository[F] {

  var projects = List.empty[Project]
  var tasks    = List.empty[Task]

  def add(project: Project): F[Project] = {
    projects = project :: projects
    Sync[F].pure(project)
  }

}
