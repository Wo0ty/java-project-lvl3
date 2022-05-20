package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {

    private Validator validator;
    private StringSchema schema;

    @BeforeEach
    void setup() {
        validator = new Validator();
        schema = validator.string();
    }

    @Test
    void testRequired() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("coffee beans"));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("coffee beans"));
    }

    @Test
    void testContains() {
        schema.required();

        final String sentence = "what does the fox say";

        assertTrue(schema.contains("what").isValid(sentence));
        assertFalse(schema.contains("what").isValid(sentence));
    }

    @Test
    void testMinLength() {
        final int length1 = 4;
        schema.required();
        schema.minLength(length1);

        assertFalse(schema.isValid("two"));
        assertTrue(schema.isValid("four"));
        assertTrue(schema.isValid("three"));

        final int length2 = 9;
        schema.minLength(length2);
        assertFalse(schema.isValid("seven"));
        assertFalse(schema.isValid(null));
    }
}
