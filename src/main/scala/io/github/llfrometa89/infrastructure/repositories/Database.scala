package io.github.llfrometa89.infrastructure.repositories

import io.github.llfrometa89.domain.models.{Project, Task}

object Database {

  var projects: List[Project] = List.empty[Project]
  var tasks: List[Task]       = List.empty[Task]
}
