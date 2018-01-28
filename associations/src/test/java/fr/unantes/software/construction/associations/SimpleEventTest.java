package fr.unantes.software.construction.associations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 27/01/2018.
 *
 * @author sunye.
 */
class SimpleEventTest {

    Event evt1;

    @BeforeEach
    void setUp() {
        evt1 = new SimpleEvent(Integer.valueOf(1));
    }

    @Test
    void testId() {
        assertEquals(Integer.valueOf(1), evt1.getId());
    }

    @Test
    void testName() {
        String expected = "Alice";
        evt1.setName(new String(expected));

        assertEquals(expected, evt1.getName());
    }

    @Test
    void testLocation() {
        String expected = "Nantes";
        evt1.setLocation(new String(expected));

        assertEquals(expected, evt1.getLocation());
    }

    @Test
    void testAddContacts() {
        Stream<Contact> contacts = Stream.of(new SimpleContact(), new SimpleContact(),
                new SimpleContact(),new SimpleContact());

        contacts.forEach(each -> evt1.invitees().add(each));

        assertTrue(contacts.allMatch(each -> evt1.invitees().contains(each)));

        contacts.forEach(each -> evt1.invitees().remove(each));

        assertTrue(evt1.invitees().size() == 0);
    }

}