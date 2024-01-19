package samoyla.TodoList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import samoyla.TodoList.entity.Task;
import samoyla.TodoList.repository.TaskRepository;
import samoyla.TodoList.exception.TaskNotFoundException;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
    
    public Task createTask(Task task) {
        if(task.getContent() == null || task.getContent().isEmpty()) {
            throw new IllegalArgumentException("Task content cannot be empty");
        }
        return taskRepository.save(task);
    }

    public Task getTaskById(@PathVariable Long taskId) {
        if(taskId == null) throw new IllegalArgumentException("Task id cannot be null");
        return taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
    }

    public Task updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        if(taskId == null) throw new IllegalArgumentException("Task id cannot be null");
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        task.setContent(updatedTask.getContent());
        task.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(task);
    }

    public void deleteTask(@PathVariable Long taskId) {
        if(taskId == null) throw new IllegalArgumentException("Task id cannot be null");
        taskRepository.deleteById(taskId);
    }

    public Task toggleTask(@PathVariable Long taskId) {
        if(taskId == null) throw new IllegalArgumentException("Task id cannot be null");
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

    public List<Task> getTaskByType(String type){
        return taskRepository.findByType(type);
    }

    public Task updateTaskType(Long taskId, String type) {
        if(taskId == null) throw new IllegalArgumentException("Task id cannot be null");
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        task.setType(type);
        return taskRepository.save(task);
    }
}
