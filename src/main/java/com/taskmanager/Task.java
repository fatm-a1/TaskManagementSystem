package com.taskmanager;

public class Task {

    private String title;
    private int priority;
    private boolean completed;

    public Task(String title, int priority) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Priority must be 1-5");
        }

        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }
}