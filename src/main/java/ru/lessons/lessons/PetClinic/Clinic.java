package ru.lessons.lessons.PetClinic;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

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
        if (pet==null) {
            System.err.println("***Wrong pet type***");
            return;
        }
        else System.out.println("Client \"" + clientName +"\" was successfully added to the list");
        pet.makeSound();
        clients.add(new Client(clientName, pet));
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
            default:
                return null;
        }
    }

    @Nullable
    /**
     * @param id Client's id
     * @return Found Client-Object or null, if there isn't client with such id.
     */
    public static Client searchId(String id){
        for (Client client:clients){
            if (client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }

    @Nullable
    /**
     * @param petName Name of client's pet.
     * @return Found Client-Object or null, if there isn't pet with such name.
     */
    public static Client searchPetName(String petName){
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
     * @return Client list as ArrayList<Client>
     */
    public static ArrayList<Client> getClients(){
        return Clinic.clients;
    }
}
