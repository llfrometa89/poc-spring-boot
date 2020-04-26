package io.github.llfrometa89.application.converters

import java.util.UUID

import io.github.llfrometa89.application.dtos.{CreateTaskDTO, TaskDTO}
import io.github.llfrometa89.domain.models.{Project, Task}

class TaskConverter {

  def toModel(data: CreateTaskDTO, project: Project): Task = Task(
    id = UUID.randomUUID().toString,
    name = data.name,
    project = project,
    checked = data.checked
  )

  def toDTO(model: Task): TaskDTO =
    TaskDTO(
      id = model.id,
      name = model.name,
      projectId = model.project.id,
      checked = model.checked
    )
}
