package io.github.llfrometa89.domain.repositories

import io.github.llfrometa89.domain.models.Task

trait TaskRepository[F[_]] {

  def add(task: Task): F[Task]
  def update(task: Task): F[Task]
  def remove(task: Task): F[Unit]
  def findAll: F[List[Task]]
  def findById(taskId: String): F[Option[Task]]

}
