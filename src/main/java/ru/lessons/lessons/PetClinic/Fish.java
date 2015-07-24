package ru.lessons.lessons.PetClinic;

/**
 * @author Artva
 * @since 22/07/2015
 */
class Fish extends Pet {
    public Fish(String name){
        super(name, "Fish");
    }
    @Override
    public void makeSound() {
        System.out.println("*SILENCE*");
    }
}
