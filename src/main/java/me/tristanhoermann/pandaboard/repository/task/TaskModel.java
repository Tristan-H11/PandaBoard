package me.tristanhoermann.pandaboard.repository.task;

import lombok.Getter;
import lombok.Setter;
import me.tristanhoermann.pandaboard.repository.database.DatabaseStub;

@Getter @Setter
public class TaskModel {

    private int id;
    private String title;
    private String content;

    public TaskModel(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static TaskModel getEmptyTask(){
        return new TaskModel(DatabaseStub.getNewTaskId(), "", "");
    }

}
