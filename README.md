# Валидатор данных:
[![hexlet-check](https://github.com/Wo0ty/java-project-lvl3/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Wo0ty/java-project-lvl3/actions/workflows/hexlet-check.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/f4a382037d3e7bd2ade4/maintainability)](https://codeclimate.com/github/Wo0ty/java-project-lvl3/maintainability)
[![Java CI](https://github.com/Wo0ty/java-project-lvl3/actions/workflows/main.yml/badge.svg)](https://github.com/Wo0ty/java-project-lvl3/actions/workflows/main.yml)
[![Test Coverage](https://api.codeclimate.com/v1/badges/f4a382037d3e7bd2ade4/test_coverage)](https://codeclimate.com/github/Wo0ty/java-project-lvl3/test_coverage)

### Описание
Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями. За основу для проекта взята библиотека yup.

### Пример использования
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false
        
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true
        
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```

