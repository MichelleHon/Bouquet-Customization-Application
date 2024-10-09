package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBouquet {
    
    private Bouquet testBouquet;
    
    @BeforeEach
    void runBefore() {
        testBouquet = new Bouquet("Mary", 0);
    }

    @Test
    void testConstructor() {
        assertEquals("Mary", testBouquet.getName());
        assertEquals(0, testBouquet.getPrice());
    }

    @Test
    void testAddSingleFlower() {
        testBouquet.aFlower("Rose");
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertEquals("Rose", flowerName.get(0));
        assertEquals(1, flowerName.size());
    }

    @Test
    void testAddMutipleFlowers() {
        testBouquet.aFlower("Sunflower");
        testBouquet.aFlower("Wisteria");
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertEquals("Sunflower", flowerName.get(0));
        assertEquals("Wisteria", flowerName.get(1));
        assertEquals(2, flowerName.size());
    }

    @Test
    void testAddNoFlowers() {
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertTrue(flowerName.isEmpty());
    }

    @Test
    void testRemoveOneFlower() {
        testBouquet.aFlower("Tulip");
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertEquals("Tulip", flowerName.get(0));
        assertEquals(1, flowerName.size());
        testBouquet.rFlower("Tulip");
        assertEquals(0, flowerName.size());
    }

    @Test
    void testRemoveMultipleFlowers() {
        testBouquet.aFlower("Daisy");
        testBouquet.aFlower("Lavender");
        testBouquet.aFlower("Lilac");
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertEquals("Daisy", flowerName.get(0));
        assertEquals("Lavender", flowerName.get(1));
        assertEquals("Lilac", flowerName.get(2));
        assertEquals(3, flowerName.size());
        testBouquet.rFlower("Lavender");
        assertEquals("Daisy", flowerName.get(0));
        assertEquals("Lilac", flowerName.get(1));
        assertEquals(2, flowerName.size());
        testBouquet.rFlower("Daisy");
        assertEquals("Lilac", flowerName.get(0));
        assertEquals(1, flowerName.size());
    }

    @Test
    void testRemoveNonexistentFlower() {
        testBouquet.aFlower("Lily");
        testBouquet.aFlower("Snowdrop");
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertEquals("Lily", flowerName.get(0));
        assertEquals("Snowdrop", flowerName.get(1));
        assertEquals(2, flowerName.size());
        testBouquet.rFlower("Rose");
        assertEquals("Lily", flowerName.get(0));
        assertEquals("Snowdrop", flowerName.get(1));
        assertEquals(2, flowerName.size());
    }

    @Test
    void testPopBouquetOne() {
        testBouquet.popularBouquetOne();
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertEquals("Rose", flowerName.get(0));
        assertEquals("Rose", flowerName.get(6));
        assertEquals("Rose", flowerName.get(11));
        assertEquals("Greens", flowerName.get(12));
        assertEquals(13, flowerName.size());
    }

    @Test
    void testPopBouquetTwo() {
        testBouquet.popularBouquetTwo();
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertEquals("Sunflower", flowerName.get(0));
        assertEquals("Daisy", flowerName.get(1));
        assertEquals("Lily", flowerName.get(2));
        assertEquals("Snowdrop", flowerName.get(3));
        assertEquals("Greens", flowerName.get(4));
        assertEquals("Sunflower", flowerName.get(5));
        assertEquals("Greens", flowerName.get(9));
        assertEquals("Sunflower", flowerName.get(10));
        assertEquals("Greens", flowerName.get(14));
        assertEquals("Sunflower", flowerName.get(15));
        assertEquals("Daisy", flowerName.get(16));
        assertEquals("Daisy", flowerName.get(17));
        assertEquals(18, flowerName.size());
    }

    @Test
    void testPopBouquetThree() {
        testBouquet.popularBouquetThree();
        ArrayList<String> flowerName = testBouquet.bouquetRequirements();
        assertEquals("Tulip", flowerName.get(0));
        assertEquals("Lavender", flowerName.get(1));
        assertEquals("Lilac", flowerName.get(2));
        assertEquals("Dahlias", flowerName.get(3));
        assertEquals("Bellflower", flowerName.get(4));
        assertEquals("Rosemary", flowerName.get(5));
        assertEquals("Tulip", flowerName.get(6));
        assertEquals("Rosemary", flowerName.get(11));
        assertEquals("Tulip", flowerName.get(12));
        assertEquals("Rosemary", flowerName.get(17));
        assertEquals("Tulip", flowerName.get(18));
        assertEquals("Lavender", flowerName.get(19));
        assertEquals("Greens", flowerName.get(20));
        assertEquals("Greens", flowerName.get(21));
        assertEquals(22, flowerName.size());
    }
}