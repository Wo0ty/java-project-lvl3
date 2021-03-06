package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumberSchemaTest {
    private Validator validator;
    private NumberSchema numberSchema;

    @BeforeEach
    void setup() {
        validator = new Validator();
        numberSchema = validator.number();
    }

    @Test
    void testRequired() {
        assertTrue(numberSchema.isValid(null));
        assertTrue(numberSchema.isValid(new Object()));
        assertTrue(numberSchema.isValid("coffee"));

        numberSchema.required();
        assertFalse(numberSchema.isValid(null));

        final int positiveValue = 10;
        final int negativeValue = -10;
        assertTrue(numberSchema.isValid(positiveValue));
        assertTrue(numberSchema.isValid(negativeValue));
        assertTrue(numberSchema.isValid(0));
        assertFalse(numberSchema.isValid("5"));
        assertFalse(numberSchema.isValid(new Object()));

    }

    @Test
    void testPositive() {
        final int negativeValue = 10;
        final int positiveValue = -10;

        assertTrue(numberSchema.positive().isValid(negativeValue));
        assertFalse(numberSchema.isValid(positiveValue));
        assertFalse(numberSchema.isValid(0));
        assertFalse(numberSchema.isValid("5"));
        assertFalse(numberSchema.isValid(new Object()));
        assertTrue(numberSchema.isValid(null));
    }

    @Test
    void testRange() {
        final int start = 5;
        final int end = 10;
        numberSchema.range(start, end);

        assertTrue(numberSchema.isValid(start));
        assertTrue(numberSchema.isValid(end));

        final int value3 = 4;
        final int value4 = 11;
        assertFalse(numberSchema.isValid(value3));
        assertFalse(numberSchema.isValid(value4));
    }
}
