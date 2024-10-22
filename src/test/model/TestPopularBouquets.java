package model;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPopularBouquets {

    private PopularBouquets testPopularBouquets;
    private Bouquet testBouquet;

    @BeforeEach
    void runBefore() {
        testPopularBouquets = new PopularBouquets();
        testBouquet = new Bouquet("null", new ArrayList<>(), 0);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testBouquet.getBouquetRequirements().size());
        assertTrue(testBouquet.getBouquetRequirements().isEmpty());
    }

    @Test
    void testPopBouquetOne() {
        testPopularBouquets.setPopularBouquetOne();
        testBouquet.addPopBouquetOne();
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(6).toString());
        assertEquals("Rose", testBouquet.getBouquetRequirements().get(11).toString());
        assertEquals("Greens", testBouquet.getBouquetRequirements().get(12).toString());
        assertEquals(13, testBouquet.getBouquetRequirements().size());

    }

    @Test
    void testPopBouquetTwo() {
        testPopularBouquets.setPopularBouquetThree();
        testBouquet.addPopBouquetTwo();
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Daisy", testBouquet.getBouquetRequirements().get(1).toString());
        assertEquals("Lily", testBouquet.getBouquetRequirements().get(2).toString());
        assertEquals("Snowdrop", testBouquet.getBouquetRequirements().get(3).toString());
        assertEquals("Greens", testBouquet.getBouquetRequirements().get(4).toString());
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(5).toString());
        assertEquals("Greens", testBouquet.getBouquetRequirements().get(9).toString());
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(10).toString());
        assertEquals("Greens", testBouquet.getBouquetRequirements().get(14).toString());
        assertEquals("Sunflower", testBouquet.getBouquetRequirements().get(15).toString());
        assertEquals("Daisy", testBouquet.getBouquetRequirements().get(16).toString());
        assertEquals("Daisy", testBouquet.getBouquetRequirements().get(17).toString());
        assertEquals(18, testBouquet.getBouquetRequirements().size());
    }

    @Test
    void testPopBouquetThree() {
        testPopularBouquets.setPopularBouquetThree();
        testBouquet.addPopBouquetThree();
        assertEquals("Tulip", testBouquet.getBouquetRequirements().get(0).toString());
        assertEquals("Lavender", testBouquet.getBouquetRequirements().get(1).toString());
        assertEquals("Lilac", testBouquet.getBouquetRequirements().get(2).toString());
        assertEquals("Dahlias", testBouquet.getBouquetRequirements().get(3).toString());
        assertEquals("Bellflower", testBouquet.getBouquetRequirements().get(4).toString());
        assertEquals("Rosemary", testBouquet.getBouquetRequirements().get(5).toString());
        assertEquals("Tulip", testBouquet.getBouquetRequirements().get(6).toString());
        assertEquals("Rosemary", testBouquet.getBouquetRequirements().get(11).toString());
        assertEquals("Tulip", testBouquet.getBouquetRequirements().get(12).toString());
        assertEquals("Rosemary", testBouquet.getBouquetRequirements().get(17).toString());
        assertEquals("Tulip", testBouquet.getBouquetRequirements().get(18).toString());
        assertEquals("Lavender", testBouquet.getBouquetRequirements().get(19).toString());
        assertEquals("Greens", testBouquet.getBouquetRequirements().get(20).toString());
        assertEquals("Greens", testBouquet.getBouquetRequirements().get(21).toString());
        assertEquals(22, testBouquet.getBouquetRequirements().size());
    }
}
