package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {


    public NumberSchema required() {
        super.addNewRule(data -> (data instanceof Integer && (int) data >= 0));
        return this;
    }

    public NumberSchema positive() {
        super.addNewRule(data -> (data instanceof Integer && (int) data > 0));
        return this;
    }

    public NumberSchema range(int minValue, int maxValue) {
        super.addNewRule(data -> (data instanceof Integer && (int) data >= minValue && (int) data <= maxValue));
        return this;
    }

}
