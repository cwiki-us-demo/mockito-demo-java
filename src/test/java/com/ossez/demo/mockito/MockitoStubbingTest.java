package com.ossez.demo.mockito;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * MockitoStubbingTest
 *
 * @author yhu
 */
public class MockitoStubbingTest {

    final Logger logger = LoggerFactory.getLogger(MockitoStubbingTest.class);

    /**
     * testMockitoStubbing
     *
     * @see <a href="https://www.cwiki.us/pages/viewpage.action?pageId=47843418">How about some stubbing</a>
     */
    @Test
    public void testMockitoStubbing() {
        logger.debug("Test MockitoStubbing");

        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        // If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        // If your code doesn't care what get(0) returns, then it should not be stubbed.
        verify(mockedList).get(0);
    }
}
