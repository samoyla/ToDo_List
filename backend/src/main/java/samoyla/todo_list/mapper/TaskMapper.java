package samoyla.todo_list.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import samoyla.todo_list.dto.TaskDto;
import samoyla.todo_list.entity.Task;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TaskMapper{
    /* use more simple method names, because you use it like
        private final TaskMapper taskMapper;

        taskMapper.toEntity(taskDto) //no need to precise from what, only to what
     */
    @Mapping(target = "id", ignore = true)
    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDTO);

    List<TaskDto> toDtoList(List<Task> tasks);
}
