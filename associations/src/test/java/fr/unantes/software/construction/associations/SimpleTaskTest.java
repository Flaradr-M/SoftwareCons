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

    private Task task1 = new SimpleTask();

    @BeforeEach
    void setup() {


    }

    @Test
    void testTitle() {
        String expected = "My Task";

        task1.setTitle(new String(expected));

        Assertions.assertEquals(expected, task1.getTitle());
    }

    @Test
    void testCursorInvalid() {
        TaskEventCursor cursor = task1.event();
        assertFalse(cursor.valid());
    }

    @Test
    void testEventInsert() {
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        task1.event().insert(evt1);

        assertTrue(task1.event().valid());

        assertTrue(evt1.task().valid());
    }

    @Test
    void testEventInsertAndSetName() {
        String expected = "second";
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        evt1.setName("first");

        task1.event().insert(evt1);
        task1.event().setName(expected);

        assertEquals(expected, task1.event().getName());
    }

    @Test
    void testEventInsertAndAddAlarm() {
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        evt1.addAlarm(Integer.valueOf(44));

        task1.event().insert(evt1);
        task1.event().addAlarm(Integer.valueOf(99));

        assertEquals(evt1.getAlarm(0), task1.event().getAlarm(0));
        assertEquals(evt1.getAlarm(1), task1.event().getAlarm(1));

    }

    @Test
    void testEventInsertAndSetLocation() {
        String expected = "another location";
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        evt1.setLocation("a location");

        task1.event().insert(evt1);
        task1.event().setLocation(expected);

        assertEquals(expected, task1.event().getLocation());
    }

    @Test
    void testEventInsertRemove() {
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        Event evt2 = new SimpleEvent(Integer.valueOf(2));

        task1.event().insert(evt1);
        task1.event().insert(evt2);

        assertFalse(evt1.task().valid());
        assertTrue(evt2.task().valid());
    }

}