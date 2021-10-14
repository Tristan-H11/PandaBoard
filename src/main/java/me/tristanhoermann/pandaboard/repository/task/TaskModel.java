package me.tristanhoermann.pandaboard.repository.task;

/**
 * Represents a {@link TaskModel} with content, title and ID.
 */
public class TaskModel {

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    private final String title;
    private final String content;

    /**
     * Constructor
     * @param title The title of the task.
     * @param content The content of the task.
     */
    public TaskModel(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * Returns an empty {@link TaskModel} with a valid ID.
     */
    public static TaskModel getEmptyTask() {
        return new TaskModel("", "");
    }

}
