package io.github.llfrometa89.application.converters

import io.github.llfrometa89.application.dtos.TaskDTO
import io.github.llfrometa89.domain.Task

object TaskConverter {

  def toDTO(model: Task): TaskDTO =
    TaskDTO(
      id = model.id,
      name = model.name,
      projectId = model.projectId,
      checked = model.checked
    )
}
