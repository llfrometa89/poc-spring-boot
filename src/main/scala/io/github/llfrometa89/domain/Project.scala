package io.github.llfrometa89.domain

case class Project(
    id: String,
    name: String,
    priority: Int,
    tasks: List[Task]
)

object Project {
  trait ProjectError                            extends Exception
  case class ProjectNotFound(projectId: String) extends ProjectError
}
