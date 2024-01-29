package samoyla.todo_list.dto;


public class TaskDto {
    private Long id;
    private String content;
    private boolean completed;
    private String type;

    public TaskDto() {
    }

    public TaskDto(Long id, String content, boolean completed, String type) {
        this.id = id;
        this.content = content;
        this.completed = completed;
        this.type = type;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}


/*
Same class but using lombok

@Value
public class TaskDto {
    Long id;
    String content;
    boolean completed;
    String type;
}
 */
