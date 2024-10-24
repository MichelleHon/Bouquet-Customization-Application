package persistence;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import model.Bouquet;
import model.Flower;

class JsonReaderTest extends JsonTest{
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Bouquet bt = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyBouquet() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyBouquet.json");
        try {
            Bouquet bt = reader.read();
            assertEquals("Customer1", bt.getName());
            assertEquals(0, bt.getBouquetRequirements().size());
        } catch (IOException e) {
            e.printStackTrace();
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralBouquet() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralBouquet.json");
        try {
            Bouquet bt = reader.read();
            assertEquals("Customer1", bt.getName());
            ArrayList<Flower> flowers = bt.getBouquetRequirements();
            assertEquals(2, flowers.size());
            checkFlower("rose", flowers.get(0));
            checkFlower("lily", flowers.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
