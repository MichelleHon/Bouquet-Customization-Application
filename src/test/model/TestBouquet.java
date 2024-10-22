package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBouquet {

    private Bouquet testBouquet;
    private Flower testFlower1;
    private Flower testFlower2;
    private Flower testFlower3;

    @BeforeEach
    void runBefore() {
        testBouquet = new Bouquet("Mary", new ArrayList<>(), 0);
        testFlower1 = new Flower("Rose");
        testFlower2 = new Flower("Sunflower");
        testFlower3 = new Flower("Wisteria");
    }

    @Test
    void testConstructor() {
        assertEquals("Mary", testBouquet.getName());
        assertEquals(0, testBouquet.getPrice());
        assertEquals(new ArrayList<>(), testBouquet.getBouquetRequirements());
    }

    @Test
    void testAddSingleFlower() {
        testBouquet.flowerAdd(testFlower1);
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals(1, testBouquet.getBouquetRequirements().size());
    }

    @Test
    void testAddMutipleFlowers() {
        testBouquet.flowerAdd(testFlower2);
        testBouquet.flowerAdd(testFlower3);
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Wisteria", testBouquet.getBouquetRequirements().get(1).toString());
        assertEquals(2, testBouquet.getBouquetRequirements().size());
    }

    @Test
    void testAddNoFlowers() {
        assertTrue(testBouquet.getBouquetRequirements().isEmpty());
    }

    @Test
    void testRemoveOneFlower() {
        testBouquet.flowerAdd(testFlower1);
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals(1, testBouquet.getBouquetRequirements().size());
        testBouquet.flowerRemove(testFlower1);
        assertEquals(0, testBouquet.getBouquetRequirements().size());
    }

    @Test
    void testRemoveMultipleFlowers() {
        testBouquet.flowerAdd(testFlower2);
        testBouquet.flowerAdd(testFlower3);
        testBouquet.flowerAdd(testFlower1);
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Wisteria", testBouquet.getBouquetRequirements().get(1).toString());
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(2).toString());
        assertEquals(3, testBouquet.getBouquetRequirements().size());
        testBouquet.flowerRemove(testFlower3);
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(1).toString());
        assertEquals(2, testBouquet.getBouquetRequirements().size());
        testBouquet.flowerRemove(testFlower2);
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals(1, testBouquet.getBouquetRequirements().size());
    }

    @Test
    void testRemoveNonexistentFlower() {
        testBouquet.flowerAdd(testFlower1);
        testBouquet.flowerAdd(testFlower2);
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(1).toString());
        assertEquals(2, testBouquet.getBouquetRequirements().size());
        testBouquet.flowerRemove(testFlower3);
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(1).toString());
        assertEquals(2, testBouquet.getBouquetRequirements().size());
    }

    @Test
    void testSetPopBouquetOne() {
        testBouquet.addPopBouquetOne();
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Greens", testBouquet.getBouquetRequirements().get(12).toString());
        assertEquals(13, testBouquet.getBouquetRequirements().size());
    }

    @Test
    void testSetPopBouquetTwo() {
        testBouquet.addPopBouquetTwo();
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Daisy", testBouquet.getBouquetRequirements().get(17).toString());
        assertEquals(18, testBouquet.getBouquetRequirements().size());
    }

    @Test
    void testSetPopBouquetThree() {
        testBouquet.addPopBouquetThree();
        assertEquals("Tulip", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Greens", testBouquet.getBouquetRequirements().get(21).toString());
        assertEquals(22, testBouquet.getBouquetRequirements().size());
    }
}