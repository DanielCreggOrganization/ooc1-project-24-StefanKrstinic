Cat Manager System.

Overview:

The Cat Manager System allows users to manage a collection of cats, with features for adding, deleting, finding, and listing cats. The system is designed to allow the management of different types of cats, including SpecialCat subclasses that extend the basic Cat class.

Features:

    Add Cat: Add new cat entries with details like breed, weight, and special abilities.
    Delete Cat: Remove a cat from the list by its unique ID.
    Find Cat: Search for a cat based on its ID.
    List All Cats: View a list of all registered cats.
    Exit: Close the program.

Classes:

    Cat: Represents the base cat object with properties like catId, breed, weight, and furColour.
    SpecialCat: A subclass of Cat, with additional attributes and behavior like specialAbility and an overridden makeSound() method for unique behavior.

How to Use:

    Run the Program: Compile and execute the program.
    Menu Interface: Use the displayed menu to select actions (Add, Delete, Find, List, Exit).
    Add Cats: Input information for new cats, including breed, weight, gender, and any special ability if applicable.

Sample Output: 

=== Cat Manager System ===
1. Add Cat
2. Delete Cat
3. Find Cat
4. List All Cats
5. Exit

Choose an option: 1

Enter Cat ID: 1
Enter Breed: Persian
Enter Fur Colour: White
Enter Weight: 4.5
Is the cat male? (true/false): true
Enter special ability (if applicable): Invisibility

Cat added: Cat{catId=1, breed='Persian', furColour='White', weight=4.5, isMale=true, specialAbility='Invisibility'}

Requirements:

    Java 8 or higher.
    Basic understanding of Object-Oriented Programming principles, including inheritance, polymorphism, and encapsulation.