/*
Name: May Song
Date: 11/10/17
 */
public class Pokemon {
    private int attack;
    private int defense;
    private int speed;
    private String species;
    public Pokemon(){
        species = "";
        attack = species.length() * 4 + 2;
        defense = species.length() * 2 + 7;
        speed = species.length() * 3 + 5;
    }

    public Pokemon(String mySpecies){
        species = mySpecies;
        attack = species.length() * 4 + 2;
        defense = species.length() * 2 + 7;
        speed = species.length() * 3 + 5;
    }
    /*
    * When called, the getAttack method will return the attack
    * variable.
    */
    public int getAttack(){
        return attack;
    }
    /*
    * When called, the setAttack method will set the attack
    * variable to whatever value is passed to the method.
    */
    public void setAttack(int newAttack){
        attack = newAttack;
    }
    /*
    * When called, the getDefense method will return the defense
    * variable.
    */
    public int getDefense(){
        return defense;
    }
    /*
    * When called, the setDefense method will set the defense
    * variable to whatever value is passed to the method.
    */
    public void setDefense(int newDefense){
        defense = newDefense;
    }
    /*
    * When called, the getSpeed method will return the speed
    * variable.
    */
    public int getSpeed(){
        return speed;
    }
    /*
    * When called, the setSpeed method will set the speed variable
    * to whatever value is passed to the method.
    */
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    /*
    * When called, the getSpecies method will return the species
    * variable.
    */
    public String getSpecies(){
        return species;
    }
    /*
    * When called, the setSpecies method will set the species variable
    * to whatever value is passed to the method.
    */
    public void setSpecies(String newSpecies){
        species = newSpecies;
    }
    /*
    * When called, the evolve method will double the speed stat,
    * triple the attack stat, and multiply the defense stat by 5.
    */
    public void evolve(){
        speed = getSpeed() * 2;
       setSpeed(speed);
        attack = getAttack() * 3;
       setAttack(attack);
        defense = getDefense() * 5;
       setDefense(defense);
    }
}
