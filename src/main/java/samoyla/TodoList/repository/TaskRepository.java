package samoyla.TodoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import samoyla.TodoList.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
