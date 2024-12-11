package ie.atu.catmanager;

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
    private boolean isSpecial; // Whether the cat is special or not.
    private String specialAbility; // Special ability of the cat if it is special.

    // Constructor: Initializes a new Cat object, with a special ability if special.
    public Cat(int catId, String furColour, String breed, float weight, boolean isMale, boolean isSpecial, String specialAbility) {
        this.catId = catId;
        this.furColour = furColour;
        this.breed = breed;
        this.weight = weight;
        this.isMale = isMale;
        this.isSpecial = isSpecial;
        this.specialAbility = isSpecial ? specialAbility : "None"; // If not special, set to "None".
    }

    // Getter Methods: Provide read access to private variables.
    public int getCatId() { return catId; }                // Get Cat ID.
    public String getFurColour() { return furColour; }     // Get Fur Colour.
    public String getBreed() { return breed; }             // Get Breed.
    public float getWeight() { return weight; }            // Get Weight.
    public boolean isMale() { return isMale; }             // Check Gender.
    public boolean isSpecial() { return isSpecial; }       // Check if the cat is special.
    public String getSpecialAbility() { return specialAbility; } // Get Special Ability.

    // Setter Methods: Allow modifying private variables with validation.
    public void setWeight(float weight) {
        if (weight > 0) {              // Validate that weight is positive.
            this.weight = weight;      // Assign the new weight.
        }
    }

    // Overridden Abstract Method: Defines how the Cat sounds.
    @Override
    public void makeSound() {
        if (isSpecial) {
            System.out.println("Purr... I am a special cat with the ability: " + specialAbility); // Special cat's sound.
        } else {
            System.out.println("Meow! I am a regular cat."); // Regular cat's sound.
        }
    }

    // toString Method: Returns a formatted string representing the Cat's details, including special abilities.
    @Override
    public String toString() {
        return "Cat{ID=" + catId +
               ", Breed='" + breed + '\'' +
               ", FurColour='" + furColour + '\'' +
               ", Weight=" + weight +
               ", Male=" + isMale +
               ", SpecialAbility='" + specialAbility + "'}";
    }
}

// Main Class: Manages Cats with options to add, delete, find, and list them.
public class CatManager {
    private static Cat[] cats = new Cat[10]; // Array to store Cat objects (maximum of 10 cats).
    private static int catCount = 0;         // Counter for tracking number of cats.
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input.

    // Method to Add a Cat.
    public static void addCat() {
        System.out.println("\nEnter Cat Details: ");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline.

        System.out.print("Fur Colour: ");
        String furColour = scanner.nextLine();

        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        System.out.print("Weight: ");
        float weight = scanner.nextFloat();

        System.out.print("Is Male (true/false): ");
        boolean isMale = scanner.nextBoolean();

        System.out.print("Is this a special cat? (true/false): ");
        boolean isSpecial = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline after boolean input.

        String specialAbility = "";
        if (isSpecial) {
            System.out.print("Enter the special ability: ");
            specialAbility = scanner.nextLine();
        }

        // Create a Cat object and add it to the array.
        cats[catCount++] = new Cat(id, furColour, breed, weight, isMale, isSpecial, specialAbility);
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
                cat.makeSound(); // Make the cat produce its sound.
                return;
            }
        }
        System.out.println("Cat with ID " + id + " not found.\n"); // Cat not found.
    }

    // Method to List All Cats.
    public static void listCats() {
        System.out.println("\nListing All Cats:"); // Header for listing Cats.
        for (int i = 0; i < catCount; i++) {
            System.out.println(cats[i]); // Print Cat details, including special abilities.
            cats[i].makeSound();         // Trigger the cat's sound, including special abilities.
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
