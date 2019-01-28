import exceptions.EmptyQueueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    @DisplayName("Test enqueue without priority")
    void enqueueTest() {
        int expectedSize = 2;
        Queue queue = createQueue(expectedSize);
        assertEquals(expectedSize, queue.size());
    }

    @Test
    @DisplayName("Test enqueue with priority")
    void enqueueTest_withPriority() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Johann", 42);
        queue.enqueue("Bach", 1);
        queue.enqueue("Sebastian", 10);

        String expectedResult = "Johann";
        String actualResult = queue.peek();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test dequeue")
    void dequeueTest() throws EmptyQueueException {
        Queue queue = createQueue(10);
        String expectedResult = "0";
        String actualResult = queue.dequeue().toString();
        assertEquals(expectedResult, actualResult);
    }


    @SuppressWarnings("unchecked")
    @Test
    private Queue createQueue(int size) {
        Queue queue = new Queue();

        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        return queue;
    }

}