package samoyla.TodoList.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import samoyla.TodoList.dto.TaskDTO;
import samoyla.TodoList.entity.Task;

@Mapper
@Component
public interface TaskMapper{
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(target = "id", ignore = true)
    TaskDTO taskToTaskDto(Task task);

    Task taskDtoToTask(TaskDTO taskDTO);

    List<TaskDTO> tasksToTaskDTOs(List<Task> tasks);
}
