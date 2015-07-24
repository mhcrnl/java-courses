package ru.lessons.lessons.PetClinic;

/**
 * @author Artva
 * @since 22/07/2015
 */
class Cat extends Pet {
    public Cat(String name){
        super(name, "Cat");
    }
    @Override
    public void makeSound() {
        System.out.println("MEOW");
    }
}
