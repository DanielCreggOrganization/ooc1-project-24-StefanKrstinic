package ie.atu.catcounter;

import java.util.Scanner;

// Abstract Class: Represents the base for all animals.
abstract class Animal {
    // Abstract method to be implemented by subclasses.
    public abstract void makeSound();
}

// Parent Class: Represents a Cat with its properties and behaviors.
class Cat extends Animal {
    // Instance Variables (Encapsulation: Private access).
    private int catId;        // Unique identifier for the cat.
    private boolean isMale;   // Gender of the cat (true = male, false = female).
    private float weight;     // Weight of the cat in kilograms.
    private String breed;     // Breed of the cat.
    private String furColour; // Colour of the cat's fur.

    // Constructor: Initializes a new Cat object.
    public Cat(int catId, String furColour, String breed, float weight, boolean isMale) {
        this.catId = catId;           // Assign cat ID.
        this.furColour = furColour;   // Assign fur colour.
        this.breed = breed;           // Assign breed.
        this.weight = weight;         // Assign weight.
        this.isMale = isMale;         // Assign gender.
    }

    // Getter Methods: Provide read access to private variables.
    public int getCatId() { return catId; }                // Get Cat ID.
    public String getFurColour() { return furColour; }     // Get Fur Colour.
    public String getBreed() { return breed; }             // Get Breed.
    public float getWeight() { return weight; }            // Get Weight.
    public boolean isMale() { return isMale; }             // Check Gender.

    // Setter Methods: Allow modifying private variables with validation.
    public void setWeight(float weight) {
        if (weight > 0) {              // Validate that weight is positive.
            this.weight = weight;      // Assign the new weight.
        }
    }

    // Overridden Abstract Method: Defines how the Cat sounds.
    @Override
    public void makeSound() {
        System.out.println("Meow! I am a cat."); // Cat's sound.
    }

    // toString Method: Returns a formatted string representing the Cat's details.
    @Override
    public String toString() {
        return "Cat{ID=" + catId +
               ", Breed='" + breed + '\'' +
               ", FurColour='" + furColour + '\'' +
               ", Weight=" + weight +
               ", Male=" + isMale + "}";
    }
}

// Child Class: A SpecialCat with additional abilities (Inheritance & Polymorphism).
class SpecialCat extends Cat {
    private String specialAbility; // Unique ability for SpecialCat.

    // Constructor: Initializes a SpecialCat object with all attributes.
    public SpecialCat(int catId, String furColour, String breed, float weight, boolean isMale, String specialAbility) {
        super(catId, furColour, breed, weight, isMale); // Call Parent Class Constructor.
        this.specialAbility = specialAbility;          // Assign special ability.
    }

    // Overridden Method: SpecialCat has a unique sound.
    @Override
    public void makeSound() {
        System.out.println("Purr... I am a special cat with the ability: " + specialAbility); // Special cat's sound.
    }

    // toString Method: Adds special ability to the output.
    @Override
    public String toString() {
        return super.toString() + ", SpecialAbility='" + specialAbility + "'}";
    }
}

// Main Class: Manages Cats with options to add, delete, find, and list them.
public class CatManager {
    private static Cat[] cats = new Cat[10]; // Array to store Cat objects (maximum of 10 cats).
    private static int catCount = 0;         // Counter for tracking number of cats.
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input.

    // Method to Add a Cat.
    public static void addCat() {
        System.out.println("\nEnter Cat Details: "); // Prompt to enter Cat details.

        // Prompt user for Cat details.
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline.
        System.out.print("Fur Colour: ");
        String furColour = scanner.nextLine();
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        System.out.print("Weight: ");
        float weight = scanner.nextFloat();
        System.out.print("Is Male (true/false): ");
        boolean isMale = scanner.nextBoolean();

        // Add Cat object to the array and increment count.
        cats[catCount++] = new Cat(id, furColour, breed, weight, isMale);
        System.out.println("Cat added successfully!\n");
    }

    // Method to Delete a Cat by ID.
    public static void deleteCat(int id) {
        for (int i = 0; i < catCount; i++) {
            if (cats[i].getCatId() == id) {  // Find Cat with matching ID.
                System.out.println("Deleting Cat: " + cats[i]); // Notify of deletion.
                cats[i] = cats[--catCount]; // Replace current cat with the last one.
                cats[catCount] = null;      // Clear the last entry.
                return;
            }
        }
        System.out.println("Cat with ID " + id + " not found.\n"); // Cat not found.
    }

    // Method to Find a Cat by ID.
    public static void findCat(int id) {
        for (Cat cat : cats) {
            if (cat != null && cat.getCatId() == id) { // Check for Cat ID match.
                System.out.println("Found Cat: " + cat); // Print Cat details.
                return;
            }
        }
        System.out.println("Cat with ID " + id + " not found.\n"); // Cat not found.
    }

    // Method to List All Cats.
    public static void listCats() {
        System.out.println("\nListing All Cats:"); // Header for listing Cats.
        for (int i = 0; i < catCount; i++) {
            System.out.println(cats[i]); // Print Cat details.
        }
        System.out.println("Total Cats: " + catCount + "\n"); // Print total number of Cats.
    }

    // Main Menu: Displays options for managing Cats.
    public static void main(String[] args) {
        boolean running = true; // Control flag for menu loop.

        while (running) {
            // Display Menu Options.
            System.out.println("=== Cat Manager System ===");
            System.out.println("1. Add Cat");
            System.out.println("2. Delete Cat");
            System.out.println("3. Find Cat");
            System.out.println("4. List All Cats");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Read user's choice.

            // Perform actions based on user input.
            switch (choice) {
                case 1: addCat(); break; // Add a Cat.
                case 2:
                    System.out.print("Enter Cat ID to delete: ");
                    int deleteId = scanner.nextInt();
                    deleteCat(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Cat ID to find: ");
                    int findId = scanner.nextInt();
                    findCat(findId);
                    break;
                case 4: listCats(); break; // List all Cats.
                case 5:
                    running = false; // Exit the program.
                    System.out.println("Exiting Cat Manager. Goodbye!"); // Exit message.
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n"); // Handle invalid input.
            }
        }
    }
}
