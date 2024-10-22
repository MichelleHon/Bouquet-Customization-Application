package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFlower {

    private Flower testFlower;
    private Bouquet testBouquet;

    @BeforeEach
    void runBefore() {
        testFlower = new Flower("Rose");
        testBouquet = new Bouquet("Mary", new ArrayList<>(), 0);
    }

    @Test
    void testConstructor() {
        assertEquals("Rose", testFlower.getFlowerName());
    }

    @Test
    void testToString() {
        testBouquet.flowerAdd(testFlower);
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals(1, testBouquet.getBouquetRequirements().size());
    }
}
