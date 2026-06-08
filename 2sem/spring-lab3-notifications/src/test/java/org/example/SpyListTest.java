package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class SpyListTest {

    @Test
    void shouldSpyListAndVerifyAdd() {
        List<String> list = spy(new ArrayList<>());

        list.add("one");
        list.add("two");

        verify(list, times(1)).add("one");
        verify(list, times(1)).add("two");
        verify(list, times(2)).add(anyString());
    }
}