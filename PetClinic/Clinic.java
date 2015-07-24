package PetClinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Artva
 * @since 22/07/2015
 */
class Clinic {
    /**
     * List of clients.
     */
    private static final ArrayList<Client> clients = new ArrayList<>();
    /**
     * Adds information about client to the list.
     * @param clientName client's id
     * @param petType type of client's pet (Dod, Cat, etc.)
     * @param petName pet's name
     */
    public static void add(String clientName, String petType, String petName){
        Pet pet = petAdd(petType, petName);
        assert pet != null;
        pet.makeSound();
        clients.add(new Client(clientName,pet));
    }

    /**
     * @param petType type of client's pet (Dod, Cat, etc.)
     * @param petName pet's name
     * @return petType according Pet-extend Object with petName as name.
     */
    private static Pet petAdd(String petType, String petName) {
        switch(petType){
            case "Dog": return new Dog(petName);
            case "Cat": return new Cat(petName);
            case "Fish": return new Fish(petName);
            case "Bird": return new Bird(petName);
        }
        return null;
    }

    /**
     * @param id Client's id
     * @return Found Client-Object or null, if there isn't client with such id.
     */
    public static Client SearchById(String id){
        for (Client client:clients){
            if (client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }

    /**
     * @param petName Name of client's pet.
     * @return Found Client-Object or null, if there isn't pet with such name.
     */
    public static Client SearchByPetName(String petName){
        for (Client client:clients){
            if (client.getPetName().equals(petName)){
                return client;
            }
        }
        return null;
    }

    /**
     * @param client remove object from the list.
     */
    public static void deleteClient(Client client){
        clients.remove(client);
    }

    /**
     * Print current list of clients.
     */
    public static void print(){
        clients.forEach(System.out::println);
    }
}
