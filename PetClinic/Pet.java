package PetClinic;

/**
 * @author Artva
 * @since 22/07/2015
 */
@SuppressWarnings("ALL")
class Pet {
    /**
     * Name of pet.
     */
    private String name;
    /**
     * Type of pet (Dog, Cat, etc.)
     */
    private final String type;
    public Pet(String name, String type){
        this.name=name;
        this.type=type;
    }

    /**
     * @return Name of pet.
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return Type of pet.
     */
    public String getType(){return this.type;}

    /**
     * @param newName Edit pet's name.
     */
    public void setName(String newName){
        this.name=newName;
    }

    public void makeSound(){};
}
