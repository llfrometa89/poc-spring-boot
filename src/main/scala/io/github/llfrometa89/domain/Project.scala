package io.github.llfrometa89.domain

case class Project(
    id: String,
    name: String,
    priority: Int,
    tasks: List[Task]
)
