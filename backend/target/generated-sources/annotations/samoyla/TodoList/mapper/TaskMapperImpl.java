package samoyla.TodoList.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import samoyla.TodoList.dto.TaskDTO;
import samoyla.TodoList.entity.Task;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T13:30:49+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2-ea (Private Build)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO taskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setContent( task.getContent() );
        taskDTO.setCompleted( task.isCompleted() );
        taskDTO.setType( task.getType() );

        return taskDTO;
    }

    @Override
    public Task taskDtoToTask(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskDTO.getId() );
        task.setContent( taskDTO.getContent() );
        task.setCompleted( taskDTO.isCompleted() );
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
