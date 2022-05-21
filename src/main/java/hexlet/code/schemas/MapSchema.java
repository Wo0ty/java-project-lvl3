package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        super.addNewRule(data -> (data instanceof Map<?,?>));
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addNewRule(data -> (data instanceof Map<?,?> && ((Map<?,?>) data).size() == size));
        return this;
    }

}
