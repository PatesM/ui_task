package org.example.steps.asserts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertWildberriesUiTests {

    public static void assertionTextCorrect(String expectedText, String actualText) {
        assertEquals(expectedText, actualText);
    }

    public static void assertionElementIsActive(boolean webElementCondition) {
        assertTrue(webElementCondition);
    }
}
