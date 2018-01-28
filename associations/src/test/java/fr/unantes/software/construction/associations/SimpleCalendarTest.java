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
class SimpleCalendarTest {

    private Calendar cal1;

    @BeforeEach
    void setUp() {
        cal1 = new SimpleCalendar();
    }

    @Test
    void testName() {
        String expected = "##@##";
        cal1.setName(new String(expected));

        assertEquals(expected, cal1.getName());
    }

    @Test
    void testDescription() {
        String expected = "##@##";
        cal1.setDescription(new String(expected));

        assertEquals(expected, cal1.getDescription());
    }


}