package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate<Object>> listOfRules = new LinkedList<>();

    public final <T> boolean isValid(T data) {
        for (Predicate rule: listOfRules) {
            if (!rule.test(data)) {
                return false;
            }
        }

        return true;
    }

    public final void addNewRule(Predicate<Object> rule) {
        if (!isRuleAdded(rule)) {
            this.listOfRules.add(rule);
        }
    }

    private boolean isRuleAdded(Predicate<Object> rule) {
        return listOfRules.contains(rule);
    }
}
