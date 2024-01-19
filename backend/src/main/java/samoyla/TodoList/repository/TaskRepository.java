package samoyla.TodoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import samoyla.TodoList.entity.Task;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByType(String type);
}
