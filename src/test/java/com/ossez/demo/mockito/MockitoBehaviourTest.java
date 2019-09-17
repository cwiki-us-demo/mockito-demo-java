package com.ossez.demo.mockito;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * MessagePackDataTest
 *
 * @author yhu
 */
public class MockitoBehaviourTest {

    final Logger logger = LoggerFactory.getLogger(MockitoBehaviourTest.class);

    /**
     * testMockitoBehaviour
     *
     * @see <a href="https://www.cwiki.us/pages/viewpage.action?pageId=47843416">Let's verify some behaviour</a>
     */
    @Test
    public void testMockitoBehaviour() {
        logger.debug("Test MockitoBehaviour");

        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }
}
