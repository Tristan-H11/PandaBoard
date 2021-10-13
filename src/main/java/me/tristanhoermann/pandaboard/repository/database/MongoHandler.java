package me.tristanhoermann.pandaboard.repository.database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import me.tristanhoermann.pandaboard.repository.task.TaskConverter;
import me.tristanhoermann.pandaboard.repository.task.TaskModel;
import org.bson.Document;

import java.util.LinkedList;

/**
 * Handles in- and outgoing queries from or to the database.
 */
public class MongoHandler {

    private static MongoClient mongoClient;
    private static MongoCollection<Document> collection;

    /**
     * Connects to the database and opens a given database and collection.
     */
    public static void connectAndOpenDB(final String database, final String collection) {
        openConnection();
        openDatabase(database, collection);
    }

    /**
     * Dumps a {@link TaskModel} to the database.
     */
    public static void addTask(final TaskModel task) {
        collection.insertOne(TaskConverter.toDocument(task));
    }

    /**
     * Queries the database for a {@link TaskModel} with the given ID and returns it as a {@link Document}.
     */
    public static Document getTaskAsDocumentByTitle(final String title) {
        final BasicDBObject field = new BasicDBObject("title", title);
        return collection.find(field).first();
    }

    /**
     * Returns a {@link java.util.List} of {@link Document}s containing all tasks existing in the used collection.
     */
    public static LinkedList<Document> getAllTasksAsDocuments() {
        final LinkedList<Document> documentList = new LinkedList<>();

        try (final MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                documentList.add(cursor.next());
            }
        }
        return documentList;
    }

    /**
     * Finds and deletes a {@link TaskModel} in the database.
     */
    public static boolean deleteTaskByTitle(final String title) {
        final BasicDBObject field = new BasicDBObject("title", title);
        return collection.deleteOne(field).getDeletedCount()== 1.0;
    }

    private static void openConnection() {
        mongoClient = new MongoClient(
                new MongoClientURI("mongodb://localhost:27017")
        );
    }

    private static void openDatabase(final String databaseName, final String collectionName) {
        final MongoDatabase database = mongoClient.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
    }
}
