package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    private Validator validator;
    private MapSchema mapSchema;

    @BeforeEach
    void setup() {
        validator = new Validator();
        mapSchema = validator.map();
    }

    @Test
    void testMapSchema() {
        assertTrue(mapSchema.isValid(null)); // true

        mapSchema.required();

        assertFalse(mapSchema.isValid(null));// false
        assertTrue(mapSchema.isValid(new HashMap())); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mapSchema.isValid(data)); // true

        mapSchema.sizeof(2);

        assertFalse(mapSchema.isValid(data));  // false
        data.put("key2", "value2");
        assertTrue(mapSchema.isValid(data)); // true

    }
}
