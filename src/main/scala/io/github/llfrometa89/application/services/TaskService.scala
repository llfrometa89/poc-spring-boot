package io.github.llfrometa89.application.services

import cats.effect.Sync
import cats.implicits._
import io.github.llfrometa89.application.converters.TaskConverter
import io.github.llfrometa89.application.dtos.{CreateTaskDTO, TaskDTO, UpdateTaskDTO}
import io.github.llfrometa89.domain.models.Project.ProjectNotFound
import io.github.llfrometa89.domain.models.Task.TaskNotFound
import io.github.llfrometa89.domain.repositories.{ProjectRepository, TaskRepository}

class TaskService[F[_]: Sync](
    projectRepository: ProjectRepository[F],
    taskRepository: TaskRepository[F],
    taskConverter: TaskConverter
) {

  def add(projectId: String, data: CreateTaskDTO): F[TaskDTO] =
    for {
      maybeProject <- projectRepository.findById(projectId)
      project      <- maybeProject.liftTo[F](ProjectNotFound(projectId))
      task         <- Sync[F].pure(taskConverter.toModel(data, project))
      taskSaved    <- taskRepository.add(task)
    } yield taskConverter.toDTO(taskSaved)

  def update(taskId: String, data: UpdateTaskDTO): F[TaskDTO] =
    for {
      maybeTask    <- taskRepository.findById(taskId)
      task         <- maybeTask.liftTo[F](TaskNotFound(taskId))
      taskToUpdate <- Sync[F].pure(task.copy(name = data.name, checked = data.checked))
      taskUpdated  <- taskRepository.update(taskToUpdate)
    } yield taskConverter.toDTO(taskUpdated)

  def remove(taskId: String): F[Unit] =
    for {
      maybeTask <- taskRepository.findById(taskId)
      task      <- maybeTask.liftTo[F](TaskNotFound(taskId))
      _         <- taskRepository.remove(task)
    } yield ()

  def findAll: F[List[TaskDTO]] =
    for {
      tasks <- taskRepository.findAll
    } yield tasks.map(taskConverter.toDTO)

  def findById(taskId: String): F[TaskDTO] =
    for {
      maybeTask <- taskRepository.findById(taskId)
      task      <- maybeTask.liftTo[F](TaskNotFound(taskId))
    } yield taskConverter.toDTO(task)

  def toggle(taskId: String): F[TaskDTO] =
    for {
      maybeTask    <- taskRepository.findById(taskId)
      task         <- maybeTask.liftTo[F](TaskNotFound(taskId))
      taskToUpdate <- Sync[F].pure(task.copy(checked = !task.checked))
      taskUpdated  <- taskRepository.update(taskToUpdate)
    } yield taskConverter.toDTO(taskUpdated)

}
