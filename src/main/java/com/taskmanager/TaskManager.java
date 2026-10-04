package com.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        if (!tasks.contains(task)) {
            throw new IllegalArgumentException("Task not found");
        }
        tasks.remove(task);
    }

    public List<Task> getCompletedTasks() {

        List<Task> result = new ArrayList<>();

        for (Task t : tasks) {
            if (t.isCompleted()) {
                result.add(t);
            }
        }

        return result;
    }

    public Task getHighestPriorityTask() {

        if (tasks.isEmpty()) {
            throw new IllegalStateException("No tasks");
        }

        Task best = tasks.get(0);

        for (Task t : tasks) {
            if (t.getPriority() > best.getPriority()) {
                best = t;
            }
        }

        return best;
    }
}