package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void testInstantStringSchema() {
        Validator v = new Validator();

        Assertions.assertTrue(v.string() instanceof StringSchema);
        Assertions.assertTrue(v.number() instanceof NumberSchema);
    }


}
