package PetClinic;

/**
 * @author Artva
 * @since 22/07/2015
 */
class Bird extends Pet {
    public Bird(String name){
        super(name, "Bird");
    }
    @Override
    public void makeSound() {
        System.out.println("*MELODY*");
    }
}
