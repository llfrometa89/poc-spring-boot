package io.github.llfrometa89.infrastructure.controllers

import cats.effect.IO
import io.github.llfrometa89.application.dtos._
import io.github.llfrometa89.application.services.ProjectService
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(value = Array("api/projects"))
class ProjectController(projectService: ProjectService[IO]) {

  @PostMapping
  def create(@RequestBody data: CreateProjectDTO): ProjectDTO =
    projectService.add(data).unsafeRunSync()

//  @RequestMapping(value = Array("/projects"), method = Array(RequestMethod.GET))
//  def getAll: java.util.List[ProjectDTO] = projects.asJava

//  @RequestMapping(value = Array("/projects/{projectId}"))
//  def getById(@PathVariable projectId: String): Optional[ProjectDTO] = {
//    val maybeProject = projects.find(_.id == projectId)
//    Optional.ofNullable(maybeProject.orNull)
//  }
//

//
//  @PutMapping(value = Array("/projects/{projectId}"))
//  def update(@PathVariable projectId: String, @RequestBody data: UpdateProjectParameter): Optional[ProjectDTO] = {
//    projects.find(_.id == projectId) match {
//      case Some(project) =>
//        val newProject = ProjectDTO(projectId, data.name, data.priority, project.tasks)
//        projects = newProject :: projects.filter(_.id != projectId)
//        Optional.of(newProject)
//      case _ => Optional.ofNullable(null)
//    }
//  }
//
//  @DeleteMapping(value = Array("/projects/{projectId}"))
//  def delete(@PathVariable projectId: String): Optional[java.util.List[ProjectDTO]] = {
//    projects.find(_.id == projectId) match {
//      case Some(_) =>
//        projects = projects.filter(_.id != projectId)
//        Optional.of(projects.asJava)
//      case _ => Optional.ofNullable(null)
//    }
//  }

}
