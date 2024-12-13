package ie.atu.catmanager;

import java.util.Arrays;
import java.util.Comparator;

// Class to manage Cat objects.
public class CatManager {
    private static Cat[] cats = new Cat[10]; // Array to store Cat objects (maximum of 10 cats).
    private static int catCount = 0;         // Counter for tracking number of cats.

    // Method to Add a Cat.
    public static void addCat(int id, String furColour, String breed, float weight, boolean isMale, boolean isSpecial, String specialAbility) {
        if (catCount >= cats.length) {
            System.out.println("Cannot add more cats. Maximum limit reached!\n");
            return;
        }
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
                System.out.println("Cat deleted successfully!\n");
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
        if (catCount == 0) {
            System.out.println("\nNo cats to display.\n");
            return;
        }

        System.out.println("\nListing All Cats:");
        for (int i = 0; i < catCount; i++) {
            System.out.println(cats[i]); // Print Cat details.
            cats[i].makeSound();         // Trigger the cat's sound.
        }
        System.out.println("Total Cats: " + catCount + "\n");
    }

    // Method to Clear the List of Cats.
    public static void clearList() {
        Arrays.fill(cats, null); // Clear all references in the array.
        catCount = 0;            // Reset counter.
        System.out.println("All cats have been removed from the list.\n");
    }

    // Method to Sort Cats by Fur Colour.
    public static void sortByFurColour() {
        Arrays.sort(cats, 0, catCount, Comparator.comparing(Cat::getFurColour));
        System.out.println("Cats have been sorted by Fur Colour.\n");
    }

    // Method to Sort Cats by Breed.
    public static void sortByBreed() {
        Arrays.sort(cats, 0, catCount, Comparator.comparing(Cat::getBreed));
        System.out.println("Cats have been sorted by Breed.\n");
    }

    // Method to Update a Cat's Weight.
    public static void updateCatWeight(int id, float newWeight) {
        for (Cat cat : cats) {
            if (cat != null && cat.getCatId() == id) {
                cat.setWeight(newWeight);
                System.out.println("Updated weight for Cat ID " + id + ": " + newWeight + " kg\n");
                return;
            }
        }
        System.out.println("Cat with ID " + id + " not found.\n");
    }
}
