package me.tristanhoermann.pandaboard.repository.task;

import lombok.Getter;
import lombok.Setter;
import me.tristanhoermann.pandaboard.repository.database.DatabaseStub;

/**
 * Represents a {@link TaskModel} with content, title and ID.
 */
public class TaskModel {

    private int id;
    private String title;
    private String content;

    /**
     * Constructor
     * @param id The ID, the task should have.
     * @param title The title of the task.
     * @param content The content of the task.
     */
    public TaskModel(final int id, final String title, final String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    /**
     * Returns an empty {@link TaskModel} with a valid ID.
     */
    public static TaskModel getEmptyTask(){
        return new TaskModel(DatabaseStub.getNewTaskId(), "", "");
    }

}
