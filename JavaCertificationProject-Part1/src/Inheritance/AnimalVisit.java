package Inheritance;

import java.time.LocalDate;

/*
    Section 9: Reusing Implementations Through Inheritance
    Topic:2. Create and use subclasses and superclasses
 */
class Dog extends Animal{

    // Supplement fields
    private int pedigreeId;
    // Hide field on superclass
    private LocalDate chipDate;

    // constructors are not inherited, create one , pass thru to super.
    // Note when creating a class, Compile error as there is no default constr on Parent ,so we create super.
    public Dog(String name,String owner,String breed,AnimalType type,int pedigreeId){
        super(name,owner,breed,type);
        this.pedigreeId = pedigreeId;
    }

    // override toString method and extend functionality of the superclass
    public String toString(){
        String str = super.toString();
        if(pedigreeId > 0){
            str += " (pedigree Id = "+pedigreeId + ")";
        }
        return str;
    }

    public static void examineAnimal(){
        System.out.println("Examine for breathing problems");
    }
    public LocalDate getChildChipDate(){
        System.out.println("child getChildChipDate");
        return chipDate;
    }

    // Hides method on parent
    public void setChipDate(LocalDate chipDate){
        this.chipDate = chipDate;
    }
}
public class AnimalVisit {
    public static void main(String[] args) {

        // Create a Dog
        Dog pug = new Dog("george","Ralph","Pug",Animal.AnimalType.DOG,775533);

        // Call a method on the superclass from the subclass instance
        pug.setChipDate(LocalDate.now());

        // Call the overridden method. Note that toString() is implied.
        System.out.println(pug);

        // call the overridden method... Here it calls the parent overridden method
        System.out.println("pug.getChipDate() = "+pug.getChipDate());

        // Try to force the call to the parent's method
        Animal a = pug;
        System.out.println("a.getChipDate() = "+a.getChipDate());

        // Call the supplemented method
        System.out.println("pug.getChildChipDate() = "+pug.getChildChipDate());

        // Call the static methods
        Animal.examineAnimal();
        Dog.examineAnimal();
    }
}
