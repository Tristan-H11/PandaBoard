package me.tristanhoermann.pandaboard.service;

import me.tristanhoermann.pandaboard.repository.database.MongoHandler;
import me.tristanhoermann.pandaboard.repository.task.TaskConverter;
import me.tristanhoermann.pandaboard.repository.task.TaskModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles information traffic between the database and the Rest-API.
 */
public class TaskHandler {

    /**
     * Returns the first {@link TaskModel} with the given title, if there are multiple. Even though this should not happen.
     * @param title title of the {@link TaskModel}
     */
    public static TaskModel getTaskByTitle(final String title) {
        return TaskConverter.toTaskModel(MongoHandler.getTaskAsDocumentByTitle(title));
    }

    /**
     * Creates a {@link TaskModel} with a given title and content.
     */
    public static void createTask(final String title, final String content) {
        final TaskModel task = new TaskModel(title, content);
        MongoHandler.addTask(task);
    }

    /**
     * Returns a {@link List} of {@link TaskModel}-objects from the collection in use.
     */
    public static List<TaskModel> getTasks() {
        return MongoHandler.getAllTasksAsDocuments()
                .stream()
                .map(TaskConverter::toTaskModel)
                .collect(Collectors.toList());
    }

    public static boolean deleteTaskByTitle(final String title) {
        return MongoHandler.deleteTaskByTitle(title);
    }
}
