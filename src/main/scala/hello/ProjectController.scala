package hello

import java.util.{Optional, UUID}

import org.springframework.web.bind.annotation._

import scala.beans.BeanProperty
import scala.collection.JavaConverters._

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

  @PutMapping(value = Array("/projects/{projectId}/tasks"))
  def addTask(@PathVariable projectId: String, @RequestBody data: CreateTaskParameter): Optional[ProjectDTO] = {
    projects.find(_.id == projectId) match {
      case Some(project) =>
        val newTask = TaskDTO(UUID.randomUUID().toString, data.name, data.checked)
        val newProject = project.withTask(newTask)
        projects = newProject :: projects.filter(_.id != projectId)
        Optional.of(newProject)
      case _ => Optional.ofNullable(null)
    }
  }

  //DATA
  //TODO: Only for testing library
  var tasksProject1 = List(
    TaskDTO("9999-8888-7777-6666", "Task 1", checked = true),
    TaskDTO("8888-8888-7777-6666", "Task 1", checked = false)
  )

  var projects = List(
    ProjectDTO("1111-2222-3333-4444", "MyProject1", 1, List.empty[TaskDTO].asJava),
    ProjectDTO("2222-2222-3333-4444", "MyProject2", 2, List.empty[TaskDTO].asJava),
    ProjectDTO("3333-2222-3333-4444", "MyProject3", 3, List.empty[TaskDTO].asJava)
  )

}

//DTO
//TODO: Only for testing library
case class ProjectDTO(@BeanProperty var id: String,
                      @BeanProperty var name: String,
                      @BeanProperty var priority: Int,
                      @BeanProperty var tasks: java.util.List[TaskDTO]) {

  def withTask(task: TaskDTO): ProjectDTO = {
    this.tasks = (task :: tasks.asScala.toList).asJava
    this
  }
}

case class TaskDTO(@BeanProperty var id: String, @BeanProperty var name: String, @BeanProperty var checked: Boolean)

//Parameter
//TODO: Only for testing library
case class CreateProjectParameter(name: String, priority: Int)

case class UpdateProjectParameter(name: String, priority: Int)

case class CreateTaskParameter(name: String, checked: Boolean)
