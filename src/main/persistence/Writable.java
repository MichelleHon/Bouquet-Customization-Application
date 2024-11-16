package persistence;

import org.json.JSONObject;

// An interface for objects that can be serialized into a 
// JSON representation

// code source from JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
