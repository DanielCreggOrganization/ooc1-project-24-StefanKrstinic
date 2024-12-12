package ie.atu.catmanager;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input.

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
                case 1:
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

                    CatManager.addCat(id, furColour, breed, weight, isMale, isSpecial, specialAbility);
                    break;
                case 2:
                    System.out.print("Enter Cat ID to delete: ");
                    int deleteId = scanner.nextInt();
                    CatManager.deleteCat(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Cat ID to find: ");
                    int findId = scanner.nextInt();
                    CatManager.findCat(findId);
                    break;
                case 4:
                    CatManager.listCats();
                    break;
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
