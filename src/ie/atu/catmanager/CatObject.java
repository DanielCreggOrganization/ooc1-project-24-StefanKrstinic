package ie.atu.catmanager;

// Abstract Class: Represents the base for all animals.
abstract class Animal {
    // Abstract method to be implemented by subclasses.
    public abstract void makeSound();
}

// Parent Class: Represents a Cat with its properties and behaviors.
class Cat extends Animal {
    private int catId;        // Unique identifier for the cat.
    private boolean isMale;   // Gender of the cat (true = male, false = female).
    private float weight;     // Weight of the cat in kilograms.
    private String breed;     // Breed of the cat.
    private String furColour; // Colour of the cat's fur.
    private boolean isSpecial; // Whether the cat is special or not.
    private String specialAbility; // Special ability of the cat if it is special.

    // Constructor: Initializes a new Cat object.
    public Cat(int catId, String furColour, String breed, float weight, boolean isMale, boolean isSpecial, String specialAbility) {
        this.catId = catId;
        this.furColour = furColour;
        this.breed = breed;
        this.weight = weight;
        this.isMale = isMale;
        this.isSpecial = isSpecial;
        this.specialAbility = isSpecial ? specialAbility : "None";
    }

    // Getters and Setters
    public int getCatId() { return catId; }
    public String getFurColour() { return furColour; }
    public String getBreed() { return breed; }
    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = Math.max(weight, 0); }

    @Override
    public void makeSound() {
        if (isSpecial) {
            System.out.println("Purr... I am a special cat with the ability: " + specialAbility);
        } else {
            System.out.println("Meow! I am a regular cat.");
        }
    }

    @Override
    public String toString() {
        return "Cat{ID=" + catId + ", Breed='" + breed + "', FurColour='" + furColour +
               "', Weight=" + weight + ", Male=" + isMale + ", SpecialAbility='" + specialAbility + "'}";
    }
}
