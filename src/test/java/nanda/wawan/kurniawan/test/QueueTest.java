package nanda.wawan.kurniawan.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {

    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public class WhenNew {
        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("When offer size must be 1")
        void name() {
            queue.offer("Nnada");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("When offer size must be 2")
        void addAgain() {
            queue.offer("Nanda");
            queue.offer("Wawan");
            Assertions.assertEquals(2, queue.size());
        }
    }
}
