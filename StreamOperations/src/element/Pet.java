/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Stream Grouping
*/
package element;

import java.util.Objects;
import java.util.Random;

// This class will support creating a self-constructed Pet object
// with randomly selected attributes from different arrays
public class Pet {

    // Set up test data for grouping tests
    private String[] namesArray = {"Spot", "Bob", "Barkley",
            "Charlie", "Fluffy", "Boots", "Angel", "Mittens"};

    private String[] statesArray =
            {"AL", "CO", "DE", "PA", "FL", "GA", "NJ", "NY"};

    private String[] typesArray = {"Dog", "Cat", "Hamster", "Fish",
            "Chinchilla", "Ferret", "Gerbil", "Pig"};

    private String[] ownerArray = {"Allen", "Bob", "Caleb", "Don",
            "Greg", "Howard", "Ira", "James"};

    private String[] vetArray = {"Bucks", "Pipersville", "Newtown",
            "New Hope", "Chalfont", "Ambler", "Lambertville", "Dublin"};

    private String name;
    private String type;
    private String owner;
    private String vet;
    private String state;
    private int age;

    public Pet() {
        // Use streaming skills to get 6 random #'s between 0 & 7
        int[] randoms = new Random().ints(0, 8)
                .limit(6)
                .toArray();

        // Populate Pet with randomly selected data
        int i = 0;
        this.name = namesArray[randoms[i++]];
        this.type = typesArray[randoms[i++]];
        this.state = statesArray[randoms[i++]];
        this.owner = ownerArray[randoms[i++]];
        this.vet = vetArray[randoms[i++]];
        this.age = randoms[i++];
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getOwner() {
        return owner;
    }

    public String getVet() {
        return vet;
    }

    public String getState() {
        return state;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", age=" + age +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return getName().equals(pet.getName()) &&
                getType().equals(pet.getType());
    }

    public int hashCode() {
        return Objects.hash(getType());
    }
}