// package samoyla.TodoList.mapper;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// import samoyla.TodoList.dto.TaskDTO;
// import samoyla.TodoList.entity.Task;
// import samoyla.TodoList.mapper.TaskMapper;
// public class TaskMapperTest {

//     @Test
//     public void testTaskMapping() {
//         // Arrange
//         Task task = new Task();
//         task.setId(1L);
//         task.setContent("Sample Task");
//         task.setCompleted(false);

//         // Act
//         TaskDTO taskDTO = TaskMapper.INSTANCE.taskToTaskDto(task);
//         Task mappedTask = TaskMapper.INSTANCE.taskDtoToTask(taskDTO);

//         // Assert
//         assertEquals(task.getId(), mappedTask.getId());
//         assertEquals(task.getContent(), mappedTask.getContent());
//         assertEquals(task.isCompleted(), mappedTask.isCompleted());
//          // Print debug information
//         System.out.println("TaskDTO: " + taskDTO);
//     }
// }

