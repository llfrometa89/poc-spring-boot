package hello

import java.util.{Optional, UUID}

import org.springframework.web.bind.annotation._

import scala.beans.BeanProperty
import scala.collection.JavaConverters._

@RestController
class ProjectController {

  //TODO: Only for testing library
  var projects = List(
    ProjectDTO("1111-2222-3333-4444", "MyProject1", 1),
    ProjectDTO("2222-2222-3333-4444", "MyProject2", 2),
    ProjectDTO("3333-2222-3333-4444", "MyProject3", 3)
  )

  @RequestMapping(value = Array("/projects"), method = Array(RequestMethod.GET))
  def getAll: java.util.List[ProjectDTO] = projects.asJava

  @RequestMapping(value = Array("/projects/{projectId}"))
  def getById(@PathVariable projectId: String): Optional[ProjectDTO] = {
    val maybeProject = projects.find(_.id == projectId)
    Optional.ofNullable(maybeProject.orNull)
  }

  @PostMapping(value = Array("/projects"))
  def create(@RequestBody data: CreateProjectParameter): ProjectDTO = {
    val newProject = ProjectDTO(UUID.randomUUID().toString, data.name, data.priority)
    projects = newProject :: projects
    newProject
  }

  @PutMapping(value = Array("/projects/{projectId}"))
  def update(@PathVariable projectId: String, @RequestBody data: UpdateProjectParameter): ProjectDTO = {
    val newProject = ProjectDTO(projectId, data.name, data.priority)
    projects = newProject :: projects.filter(_.id != projectId)
    newProject
  }

}

case class ProjectDTO(@BeanProperty var id: String, @BeanProperty var name: String, @BeanProperty var priority: Int)

case class CreateProjectParameter(name: String, priority: Int)

case class UpdateProjectParameter(name: String, priority: Int)
