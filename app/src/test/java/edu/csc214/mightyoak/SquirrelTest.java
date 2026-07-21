package edu.csc214.mightyoak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Verifies the small Squirrel value object used by the binary tree demo.
 */
class SquirrelTest {
    @Test
    void squirrelStoresName() {
        Squirrel squirrel = new Squirrel("Cheeks");

        assertEquals("Cheeks", squirrel.getName());
    }

    @Test
    void nullNameIsRejected() {
        assertThrows(NullPointerException.class, () -> new Squirrel(null));
    }
}
