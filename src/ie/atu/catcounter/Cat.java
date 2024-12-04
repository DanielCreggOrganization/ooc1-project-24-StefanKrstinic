package ie.atu.catcounter;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    // Instance Variables
    private int catId; // Unique ID
    private boolean isMale;
    private float weight;
    private String breed;
    private String furColour;

    // Static counter for tracking created cats
    private static int catCounter = 0;

    // List to store Cat objects
    private static List<Cat> catRegistry = new ArrayList<>();

    // Constructor
    public Cat(int catId, String furColour, String breed, float weight, boolean isMale) {
        if (catId <= 0) {
            throw new IllegalArgumentException("Cat ID must be positive.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0.");
        }
        this.catId = catId;
        this.furColour = furColour;
        this.breed = breed;
        this.weight = weight;
        this.isMale = isMale;

        // Increment counter and add to registry
        catCounter++;
        catRegistry.add(this);
    }

    // Getter methods
    public int getCatId() {
        return this.catId;
    }

    public String getFurColour() {
        return this.furColour;
    }

    public String getBreed() {
        return this.breed;
    }

    public float getWeight() {
        return this.weight;
    }

    public boolean isMale() {
        return this.isMale;
    }

    // Setter methods
    public void setCatId(int catId) {
        if (catId <= 0) {
            throw new IllegalArgumentException("Cat ID must be positive.");
        }
        this.catId = catId;
    }

    public void setFurColour(String furColour) {
        this.furColour = furColour;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setWeight(float weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0.");
        }
        this.weight = weight;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    // Static method to get the count of created cats
    public static int getCatCounter() {
        return catCounter;
    }

    // Static method to get all registered cats
    public static List<Cat> getCatRegistry() {
        return catRegistry;
    }

    // toString method
    @Override
    public String toString() {
        return "Cat{" +
                "catId=" + catId +
                ", isMale=" + isMale +
                ", weight=" + weight +
                ", breed='" + breed + '\'' +
                ", furColour='" + furColour + '\'' +
                '}';
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Creating Cat objects
        Cat cat1 = new Cat(1, "Black", "Siamese", 4.5f, true);
        Cat cat2 = new Cat(2, "White", "Persian", 3.2f, false);
        Cat cat3 = new Cat(3, "Gray", "Maine Coon", 6.0f, true);

        // Displaying individual cats
        System.out.println("Individual Cat Details:");
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);

        // Displaying total number of cats
        System.out.println("\nTotal Cats Created: " + Cat.getCatCounter());

        // Displaying all registered cats
        System.out.println("\nAll Registered Cats:");
        List<Cat> registry = Cat.getCatRegistry();
        for (Cat cat : registry) {
            System.out.println(cat);
        }
    }
}
