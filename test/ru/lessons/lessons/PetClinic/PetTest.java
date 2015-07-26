package ru.lessons.lessons.PetClinic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Artva
 * @since 26/07/2015
 */
public class PetTest {
    Cat cat = new Cat("A");

    @Test
    public void testGetName() throws Exception {
        assertEquals("A",cat.getName());
    }

    @Test
    public void testGetType() throws Exception {
        assertEquals("B",cat.getType());
    }

    @Test
    public void testSetName() throws Exception {
        cat.setName("C");
        assertEquals("C",cat.getName());
    }
}