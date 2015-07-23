package PetClinic;

/**
 * @author Artva
 * @since 22/07/2015
 */
class Client {
    /**
     * Client's identifier.
     */
    private String id;
    /**
     * Client's pet.
     */
    private final Pet pet;
    public Client(String id, Pet pet){
        this.id=id;
        this.pet=pet;
    }

    /**
     * @return Client's id
     */
    public String getId(){return this.id;}

    /**
     * @param newId Edited client's identifier.
     */
    public void setId (String newId){this.id=newId;}

    /**
     * @return Client's pet-object.
     */
    public Pet getPet(){
        return this.pet;
    }

    /**
     * @return Client's pet's name.
     */
    public String getPetName(){
        return this.pet.getName();
    }

    @Override
    public String toString() {
        return ""+id+" "+pet.getType()+" "+pet.getName();
    }
}
