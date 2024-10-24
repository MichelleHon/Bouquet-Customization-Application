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
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads bouquet from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Bouquet read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBouquet(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Bouquet from JSON object and returns it
    private Bouquet parseBouquet(JSONObject jsonObject) {
        String cusName = jsonObject.getString("CusName");
        JSONArray jsonArray = jsonObject.getJSONArray("flowers");
        ArrayList<Flower> flowerArray = jsonArrayToFlowerList(jsonArray);
        int price = jsonObject.getInt("price");
        Bouquet bt = new Bouquet(cusName, flowerArray, price);
        return bt;
    }

    // EFFECTS: transforms a JSONArray to an ArrayList<Flower> and
    // parses flower from JSON object and adds it to bouquet
    private ArrayList<Flower> jsonArrayToFlowerList(JSONArray jsonArray) {
        ArrayList<Flower> flowerList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject flowerObject = jsonArray.getJSONObject(i);
            String flowerName = flowerObject.getString("flowerName");
            Flower flower = new Flower(flowerName);
            flowerList.add(flower);
        }
        return flowerList;
    }
}
