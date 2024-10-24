package persistence;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Bouquet;
import model.Flower;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Bouquet bt = new Bouquet("Customer1", new ArrayList<>(), 0);
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyBouquet() {
        try {
            Bouquet bt = new Bouquet("Customer1", new ArrayList<>(), 0);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyBouquet.json");
            writer.open();
            writer.write(bt);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyBouquet.json");
            bt = reader.read();
            assertEquals("Customer1", bt.getName());
            assertEquals(0, bt.getBouquetRequirements().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralBouquet() {
        try {
            Bouquet bt = new Bouquet("Customer1", new ArrayList<>(), 0);
            bt.flowerAdd(new Flower("rose"));
            bt.flowerAdd(new Flower("lily"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralBouquet.json");
            writer.open();
            writer.write(bt);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralBouquet.json");
            bt = reader.read();
            assertEquals("Customer1", bt.getName());
            List<Flower> flowers = bt.getBouquetRequirements();
            assertEquals(2, flowers.size());
            checkFlower("rose", flowers.get(0));
            checkFlower("lily", flowers.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
