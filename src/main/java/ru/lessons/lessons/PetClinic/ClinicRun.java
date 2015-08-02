package ru.lessons.lessons.PetClinic;

import sun.plugin2.message.Message;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Artva
 * @since 22/07/2015
 */
class ClinicRun {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean isExit = false;
    private static final String border = "=======================================================";
    public static void main(String[] args) {
        System.out.println("Hello!");
        while (!(isExit)) {
            try {
                menu1();
            } catch (IOException e) {
                System.err.println("***Wrong input! Please try again***");
            } catch (SearchException se) {
                System.err.println(se);
            }

        }
        System.out.println(border);
        System.out.println("Have a nice day!");
    }

    /**
     * Run 1st level menu
     * @throws IOException
     */
    private static void menu1() throws IOException, SearchException {
        printMenu1();
        readMenu1();
    }

    /**
     * Printing the 1st level menu of commands.
     */
    private static void printMenu1() {
        System.out.println(border);
        System.out.println("Command list:");
        System.out.println("\"add\" - adds client");
        System.out.println("\"id\" - search client by id");
        System.out.println("\"pet\" - search client by pet");
        System.out.println("\"list\" - displays list of clients");
        System.out.println("\"exit\" - finish program");
    }

    /**
     * Reads command, which entered by user on 1st level menu, and defines what to do next.
     * @throws IOException if wrong input type
     */
    private static void readMenu1() throws IOException, SearchException {
        switch (reader.readLine()) {
            case "add":
                addClient();
                break;
            case "id":
                searchId();
                break;
            case "pet":
                searchPetName();
                break;
            case "list":
                printList();
                break;
            case "exit":
                isExit = true;
                break;
            default:
                System.err.println("*** Wrong command***");
                break;
        }
    }

    /**
     * Adds client to the list by entering necessary information
     * @throws IOException
     */
    private static void addClient() throws IOException {
        System.out.println(border);
        System.out.println("Enter client's id");
        String id = reader.readLine();
        System.out.println("Enter pet's type");
        String petType = reader.readLine();
        System.out.println("Enter pet's name");
        String petName = reader.readLine();
        Clinic.add(id, petType, petName);
    }

    /**
     * Searching for the client with id entered by user.
     * Use Client-object result in menu2(), if such id was found in the list or displays to user that there isn't such id in it.
     * @throws IOException, SearchException
     */
    private static void searchId() throws IOException, SearchException {
        System.out.println(border);
        System.out.println("Please enter client's id");
        Client result = Clinic.searchId(reader.readLine());
        System.out.println("Search result:");
        System.out.println(result.toString());
        menu2(result);
    }

    /**
     * Searching for the client with pet, which name entered by user.
     * Use Client-object result in menu2(), if such name was found in the list or displays to user that there isn't such name in it.
     * @throws IOException, SearchException
     */
    private static void searchPetName() throws IOException, SearchException {
        System.out.println(border);
        System.out.println("Please enter pet's name");
        Client result = Clinic.searchPetName(reader.readLine());
        System.out.println("Search result:");
        System.out.println(result.toString());
        menu2(result);
    }

    /**
     * Prints list of current clients
     */
    private static void printList() {
        ArrayList<Client> list=Clinic.getClients();
        if (list.isEmpty()) {
            System.err.println("***There isn't any client in the list***");
        }
        else {
            System.out.println(border);
            System.out.println("Current clients:");
            list.forEach(System.out::println);
        }
    }

    /**
     *Run 2nd level menu of commands
     * @param client Client-object, which on will be perform operations
     * @throws IOException
     */
    private static void menu2(Client client) throws IOException{
        printMenu2();
        readMenu2(client);
    }

    /**
     * Printing 2nd level menu of commands
     */
    private static void printMenu2() {
        System.out.println(border);
        System.out.println("Command list:");
        System.out.println("\"delete\" - remove client from the list");
        System.out.println("\"rename\" - edit client's id");
        System.out.println("\"renamepet\" - edit name of client's pet");
        System.out.println("\"exit\" - finish program");
    }

    /**
     * Read
     * @param client Client-object, which on will be perform operations
     * @throws IOException
     */
    private static void readMenu2(Client client) throws IOException{
        switch (reader.readLine()){
            case "delete": deleteClient(client);
                break;
            case "rename": renameClient(client);
                break;
            case "renamepet": renamePet(client);
                break;
            case "exit": isExit=true;
                break;
            default:
                System.err.println("***Wrong command***");
        }
    }

    /**
     * Deletes client from the list
     * @param client Client-object
     */
    private static void deleteClient(Client client) {
        Clinic.deleteClient(client);
        System.out.println("Client "+client.getId()+" was successfully deleted from the list");
    }

    /**
     * Renames name of client's pet
     * @param client Client-object
     * @throws IOException
     */
    private static void renamePet(Client client) throws IOException{
        System.out.println(border);
        String previousName = client.getPetName();
        System.out.println("Please enter new pet's name");
        client.getPet().setName(reader.readLine());
        System.out.println("Pet's name was successfully changed from \""+previousName+"\" to \"" +client.getPetName()+"\"");
    }

    /**
     * Changes client's id
     * @param client Client-object
     * @throws IOException
     */
    private static void renameClient(Client client) throws IOException{
        System.out.println(border);
        String previousName = client.getId();
        System.out.println("Please enter new client's id");
        client.setId(reader.readLine());
        System.out.println("Client's id was successfully changed from \""+previousName+"\" to \"" +client.getId()+"\"");
    }

}
