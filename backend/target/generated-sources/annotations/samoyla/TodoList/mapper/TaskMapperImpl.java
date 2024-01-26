package samoyla.TodoList.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import samoyla.TodoList.dto.TaskDTO;
import samoyla.TodoList.entity.Task;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-26T15:27:41+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240103-0614, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO taskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setCompleted( task.isCompleted() );
        taskDTO.setContent( task.getContent() );
        taskDTO.setType( task.getType() );

        return taskDTO;
    }

    @Override
    public Task taskDtoToTask(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        Task task = new Task();

        task.setCompleted( taskDTO.isCompleted() );
        task.setContent( taskDTO.getContent() );
        task.setId( taskDTO.getId() );
        task.setType( taskDTO.getType() );

        return task;
    }

    @Override
    public List<TaskDTO> tasksToTaskDTOs(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<TaskDTO> list = new ArrayList<TaskDTO>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( taskToTaskDto( task ) );
        }

        return list;
    }
}
