package util;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final Map<DataKey, Object> storage = new HashMap<>();

    public static void saveData(DataKey dataKey, Object value) {
        storage.put(dataKey, value);
    }

    public static Object getData(DataKey dataKey) {
        return storage.get(dataKey);
    }
}
