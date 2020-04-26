package io.github.llfrometa89.application

package object dtos {

  case class ProjectDTO(
      id: String,
      name: String,
      priority: Int,
      tasks: List[TaskDTO]
  )

  case class TaskDTO(
      id: String,
      projectId: String,
      name: String,
      checked: Boolean
  )
}
