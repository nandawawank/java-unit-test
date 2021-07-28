package nanda.wawan.kurniawan.test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {
    private String temp;

    @Test
    void testA() {
        temp = "Nanda";
    }

    @Test
    void testB() {
        System.out.println(temp);
    }
}
