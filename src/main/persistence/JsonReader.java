package persistence;

import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import java.util.ArrayList;

import model.Bouquet;
import model.Flower;

// Represents a reader that reads bouquet from JSON data stored in file
// code source from JsonSerializationDemo
public class JsonReader {

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        // stub
    }

    // EFFECTS: reads bouquet from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Bouquet read() throws IOException {
        return new Bouquet("", new ArrayList<>(), 0); // stub
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return ""; // stub
    }

    // EFFECTS: parses Bouquet from JSON object and returns it
    private Bouquet parseBouquet(JSONObject jsonObject) {
        return new Bouquet("", new ArrayList<>(), 0); // stub
    }

    // EFFECTS: transforms a JSONArray to an ArrayList<Flower> and
    // parses flower from JSON object and adds it to bouquet
    private ArrayList<Flower> jsonArrayToFlowerList(JSONArray jsonArray) {
        return new ArrayList<>(); // stub
    }
}
