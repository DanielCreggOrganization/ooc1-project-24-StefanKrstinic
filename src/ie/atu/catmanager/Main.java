package ie.atu.catmanager;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("=== Cat Manager System ===");
            System.out.println("1. Add Cat");
            System.out.println("2. Delete Cat");
            System.out.println("3. Find Cat");
            System.out.println("4. List All Cats");
            System.out.println("5. Sort Cats by Fur Colour");
            System.out.println("6. Sort Cats by Breed");
            System.out.println("7. Update Cat Weight");
            System.out.println("8. Clear List of Cats");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCat();
                case 2 -> deleteCat();
                case 3 -> findCat();
                case 4 -> CatManager.listCats();
                case 5 -> CatManager.sortByFurColour();
                case 6 -> CatManager.sortByBreed();
                case 7 -> updateCatWeight();
                case 8 -> CatManager.clearList();
                case 9 -> {
                    running = false;
                    System.out.println("Exiting Cat Manager. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    private static void addCat() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

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
        scanner.nextLine();

        String specialAbility = "";
        if (isSpecial) {
            System.out.print("Enter the special ability: ");
            specialAbility = scanner.nextLine();
        }

        CatManager.addCat(id, furColour, breed, weight, isMale, isSpecial, specialAbility);
    }

    private static void deleteCat() {
        System.out.print("Enter Cat ID to delete: ");
        int id = scanner.nextInt();
        CatManager.deleteCat(id);
    }

    private static void findCat() {
        System.out.print("Enter Cat ID to find: ");
        int id = scanner.nextInt();
        CatManager.findCat(id);
    }

    private static void updateCatWeight() {
        System.out.print("Enter Cat ID to update weight: ");
        int id = scanner.nextInt();
        System.out.print("Enter new weight: ");
        float weight = scanner.nextFloat();
        CatManager.updateCatWeight(id, weight);
    }
}
