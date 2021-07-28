package nanda.wawan.kurniawan.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows() {

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisableOnlyOnWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testEnableOnJava8() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisableOnJava8() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_14)
    public void testEnableOnRange() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_14)
    public void testDisableOnRange() {

    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testEnableOnJavaProperties() {

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnableOnProfileDev() {

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisableOnProfileDev() {

    }

//    @Test
//    public void testSystemProperties() {
//        Properties properties = System.getProperties();
//        properties.forEach((keys, value) -> System.out.println(keys + ": " + value));
//    }
}
