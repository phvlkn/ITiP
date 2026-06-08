package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {
    @Test
    void shouldAddNumbers(){
        int result = 1 + 2;
        assertEquals(3, result);
    }
}
