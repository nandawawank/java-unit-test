package nanda.wawan.kurniawan.test;

import org.junit.jupiter.api.*;

@DisplayName("Information Test")
public class InformationTest {

    @Test
    @Tags({
            @Tag("one"),
            @Tag("Two")
    })
    @DisplayName("This is test")
    void test(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestClass().orElse(null));
        System.out.println(testInfo.getTestMethod().orElse(null));
    }
}
