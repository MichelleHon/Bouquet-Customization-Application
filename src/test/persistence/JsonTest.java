package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Flower;

public class JsonTest {
    protected void checkFlower(String name, Flower flower) {
        assertEquals(name, flower.getFlowerName());
    }
}
