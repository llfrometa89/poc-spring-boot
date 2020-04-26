//package io.github.llfrometa89
//
//import scala.beans.BeanProperty
//import scala.collection.JavaConverters._
//
//object MemoryData {
//
//  //DATA
//  //TODO: Only for testing library
//  var tasksProject1 = List(
//    TaskDTO("9999-8888-7777-6666", "1111-2222-3333-4444", "Task 1", checked = true),
//    TaskDTO("8888-8888-7777-6666", "1111-2222-3333-4444", "Task 2", checked = false)
//  )
//
//  var projects = List(
//    ProjectDTO("1111-2222-3333-4444", "MyProject1", 1, tasksProject1.asJava),
//    ProjectDTO("2222-2222-3333-4444", "MyProject2", 2, List.empty[TaskDTO].asJava),
//    ProjectDTO("3333-2222-3333-4444", "MyProject3", 3, List.empty[TaskDTO].asJava)
//  )
//
//  //DTO
//  //TODO: Only for testing library
//  case class ProjectDTO(
//      @BeanProperty var id: String,
//      @BeanProperty var name: String,
//      @BeanProperty var priority: Int,
//      @BeanProperty var tasks: java.util.List[TaskDTO]
//  ) {
//
//    def withTask(task: TaskDTO): ProjectDTO = {
//      this.tasks = (task :: tasks.asScala.toList).asJava
//      this
//    }
//  }
//
//  case class TaskDTO(
//      @BeanProperty var id: String,
//      @BeanProperty var projectId: String,
//      @BeanProperty var name: String,
//      @BeanProperty var checked: Boolean
//  )
//
//  //Parameter
//  //TODO: Only for testing library
//  case class CreateProjectParameter(name: String, priority: Int)
//
//  case class UpdateProjectParameter(name: String, priority: Int)
//
//  case class CreateTaskParameter(name: String, checked: Boolean)
//
//  case class UpdateTaskParameter(name: String, checked: Boolean)
//
//}
