package me.xueyao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoStarterApplicationTests {

    @Mock
    private List mockObject;
    @Test
    public void contextLoads() {
        List mock = mock(List.class);
        mock.add("one");
        mock.clear();
        verify(mock).add("one");

        verify(mock).clear();


    }


    @Test
    public void testMock() {
        LinkedList mock = mock(LinkedList.class);
        when(mock.get(0)).thenReturn("first");
        //当调用mock.get(1) 然后返回运行时异常
        when(mock.get(1)).thenThrow(new RuntimeException());
        System.out.println(mock.get(0));

        System.out.println(mock.get(1));

        System.out.println(mock.get(222));

    }


    @Test
    public void testMock1() {
        List mockedList = mock(List.class);
        Assert.assertTrue(mockedList instanceof List);

        ArrayList arrayList = mock(ArrayList.class);
        Assert.assertTrue(arrayList instanceof List);

        Assert.assertTrue(arrayList instanceof ArrayList);

    }

    @Test
    public void testMockObject() {
        List mock = mock(List.class);
        when(mock.add("one")).thenReturn(true);

        when(mock.size()).thenReturn(1);

        Assert.assertTrue(mock.add("one"));
        Assert.assertFalse(mock.add("two"));

        Assert.assertEquals(mock.size(), 1);

        Iterable mock1 = mock(Iterable.class);
        when(mock1.iterator().next()).thenReturn("Hello,").thenReturn("Mockito");

        String result = mock1.iterator().next() + " " + mock1.iterator().next();
        Assert.assertEquals("Hello, Mockito!", result);
    }

    @Test
    public void testVerify() {
        List mockList = mock(List.class);

        mockList.add("one");
        mockList.add("two");
        mockList.add("three times");
        mockList.add("three times");
        mockList.add("three times");
        //mockList.isEmpty();
        when(mockList.size()).thenReturn(5);

        Assert.assertEquals(mockList.size(), 5);

        verify(mockList, atLeastOnce()).add("three times");
        verify(mockList, times(1)).add("two");
        verify(mockList, times(3)).add("three times");

        verify(mockList, never()).isEmpty();
    }


    @Test
    public void testSpy() {
        List emptyList = new LinkedList();
        List spy = spy(emptyList);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        Assert.assertEquals(spy.get(0), "one");
        Assert.assertEquals(spy.get(1), "two");

        Assert.assertEquals(spy.size(), 100);
    }

    @Test
    public void testCaptureArgument() {
        List<String> list = Arrays.asList("1", "2");
        List mockedList = mock(List.class);

        ArgumentCaptor<List> listArgumentCaptor = ArgumentCaptor.forClass(List.class);
        mockedList.addAll(list);

        verify(mockedList).addAll(listArgumentCaptor.capture());

    }

}
