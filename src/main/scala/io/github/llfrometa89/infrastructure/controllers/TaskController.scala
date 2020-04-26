package io.github.llfrometa89.infrastructure.controllers

import cats.effect.IO
import io.github.llfrometa89.application.dtos.{CreateTaskDTO, TaskDTO, UpdateTaskDTO}
import io.github.llfrometa89.application.services.TaskService
import org.springframework.web.bind.annotation._

@RestController
class TaskController(taskService: TaskService[IO]) {

  @PostMapping(value = Array("api/projects/{projectId}/tasks"))
  def create(@PathVariable projectId: String, @RequestBody data: CreateTaskDTO): TaskDTO =
    taskService.add(projectId, data).unsafeRunSync()

  @PutMapping(value = Array("api/tasks/{taskId}"))
  def update(@PathVariable taskId: String, @RequestBody data: UpdateTaskDTO): TaskDTO =
    taskService.update(taskId, data).unsafeRunSync()

  @DeleteMapping(value = Array("api/tasks/{taskId}"))
  def remove(@PathVariable taskId: String): Unit =
    taskService.remove(taskId).unsafeRunSync()

  @GetMapping(value = Array("api/tasks"))
  def findAll(): Unit =
    taskService.findAll.unsafeRunSync()

  @GetMapping(value = Array("api/tasks/{taskId}"))
  def findById(@PathVariable taskId: String): Unit =
    taskService.findById(taskId).unsafeRunSync()

  @PutMapping(value = Array("api/tasks/{taskId}/toggle"))
  def toggle(@PathVariable taskId: String): Unit =
    taskService.toggle(taskId).unsafeRunSync()

}
