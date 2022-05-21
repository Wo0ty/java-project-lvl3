package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapSchemaTest {
    private Validator validator;
    private MapSchema mapSchema;

    @BeforeEach
    void setup() {
        validator = new Validator();
        mapSchema = validator.map();
    }

    @Test
    void testMapSchema() {
        assertTrue(mapSchema.isValid(null));

        mapSchema.required();

        assertTrue(mapSchema.isValid(new HashMap()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mapSchema.isValid(data));

        mapSchema.sizeof(2);

        assertFalse(mapSchema.isValid(data));
        data.put("key2", "value2");
        assertTrue(mapSchema.isValid(data));
    }

    @Test
    void testNestedValidation() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        mapSchema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        final int ageValue = 100;
        human1.put("name", "Kolya");
        human1.put("age", ageValue);
        assertTrue(mapSchema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(mapSchema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(mapSchema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        final int negativeAgeValue = -10;
        human4.put("name", "Valya");
        human4.put("age", negativeAgeValue);
        assertFalse(mapSchema.isValid(human4));

    }
}
