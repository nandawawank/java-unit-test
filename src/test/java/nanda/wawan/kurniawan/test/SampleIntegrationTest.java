package nanda.wawan.kurniawan.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

// Tags ini berfunsi untuk grouping setiap class yang ingin di test
// running with maven : mvn test -Dgroups=tag1,tag2
@Tags({
        @Tag("Integration-test")
})
public class SampleIntegrationTest {

    @Test
    void testOne() {

    }

    @Test
    void testTwo() {

    }
}
