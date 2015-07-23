package PetClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Artva
 * @since 22/07/2015
 */
class ClinicRun {
    @SuppressWarnings("CanBeFinal")
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean isExit=false;
    @SuppressWarnings("CanBeFinal")
    private static final String border = "*********************************************************";
    public static void main(String[] args) {
        System.out.println("Hello!");
        while (!(isExit)){
            try {
                menu1();
            } catch (IOException e) {
                System.out.println(border);
                System.out.println("Error! Wrong input! Please try again");
                System.out.println(border);
            }
            finally {
                System.out.println(border);
                System.out.println("Have a nice day!");
                System.out.println(border);
            }
        }

    }

    /**
     * Reads command, which entered on 1st level menu, and defines what to do next.
     * @throws IOException if wrong input type
     */
    private static void menu1Reader() throws IOException {
        switch (reader.readLine()) {
            case "add":
                add();
                break;
            case "id":
                idSearch();
                break;
            case "pet":
                petSearch();
                break;
            case "list":
                printList();
                break;
            case "exit":
                isExit=true;
                break;
        }
    }

    /**
     * Prints list of current clients
     */
    private static void printList() {
        System.out.println(border);
        System.out.println("Current clients:");
        Clinic.print();
        System.out.println(border);
    }

    /**
     * Searching for the client with pet, which name entered by user.
     * Use Client-object result in menu2() if such name was found in the list or displays to user that there is such name in it.
     * @throws IOException
     */
    private static void petSearch() throws IOException{
        System.out.println(border);
        System.out.println("Please enter pet's name");
        Client result = Clinic.SearchByPetName(reader.readLine());
        if (result.equals(null)){
            System.out.println("There isn't client with such name of pet");
        }
        else{
            System.out.println("Search result:");
            System.out.println(result.toString());
            System.out.println(border);
            menu2(result);
        }

    }

    /**
     * 2nd level menu
     * @param result Client-object's transfer to 2nd level menu reader
     * @throws IOException
     */
    private static void menu2(Client result) throws IOException{
        System.out.println(border);
        System.out.println("Command list:");
        System.out.println("delete - remove client from the list");
        System.out.println("rename - edit client's id");
        System.out.println("petrename - edit name of client's pet");
        System.out.println("exit - finish program");
        System.out.println(border);
        menu2Reader(result);
    }

    /**
     * @param result Client-object, which will be committed operations
     * @throws IOException
     */
    private static void menu2Reader(Client result) throws IOException{
        switch (reader.readLine()){
            case "delete": delete(result);
                break;
            case "rename": rename(result);
                break;
            case "petrename": petRename(result);
                break;
            case "exit": isExit=true;
                break;
        }
    }

    /**
     * Renames name of client's pet
     * @param client Client-object
     * @throws IOException
     */
    private static void petRename(Client client) throws IOException{
        System.out.println();
        System.out.println("Please enter new pet's name");
        client.getPet().setName(reader.readLine());
        System.out.println("Pet's name was successfully changed");
    }

    /**
     * Changes client's id
     * @param client Client-object
     * @throws IOException
     */
    private static void rename(Client client) throws IOException{
        System.out.println(border);
        System.out.println("Please enter new client id");
        client.setId(reader.readLine());
        System.out.println("Client's id was successfully changed");
        System.out.println(border);
    }

    /**
     * Deletes client from the list
     * @param client Client-object
     */
    private static void delete(Client client) {
        Clinic.deleteClient(client);
        System.out.println("Client was successfully deleted from the list");
    }

    /**
     * Searching for the client with id entered by user.
     * Use Client-object result in menu2() if such id was found in the list or displays to user that there is such id in it.
     * @throws IOException
     */
    private static void idSearch() throws IOException{
        System.out.println();
        System.out.println("Please enter client's id");
        Client result = Clinic.SearchById(reader.readLine());
        if (result.equals(null)){
            System.out.println("There isn't client with such id");
        }
        else{
            System.out.println("Search result:");
            System.out.println(result.toString());
            menu2(result);
        }

    }

    /**
     * Adds client to the list by entering necessary information
     * @throws IOException
     */
    private static void add() throws IOException{
        System.out.println(border);
        System.out.println("Enter client's id");
        String id = reader.readLine();
        System.out.println("Enter pet's type");
        String petType = reader.readLine();
        System.out.println("Enter pet's name");
        String petName = reader.readLine();
        Clinic.add(id,petType,petName);
        System.out.println("Client was successfully added to the list");
        System.out.println(border);
    }

    /**
     * 1st level menu of command
     * @throws IOException
     */
    private static void menu1() throws IOException{
        System.out.println(border);
        System.out.println("Command list:");
        System.out.println("add - adds client");
        System.out.println("id - search client by id");
        System.out.println("pet - search client by pet");
        System.out.println("list - displays list of clients");
        System.out.println("exit - finish program");
        System.out.println(border);
        menu1Reader();
    }
}
