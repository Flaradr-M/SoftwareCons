package fr.unantes.software.construction.associations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 27/01/2018.
 *
 * @author sunye.
 */
class SimpleTaskTest {

    private Task task1;

    @BeforeEach
    void setup() {
        task1 = new SimpleTask();
    }

    @Test
    void testTitle() {
        String expected = "My Task";
        task1.setTitle(new String(expected));

        assertEquals(expected, task1.getTitle());
    }


    @Test
    void testEventSet() {
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        task1.event().set(evt1);

        assertEquals(task1, evt1.task().get());
        assertEquals(evt1, task1.event().get());
    }

    @Test
    void testHandshake() {
        Task task2 = new SimpleTask();
        Task task3 = new SimpleTask();
        Event evt1 = new SimpleEvent(Integer.valueOf(1));

        task2.event().set(evt1);
        task3.event().set(evt1);

        assertEquals(evt1.task().get(), task3);
        assertFalse(task2.event().isSet());
    }

    @Test
    void testCompleteHandshake() {
        Task task2 = new SimpleTask();
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        Event evt2 = new SimpleEvent(Integer.valueOf(2));

        task1.event().set(evt1);
        task2.event().set(evt2);

        task2.event().set(evt1);

        assertFalse(evt2.task().isSet());
        assertFalse(task1.event().isSet());

    }

    @Test
    void testUnset() {
        Task task2 = new SimpleTask();
        Event evt1 = new SimpleEvent(Integer.valueOf(1));

        task2.event().set(evt1);
        task2.event().unset();

        assertFalse(task2.event().isSet());
        assertFalse(evt1.task().isSet());
    }

}