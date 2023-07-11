package com.kepler;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;


@ExtendWith(MockitoExtension.class)
@Slf4j
public class MockitoTest {

    @Test
    public void test1() {
        List<Integer> mockedList1 = Mockito.mock(ArrayList.class);
        mockedList1.add(1);
        mockedList1.add(2);
        log.info("This method do nothing");
        mockedList1.forEach(n -> log.info(n.toString()));
    }

    @Mock
    List<Integer> mockedList2;
    @Test
    public void test2() {
        mockedList2.add(1);
        mockedList2.add(2);
        log.info("This method do nothing");
        mockedList2.forEach(n -> log.info(n.toString()));
    }

    @Spy
    List<Integer> mockedList3;
    @Test
    public void test3() {
        mockedList3 = new ArrayList<>();
        mockedList3.add(1);
        mockedList3.add(2);
        log.info("This method adding elements to list: {}", mockedList3);
    }

    @Test
    public void test4() {
        Mockito.doReturn(10).when(mockedList2).size();
        assertEquals(10, mockedList2.size());
    }

    @Test
    public void test5() {
        Mockito.when(mockedList2.size()).thenReturn(30);
        assertEquals(30, mockedList2.size());
    }

    @Test
    public void test6() {
        Mockito.when(mockedList2.size()).thenThrow(IllegalStateException.class);

        assertThrows(IllegalStateException.class, () -> mockedList2.size());
    }

    @Test
    public void test7() {
        Mockito.doThrow(new ArithmeticException()).when(mockedList2).size();

        assertThrows(ArithmeticException.class, () -> mockedList2.size());
    }

    @Mock
    List<String> mockedList4;
    @Test
    public void test8() {
        Mockito.doReturn("OLOLO").when(mockedList4).get(500);
        assertEquals("OLOLO", mockedList4.get(500));
    }

    @Test
    public void test9() {
        Mockito.doReturn("TROLOLO").when(mockedList4).get(anyInt());
        assertEquals("TROLOLO", mockedList4.get(100500));
    }

    @Test
    public void test10() {
        Mockito.doAnswer(invocation -> {
            int parameter = invocation.getArgument(0);
            return parameter * parameter;
        }).when(mockedList2).get(anyInt());

        assertEquals(100, mockedList2.get(10));
        assertEquals(4, mockedList2.get(2));
    }

    @Test
    public void test11() {
        int size = mockedList4.size(); // if remove this call -> verify not passed!
        Mockito.verify(mockedList4).size();
    }

    @Test
    public void test12() {
        int size1 = mockedList4.size();
        int size2 = mockedList4.size();
        int size3 = mockedList4.size();
        Mockito.verify(mockedList4, Mockito.times(3)).size();
    }

    @Test
    public void test13() {
        int size = mockedList4.size();
        mockedList4.add("ha-ha-ha");
        mockedList4.clear();

        InOrder orderVerify = Mockito.inOrder(mockedList4);
        orderVerify.verify(mockedList4).size();
        orderVerify.verify(mockedList4).add(anyString());
        orderVerify.verify(mockedList4).clear();
    }

    @Test
    public void test14() {
        Mockito.when(mockedList4.size()).thenThrow(IllegalStateException.class);
        assertThrows(IllegalStateException.class, () -> mockedList4.size());
    }

}
