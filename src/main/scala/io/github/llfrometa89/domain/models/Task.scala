package io.github.llfrometa89.domain.models

case class Task(
    id: String,
    projectId: String,
    name: String,
    checked: Boolean
)
