# poc-spring-boot
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/aba7bc8bb60b4d0386dbaa85fa071573)](https://www.codacy.com/manual/llfrometa89/poc-spring-boot?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=llfrometa89/poc-spring-boot&amp;utm_campaign=Badge_Grade)

**poc-spring-boot** is a basic example to test many features of Spring Boot library. This example is to manage projects and tasks.

### Requirements
You need to have a configured environment to run a scala project

### Executing the example:

```bash
$ sbt run
```

### Endpoints

#### Projects

- Add a project

```
POST http://localhost:8000/api/projects
{
	"name":"MyProject4",
	"priority":4
}
```


- Update a project
```
PUT http://localhost:8000/api/projects/{projectId}
{
	"name":"MyProjectNewName",
	"priority":6
}
```
- Get all projects
```
GET http://localhost:8000/api/projects
```

- Get a project by identifier
```
GET http://localhost:8000/api/projects/{projectId}
```

- Remove a project by identifier
```
DELETE http://localhost:8000/api/projects/{projectId}
```

#### Tasks

- Add a task inside a project
```
PUT http://localhost:8000/api/projects/{projectId}/tasks
{
	"name":"MyTask1",
	"checked":true
}
```
- Update a task
```
PUT http://localhost:8000/api/tasks/{taskId}
{
	"name":"MyTask3",
	"checked":true
}
```
- Remove a task
```
DELETE http://localhost:8000/api/tasks/{taskId}
```