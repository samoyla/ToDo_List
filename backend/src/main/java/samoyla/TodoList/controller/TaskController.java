package samoyla.TodoList.controller;

import java.util.List;
import samoyla.TodoList.entity.Task;
import samoyla.TodoList.service.TaskService;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE}, allowedHeaders = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    

    private final TaskService taskService;

    //@Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
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

    @PatchMapping("/{taskId}/type")
    public Task updateTaskType(@PathVariable Long taskId, @RequestParam String type) {
        return taskService.updateTaskType(taskId, type);
    }
    

}
