package io.github.llfrometa89.domain.models

case class Task(
    id: String,
    name: String,
    checked: Boolean,
    project: Project
)

object Task {
  trait TaskError                         extends Exception
  case class TaskNotFound(taskId: String) extends TaskError
}
