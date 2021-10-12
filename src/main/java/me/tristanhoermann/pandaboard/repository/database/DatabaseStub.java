package me.tristanhoermann.pandaboard.repository.database;

import me.tristanhoermann.pandaboard.repository.task.TaskModel;

import java.util.LinkedList;

/**
 * Simple Stub for checking if the requests work.
 */
@Deprecated
public class DatabaseStub {

    private static final LinkedList<TaskModel> tasks = new LinkedList<>();

    /**
     * Adds a task to the list.
     */
    public static void addTask(final TaskModel task){
        tasks.add(task);
    }

    /**
     * Counts existing tasks and returns count+1 for a new ID.
     */
    public static int getNewTaskId(){
        return tasks.size();
    }

}
