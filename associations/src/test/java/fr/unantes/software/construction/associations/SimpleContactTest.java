package fr.unantes.software.construction.associations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 27/01/2018.
 *
 * @author sunye.
 */
class SimpleContactTest {
    private Contact ctc1;

    @BeforeEach
    void setup() {
        ctc1 = new SimpleContact();
    }

    @Test
    void testFirstName() {
        String expected = "##@##";

        assertEquals(expected, ctc1.getFirstName());

    }

    @Test
    void testLastName() {
        String expected = "##@##";

        assertEquals(expected, ctc1.getLastName());
    }
}