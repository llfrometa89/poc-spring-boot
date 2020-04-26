package io.github.llfrometa89.infrastructure.repositories

import cats.effect.Sync
import io.github.llfrometa89.domain.models.Task
import io.github.llfrometa89.domain.repositories.TaskRepository

class TaskInMemoryRepository[F[_]: Sync] extends TaskRepository[F] {

  def add(task: Task): F[Task] = {
    Database.tasks = task :: Database.tasks
    Sync[F].pure(task)
  }

  def findById(taskId: String): F[Option[Task]] =
    Sync[F].pure(Database.tasks.find(_.id == taskId))

  def update(task: Task): F[Task] = {
    Database.tasks = task :: Database.tasks.filter(_.id != task.id)
    Sync[F].pure(task)
  }

  def remove(task: Task): F[Unit] = {
    Database.tasks = Database.tasks.filter(_.id != task.id)
    Sync[F].unit
  }

  override def findAll: F[List[Task]] = Sync[F].pure(Database.tasks)
}
