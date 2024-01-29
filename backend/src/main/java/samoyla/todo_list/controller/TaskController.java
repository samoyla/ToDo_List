package samoyla.todo_list.controller;

import java.util.List;

import org.springframework.lang.NonNull;
import samoyla.todo_list.dto.TaskDto;
import samoyla.todo_list.entity.Task;
import samoyla.todo_list.service.TaskService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE}, allowedHeaders = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    /*
    TODO: Make each controller method return ResponseEntity

    1. Delete should return 204 on success
    2. Create should return 201 on success
    ------------------------
    Still very hard to use the API without swagger

    ------------------------

    Use spring @NonNull annotation instead of checking manually null in service

    ------------------------

    Make update take DTO instead of using entity
     */

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    //here is an example of @NonNull annotation
    @PostMapping
    public Task createTask(@NonNull @RequestBody TaskDto task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@NonNull @PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        return taskService.updateTask(taskId, updatedTask);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PatchMapping("/{taskId}/toggle")
    public Task toggleTask(@PathVariable Long taskId) {
        return taskService.toggleTask(taskId);
    }

    @GetMapping("/type/{type}")
    public List<Task> getTasksByType(@PathVariable String type) {
        return taskService.getTaskByType(type);
    }

    //Better to change tasktype inside PUT/PATCH /tasks/{taskId}. No need to create a separate method
    @PatchMapping("/{taskId}/type")
    public Task updateTaskType(@PathVariable Long taskId, @RequestParam String type) {
        return taskService.updateTaskType(taskId, type);
    }
    

}
