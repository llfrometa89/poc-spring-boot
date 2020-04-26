//package io.github.llfrometa89.infrastructure.controllers
//
//import java.util.{Optional, UUID}
//
//import io.github.llfrometa89.application.dtos.TaskDTO
//import org.springframework.web.bind.annotation._
//
//import scala.jdk.CollectionConverters._
//
//@RestController
//class TaskController {
//
//  @PostMapping(value = Array("/projects/{projectId}/tasks"))
//  def create(@PathVariable projectId: String, @RequestBody data: CreateTaskParameter): TaskDTO = {
//    projects.find(_.id == projectId) match {
//      case Some(project) =>
//        val newTask    = TaskDTO(UUID.randomUUID().toString, projectId, data.name, data.checked)
//        val newProject = project.withTask(newTask)
//        projects = newProject :: projects.filter(_.id != projectId)
//        Optional.of(newProject)
//      case _ => Optional.ofNullable(null)
//    }
//  }
//
//  @PutMapping(value = Array("/tasks/{taskId}"))
//  def update(@PathVariable taskId: String, @RequestBody data: UpdateTaskParameter): Optional[ProjectDTO] = {
//    val tasks = projects.flatMap(_.tasks.asScala.toList)
//    tasks.find(_.id == taskId) match {
//      case Some(task) =>
//        val projectId  = task.projectId
//        val project    = projects.find(_.id == task.projectId).get //TODO .get of Option is for testing only: do not use this operation without checking that there is actually a Some Object
//        val newTask    = TaskDTO(task.id, task.projectId, data.name, data.checked)
//        val newProject = project.withTask(newTask)
//        projects = newProject :: projects.filter(_.id != projectId)
//        Optional.of(newProject)
//      case _ => Optional.ofNullable(null)
//    }
//  }
//
//  @DeleteMapping(value = Array("/tasks/{taskId}"))
//  def delete(@PathVariable taskId: String): java.util.List[ProjectDTO] = {
//    println(s"...........taskId = $taskId")
//    projects = projects.map(project =>
//      ProjectDTO(project.id, project.name, project.priority, project.tasks.asScala.toList.filter(_.id != taskId).asJava)
//    )
//    projects.asJava
//  }
//
//}
