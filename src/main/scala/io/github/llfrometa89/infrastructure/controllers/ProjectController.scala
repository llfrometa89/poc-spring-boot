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

  @RequestMapping(method = Array(RequestMethod.GET))
  def getAll: List[ProjectDTO] = projectService.findAll.unsafeRunSync()

  @RequestMapping(value = Array("/{projectId}"))
  def getById(@PathVariable projectId: String): ProjectDTO =
    projectService.findById(projectId).unsafeRunSync()

  @PutMapping(value = Array("/{projectId}"))
  def update(@PathVariable projectId: String, @RequestBody data: UpdateProjectDTO): ProjectDTO =
    projectService.update(projectId, data).unsafeRunSync()

  @DeleteMapping(value = Array("/{projectId}"))
  def remove(@PathVariable projectId: String): Unit =
    projectService.remove(projectId).unsafeRunSync()

}
