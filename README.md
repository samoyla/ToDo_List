# ToDo_List
simple todo list with java spring boot and postgreSQL

First run a docker with a db: docker-compose up -d
to check the docker id: docker ps
to open the docker to check the db: docker exec -it docker_id bash, then psql -U sam data_base
for data_base:
- \l list of db
- \c data_base (connected as sam)
- SELECT * FROM tasks; to see all, etc...

Once the docker with db is running, ./mvnw spring-boot:run ('cause i was using vscode, not a intellij IDEA)
while the spring boot app is running, open insomnia to check all the requests: 
- GET: localhost:8080/tasks
- PUT: localhost:8080/tasks + Body: (JSON representing the task)
- GET /tasks/{taskId}: Retrieve a task by ID.
- PUT /tasks/{taskId}: Update a task by ID (provide JSON in the request body).
- DELETE /tasks/{taskId}: Delete a task by ID.
- PATCH /tasks/{taskId}/complete: Mark a task as completed.
- PATCH /tasks/{taskId}/undo: Mark a task as undone.

to stop the docker: docker stop docker_id
docker rm docker-id
docker system prune -af
