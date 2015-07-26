package ru.lessons.lessons.PetClinic;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Artva
 * @since 26/07/2015
 */
public class ClinicTest {

    @Test
    public void testAdd() throws Exception {
        Clinic.add("A", "Cat", "B");
        Client C = Clinic.getClients().get(0);
        String D = C.getId()+C.getPet().getType()+C.getPetName();
        assertEquals("ACatB",D);
    }

    @Test
    public void testSearchId() throws Exception {
        Clinic.add("A", "Cat", "B");
        assertEquals(Clinic.getClients().get(0), Clinic.searchId("A"));
    }

    @Test
    public void testSearchPetName() throws Exception {
        Clinic.add("A", "Cat", "B");
        assertEquals(Clinic.getClients().get(0),Clinic.searchPetName("B"));
    }

    @Test
    public void testDeleteClient() throws Exception {
        Clinic.add("A", "Cat", "B");
        Client client = Clinic.getClients().get(0);
        assertEquals(true,Clinic.getClients().contains(client));
        Clinic.deleteClient(Clinic.searchId("A"));
        assertEquals(false,Clinic.getClients().contains(client));
    }
}