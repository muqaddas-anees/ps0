package rules;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    // Test when code is not written by the user, but available to others, cited, and doesn't require implementation
    @Test
    public void testAvailableCitedNotRequired() {
        assertTrue("Expected true: code not written by yourself but available to others, cited, and doesn't require implementation",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    // Test when code is not written by the user, not available to others, even if cited
    @Test
    public void testNotAvailableEvenIfCited() {
        assertFalse("Expected false: code not written by yourself, not available to others, even if cited",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, true, false));
    }

    // Test when code is not written by the user, available to others, but requires implementation
    @Test
    public void testAvailableRequiresImplementation() {
        assertFalse("Expected false: code not written by yourself, available to others, but requires implementation",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, true));
    }

    // Test when code is written by yourself and implementation is not required
    @Test
    public void testSelfWrittenNotRequired() {
        assertTrue("Expected true: code written by yourself and implementation is not required",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, true, false));
    }
}
