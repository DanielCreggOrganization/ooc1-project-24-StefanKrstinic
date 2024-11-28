package ie.atu.catcounter;

public class Cat {
   // Instance Variables
   private int catId; // Unique ID
   private boolean isMale;
   private float weight;
   private String breed;
   private String furColour;

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
   }

   // Getter and Setter methods
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
}
