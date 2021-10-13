package me.tristanhoermann.pandaboard.service;

import me.tristanhoermann.pandaboard.repository.database.DatabaseStub;
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
     * Returns the first {@link TaskModel} with the given ID, if there are multiple. Even though this should not happen.
     * @param id ID of the {@link TaskModel}
     */
    public static TaskModel getTaskById(final int id) {
        return TaskConverter.toTaskModel(MongoHandler.getTaskAsDocumentById(id));
    }

    /**
     * Creates a {@link TaskModel} with a given title and content. Increments the ID automatically.
     * TODO find a good way for incrementing the ID without the stub.
     */
    public static void createTask(final String title, final String content) {
        final TaskModel task = new TaskModel(DatabaseStub.getNewTaskId(), title, content);
        DatabaseStub.addTask(task);
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
}
