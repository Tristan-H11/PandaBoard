package me.tristanhoermann.pandaboard.repository.task;

import me.tristanhoermann.pandaboard.repository.database.DatabaseStub;

/**
 * Represents a {@link TaskModel} with content, title and ID.
 */
public class TaskModel {

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

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
