package samoyla.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import samoyla.todo_list.entity.Task;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByType(String type);
}
