package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        super.addNewRule(data -> (data instanceof Map));
        return this;
    }

    public MapSchema sizeof(int requiredNumElements) {
        super.addNewRule(data -> (data == null || ((Map) data).size() == requiredNumElements));
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> rulesMap) {
        for (Map.Entry<String, BaseSchema> item: rulesMap.entrySet()) {
            String itemKey = item.getKey();
            BaseSchema rulesForItem = item.getValue();

            super.addNewRule(data -> {
                Object mapItemValue = ((Map) data).get(itemKey);
                return rulesForItem.isValid(mapItemValue);
            });
        }

        return this;
    }
}
