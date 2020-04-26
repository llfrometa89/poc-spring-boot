package io.github.llfrometa89.domain.repositories

import io.github.llfrometa89.domain.Project

trait ProjectRepository[F[_]] {

  def add(project: Project): F[Project]
  def update(project: Project): F[Project]
  def remove(projectId: String): F[Unit]
  def findAll: F[List[Project]]
  def findById(projectId: String): F[Option[Project]]
}
