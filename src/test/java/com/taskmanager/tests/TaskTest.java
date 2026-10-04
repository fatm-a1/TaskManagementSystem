package com.taskmanager.tests;

import com.taskmanager.Task;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    Task task;

    @BeforeEach
    void setup() {
        task = new Task("Study", 3);
    }

    @Test
    void testCreateTask() {
        assertEquals("Study", task.getTitle());
    }

    @Test
    void testComplete() {
        task.markCompleted();
        assertTrue(task.isCompleted());
    }
}