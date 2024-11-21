package ie.atu.catcounter;

public class cat {
   ///Instance Variable
   private int catId; // Unique ID
   private boolean ismale;
   private float weight;
   private String breed;
   private String fur_colour;
   
   //Constructor
   public cat(int catId, String fur_colour, String breed, float weight, boolean ismale){
    this.catId = catId;
    this.fur_colour = fur_colour;
    this.breed = breed;
    this.weight = weight;
    this.ismale = ismale;
   }

   public int catId(){
    return this.catId;
   }
   public String fur_colour(){
    return this.fur_colour;
   }
   public String breed(){
    return this.breed;
   }
   public float weight(){
    return this.weight;
   }
   public boolean ismale(){
    return this.ismale;
   }

   public void setcatId(int catId){
    this.catId = catId;
   }
   public void setfur_colour(String fur_colour){
    this.fur_colour = fur_colour;
   }
   public void setbreed(String breed){
    this.breed = breed;
   }
   public void setweight(float weight){
    this.weight = weight;
   }
   public void setismale(boolean ismale){
    this.ismale = ismale; 
   }
}
