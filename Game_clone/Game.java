import java.util.*;

public class Game {
  public static void main(String[] args) throws CloneNotSupportedException{
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Infinity",70,95,97,"Creates a invisible shield which can't be penetrated and can be expanded to crush the enemy"));
    skills.add(new Skill("Hollow Purple",100,10,99,"A purple color ball, where energy is manipulated and focused into it, releasing it kills enemy with less chance of escape"));
    skills.add(new Skill("Reverse Curse Technique",0,0,0,"A skill to revive, it increases ur health by 10 every 2sec"));
    Character gojo = new Character("Satoru Gojo -The S grade Socerer",99,skills);
    Character gojo_clone = gojo.clone();
    gojo_clone.name = "Copy of \"Satoru Gojo\"";
    Scanner sc;  
    while(true){
      sc = new Scanner(System.in);
      System.out.println("\n1.Original \n2.Copy \n3.Exit");
      System.out.print("Please select an option: ");
      int input = -1;
      try{
        input = Integer.parseInt(sc.nextLine());
        validate(input);
      }
      catch(NumberFormatException e){
        System.out.println("Please select a valid option.");
        continue;
      }
      if(input == 1){
        gojo.charDetails();
      }else if(input == 2){
        gojo_clone.charDetails();
      }else if(input == 3){
        break;
      }
    }
    System.out.println("You have successfully exited!!");
    sc.close();
  }

  public static void validate(int input){
    if(!(input == 1 || input == 2 || input == 3)){
      throw new NumberFormatException();
    }
  }
}


class Character implements Cloneable{
  String name;
  int level;
  List<Skill> skills;

  Character(String name, int level, List<Skill> skills){
    this.name = name;
    this.level = level;
    this.skills = skills;
  }

  protected Character clone() throws CloneNotSupportedException {
    List<Skill> clonedSkills = new ArrayList<>();
    for (Skill s : this.skills) {
        clonedSkills.add((Skill) s.clone());
    }
    return new Character(this.name, this.level, clonedSkills);
  }

  public void charDetails() {
    System.out.println("\n----- Character Details -----");
    System.out.println("Name: " + this.name);
    System.out.println("Level: " + this.level);
    System.out.println("\nSkills:");
    for (Skill s : this.skills) {
        System.out.println("---------------");
        s.skillInfo();
    }
    System.out.println();
  }
}


class Skill implements Cloneable{
  String name;
  int damage;
  int accuracy;
  int defence;
  String description;
  Skill(String name, int damage, int defence, int accuracy,String description){
    this.name = name;
    this.damage = damage;
    this.defence = defence;
    this.accuracy = accuracy;
    this.description = description;
  }
    
  protected Skill clone() throws CloneNotSupportedException{
    return (Skill) super.clone();
  }
  
  public void skillInfo(){
    System.out.println(name + " [DMG: " + damage + ", DEF: " + defence + ", ACC: " + accuracy + "]");
    System.out.println(description);
  }
}