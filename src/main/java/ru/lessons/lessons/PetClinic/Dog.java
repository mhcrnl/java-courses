package ru.lessons.lessons.PetClinic;
/**
 * @author Artva
 * @since 22/07/2015
 */
class Dog extends Pet {
    public Dog(String name){
        super(name,"Dog");
    }
    @Override
    public void makeSound() {
        System.out.println("GAV-GAV");
    }
}
