package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        super.addNewRule(data -> (data instanceof Map<?, ?>));
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addNewRule(data -> (data instanceof Map<?, ?> && ((Map<?, ?>) data).size() == size));
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        for (Map.Entry<String, BaseSchema> item: map.entrySet()) {
            String itemKey = item.getKey();
            BaseSchema rulesForItem = item.getValue();
            super.addNewRule(data -> data instanceof Map<?, ?>
                    && ((Map<?, ?>) data).containsKey(itemKey)
                    && rulesForItem.isValid(((Map<?, ?>) data).get(itemKey)));
        }

        return this;
    }
}
