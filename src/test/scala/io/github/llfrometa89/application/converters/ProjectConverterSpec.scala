package io.github.llfrometa89.application.converters

import io.github.llfrometa89.UnitTestSpec
import io.github.llfrometa89.application.dtos.CreateProjectDTO
import io.github.llfrometa89.cross.IdentifierGenerator
import io.github.llfrometa89.domain.models.{Project, Task}

class ProjectConverterSpec extends UnitTestSpec {

  var projectConverter: ProjectConverter           = _
  var taskConverterMock: TaskConverter             = _
  var identifierGeneratorMock: IdentifierGenerator = _

  before {
    taskConverterMock = mock[TaskConverter]
    identifierGeneratorMock = mock[IdentifierGenerator]
    projectConverter = new ProjectConverter(taskConverterMock, identifierGeneratorMock)
  }

  "toModel" should "success transformation from CreateProjectDTO to Project" in {

    when(identifierGeneratorMock.generate).thenReturn("aId")

    val createProjectDTO = CreateProjectDTO("aName", 1)
    val ProjectExpected  = Project(name = "aName", id = "aId", priority = 1, tasks = List.empty[Task])

    val result = projectConverter.toModel(createProjectDTO)

    result shouldBe ProjectExpected

    verify(identifierGeneratorMock).generate
  }

}
