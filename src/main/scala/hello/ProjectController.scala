package hello

import java.util.{Optional, UUID}
import org.springframework.web.bind.annotation._
import scala.collection.JavaConverters._
import hello.MemoryData._

@RestController
class ProjectController {

  @RequestMapping(value = Array("/projects"), method = Array(RequestMethod.GET))
  def getAll: java.util.List[ProjectDTO] = projects.asJava

  @RequestMapping(value = Array("/projects/{projectId}"))
  def getById(@PathVariable projectId: String): Optional[ProjectDTO] = {
    val maybeProject = projects.find(_.id == projectId)
    Optional.ofNullable(maybeProject.orNull)
  }

  @PostMapping(value = Array("/projects"))
  def create(@RequestBody data: CreateProjectParameter): ProjectDTO = {
    val newProject = ProjectDTO(UUID.randomUUID().toString, data.name, data.priority, List.empty[TaskDTO].asJava)
    projects = newProject :: projects
    newProject
  }

  @PutMapping(value = Array("/projects/{projectId}"))
  def update(@PathVariable projectId: String, @RequestBody data: UpdateProjectParameter): Optional[ProjectDTO] = {
    projects.find(_.id == projectId) match {
      case Some(project) =>
        val newProject = ProjectDTO(projectId, data.name, data.priority, project.tasks)
        projects = newProject :: projects.filter(_.id != projectId)
        Optional.of(newProject)
      case _ => Optional.ofNullable(null)
    }
  }

  @DeleteMapping(value = Array("/projects/{projectId}"))
  def delete(@PathVariable projectId: String): Optional[java.util.List[ProjectDTO]] = {
    projects.find(_.id == projectId) match {
      case Some(_) =>
        projects = projects.filter(_.id != projectId)
        Optional.of(projects.asJava)
      case _ => Optional.ofNullable(null)
    }
  }

}
