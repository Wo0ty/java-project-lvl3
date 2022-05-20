package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema {

    public void required() {
        super.addNewRule(data -> (data instanceof String) && (!((String) data).isEmpty()));
    }

    public StringSchema contains(String str) {
        super.addNewRule(data -> ((String) data).contains(str));
        return this;
    }

    public StringSchema minLength(int newMinLength) {
        super.addNewRule(data -> Objects.nonNull(data) && ((String) data).length() >= newMinLength);
        return this;
    }

}
