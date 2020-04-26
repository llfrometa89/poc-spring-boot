package io.github.llfrometa89.application.converters

import java.util.UUID

import io.github.llfrometa89.application.dtos.{CreateProjectDTO, ProjectDTO, UpdateProjectDTO}
import io.github.llfrometa89.domain.{Project, Task}

object ProjectConverter {

  def toModel(data: CreateProjectDTO): Project =
    Project(
      id = UUID.randomUUID().toString,
      name = data.name,
      priority = data.priority,
      tasks = List.empty[Task]
    )

  def toModel(data: UpdateProjectDTO): Project =
    Project(
      id = UUID.randomUUID().toString,
      name = data.name,
      priority = data.priority,
      tasks = List.empty[Task]
    )

  def toDTO(model: Project): ProjectDTO =
    ProjectDTO(
      id = model.id,
      name = model.name,
      priority = model.priority,
      tasks = model.tasks.map(TaskConverter.toDTO)
    )
}
