package me.tristanhoermann.pandaboard.repository.task;

import org.bson.Document;

/**
 * Converts a {@link TaskModel} into other object or converts other objects into a {@link TaskModel}.
 */
public class TaskConverter {

    /**
     * Converts a {@link TaskModel} to a {@link Document} for compatability with the database.
     */
    public static Document toDocument(final TaskModel task) {
        return new Document("_id", task.getId())
                .append("title", task.getTitle())
                .append("content", task.getContent());
    }

    /**
     * Converts a {@link Document} to a {@link TaskModel}.
     */
    public static TaskModel toTaskModel(final Document doc) {
        return new TaskModel(
                doc.getInteger("_id"),
                doc.getString("title"),
                doc.getString("content"));
    }
}
