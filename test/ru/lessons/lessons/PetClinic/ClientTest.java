package ru.lessons.lessons.PetClinic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Artva
 * @since 26/07/2015
 */
public class ClientTest {
    Cat cat = new Cat("B");
    Client client = new Client("A",cat);

    @Test
    public void testGetId() throws Exception {
        assertEquals("A",client.getId());
    }

    @Test
    public void testSetId() throws Exception {
        client.setId("C");
        assertEquals("C",client.getId());
    }

    @Test
    public void testGetPet() throws Exception {
        assertEquals(cat,client.getPet());
    }

    @Test
    public void testGetPetName() throws Exception {
        assertEquals("B",client.getPetName());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("A Cat B",client.toString());
    }
}