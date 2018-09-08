# spring_boot_project_todo_sample

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