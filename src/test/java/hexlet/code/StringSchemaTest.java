package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {
    private Validator validator;
    private StringSchema stringSchema;

    @BeforeEach
    void setup() {
        validator = new Validator();
        stringSchema = validator.string();
    }

    @Test
    void testRequired() {
        assertTrue(stringSchema.isValid(""));
        assertTrue(stringSchema.isValid(null));
        assertTrue(stringSchema.isValid("coffee beans"));

        stringSchema.required();
        assertFalse(stringSchema.isValid(null));
        assertFalse(stringSchema.isValid(""));
        assertTrue(stringSchema.isValid("coffee beans"));
    }

    @Test
    void testContains() {
        stringSchema.required();

        final String sentence = "what does the fox say";

        assertTrue(stringSchema.contains("what").isValid(sentence));
        assertFalse(stringSchema.contains("whatth").isValid(sentence));
    }

    @Test
    void testMinLength() {
        final int length1 = 4;
        stringSchema.required();
        stringSchema.minLength(length1);

        assertFalse(stringSchema.isValid("two"));
        assertTrue(stringSchema.isValid("four"));
        assertTrue(stringSchema.isValid("three"));

        final int length2 = 9;
        stringSchema.minLength(length2);
        assertFalse(stringSchema.isValid("seven"));
        assertFalse(stringSchema.isValid(null));
    }
}
