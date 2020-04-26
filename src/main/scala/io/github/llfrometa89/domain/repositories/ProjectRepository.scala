package io.github.llfrometa89.domain.repositories

import io.github.llfrometa89.domain.Project

trait ProjectRepository[F[_]] {

  def add(project: Project): F[Project]
}
