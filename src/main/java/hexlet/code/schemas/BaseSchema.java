package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate<Object>> rules = new LinkedList<>();

    public final <T> boolean isValid(T data) {
        for (Predicate rule: rules) {
            if (!rule.test(data)) {
                return false;
            }
        }

        return true;
    }

    public final void addNewRule(Predicate<Object> rule) {
        this.rules.add(rule);
    }
}
