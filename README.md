# poc-spring-boot

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9f7369a5dd7d4f2c8fab85c06e40d276)](https://app.codacy.com/manual/llfrometa89/poc-spring-boot?utm_source=github.com&utm_medium=referral&utm_content=llfrometa89/poc-spring-boot&utm_campaign=Badge_Grade_Settings)

Ejemplo básico de un projecto con spring_boot. Tenemos los recursos Proyecto y Tarea. Tarea es un recurso hijo de Proyecto.


### Pasos para ejecutar:

1. Ejecutar en el terminal el siguiente comando:

```
$  sbt run
```

### Rutas disponibles por recursos:

1. Proyecto:

```
Crear proyecto

POST http://localhost:8080/projects
{
	"name":"MyProject4",
	"priority":4
}
```

```
Actualizar proyecto

PUT http://localhost:8080/projects/{projectId}
{
	"name":"MyProjectNewName",
	"priority":6
}
```

```
Obtener todos los proyectos

GET http://localhost:8080/projects
```

```
Obtener un proyecto por id

GET http://localhost:8080/projects/{projectId}
```

```
Eliminar un proyecto por id

DELETE http://localhost:8080/projects/{projectId}
```

1. Tareas:

```
Adicionar una tarea a un proyecto

PUT http://localhost:8080/projects/{projectId}/tasks
{
	"name":"MyTask1",
	"checked":true
}
```

```
Modificar una tarea

PUT http://localhost:8080/tasks/{taskId}
{
	"name":"MyTask3",
	"checked":true
}
```

```
Eliminar una tarea

DELETE http://localhost:8080/tasks/{taskId}
```