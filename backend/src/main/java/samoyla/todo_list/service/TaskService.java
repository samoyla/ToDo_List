package samoyla.todo_list.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import samoyla.todo_list.dto.TaskDto;
import samoyla.todo_list.entity.Task;
import samoyla.todo_list.mapper.TaskMapper;
import samoyla.todo_list.repository.TaskRepository;
import samoyla.todo_list.exception.TaskNotFoundException;

@Service
public class TaskService {
    /*
    TODO:
    Make all methods take and return Dto instead of entity
     */
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
    
    public Task createTask(TaskDto taskDto) {
        //In the controller you will find @NonNull annotation
        if(taskDto.getContent() == null || taskDto.getContent().isEmpty()) {
            throw new IllegalArgumentException("Task content cannot be empty");
        }
        return taskRepository.save(taskMapper.toEntity(taskDto));
    }

    public Task getTaskById(@PathVariable Long taskId) {
        // use {} everywhere
        if(taskId == null) throw new IllegalArgumentException("Task id cannot be null");
        //TaskNotFoundException doesn't returns 500 status, you should look on ControllerAdvice if you want
        //make custom exception return your custom message and custom http status

        // and in this case better to use ResourceNotFoundException of spring (it should return 404)
        return taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
    }

    //TODO make it take DTO
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
