/*
Name: May Song
Date: 11/10/17
 */
public class Pokedex {
    private Pokemon tempPoke = new Pokemon();
    private int pokemonCounter = 0;
    private int numberPokemon;
    private Pokemon[] pokemonList;
    private String[] speciesList;
    private int[] stats;
    private boolean noSort = true;

    public Pokedex(int numPokemon) {
        numberPokemon = numPokemon;
        pokemonList = new Pokemon[numberPokemon];
        speciesList = new String[numberPokemon];
        for (int i = 0; i < numberPokemon; i++) {
            pokemonList[i] = new Pokemon("");
        }
    }

    /*
    *Return all the names of the Pokemon species in the
    * Pokedex
    */
    public String[] listPokemon(boolean printSpecies) {
        if (noSort) {
            for (int i = 0; i < pokemonCounter; i++) {
                speciesList[i] = pokemonList[i].getSpecies();
                if (printSpecies) {
                    System.out.println((i + 1) + ". " + pokemonList[i].getSpecies());
                }
            }
            System.out.println("");
        }
        else {
            for (int i = 0; i < pokemonCounter; i++) {
                System.out.println((i + 1) + ". " + speciesList[i]);
            }
            System.out.println("");
        }
        return speciesList;
    }

    /*
    *Add a Pokemon to the Pokedex and return true if it can
    * actually be added to the Pokedex. If not, return false.
    * If the Pokemon trying to be added is already in the Pokedex,
    * then print out "Pokemon already in Pokedex" and return false.
    */
    public boolean addPokemon(String species) {
        boolean duplicateFound= false;
        for (Pokemon poke : pokemonList) {
            if (poke.getSpecies().equalsIgnoreCase(species)) {
                System.out.println("Duplicate");
                duplicateFound = true;
                if (pokemonCounter < numberPokemon) {
                    return false;
                }
            }
        }
        if (pokemonCounter < numberPokemon) {
            tempPoke = new Pokemon(species);
            pokemonList[pokemonCounter] = tempPoke;
            pokemonCounter++;
            noSort = true;
            return true;
        } else {
            System.out.println("Max");
            if (duplicateFound == true){
                System.out.println("Duplicate");
            }
            return false;
        }
    }

    /*
    *Return the stats of a certain Pokemon that you are
    * searching for.
    */
    public int[] checkStats(String species) {
        stats = new int[numberPokemon + 1];
        boolean isFound = true;
            for (int i = 0; i < pokemonCounter; i++) {
                if (pokemonList[i].getSpecies().equalsIgnoreCase(species)) {
                    System.out.println("The stats for " + species + " are:");
                    stats[0] = pokemonList[i].getAttack();
                    System.out.println("Attack: " + stats[0]);
                    stats[1] = pokemonList[i].getDefense();
                    System.out.println("Defense: " + stats[1]);
                    stats[2] = pokemonList[i].getSpeed();
                    System.out.println("Speed: " + stats[2]);
                    System.out.println("");
                    isFound = true;
                    return stats;
                } else {
                    isFound = false;
                }
            }
            if (!isFound || (pokemonCounter==0)) {
                System.out.println("Missing");
                System.out.println("");
            }

        return stats;
    }

    /*
    *Sort Pokedex in alphabetical order.
    */
    public void sortPokedex() {
        int x = 0;
        String temp = ""; //temporary variable to swap
        boolean sortEnd = false;
        while (!sortEnd) {
            sortEnd = true;
            x++;
            for (int i = 0; i < pokemonCounter - x; i++) {
                if ((speciesList[i].compareTo(speciesList[i + 1])) > 0) {
                    temp = speciesList[i];
                    speciesList[i] = speciesList[i + 1];
                    speciesList[i + 1] = temp;
                    sortEnd = false;
                }
            }

        }
        noSort = false;
    }
    /*
    *Evolve a certain Pokemon that you are searching for in the
    * Pokedex and return true if the Pokemon is actually in the
    * Pokedex. If not, return false.
    */
    public boolean evolvePokemon(String species) {
        boolean isFound = true;
        for (int i = 0; i < pokemonCounter; i++) {
            if (pokemonList[i].getSpecies().equalsIgnoreCase(species)) {
                pokemonList[i].evolve();
                System.out.println(species + " has evolved!");
                return true;
            } else {
                isFound = false;
            }
        }
        if (!isFound || (pokemonCounter==0)) {
            System.out.println("Missing");
            System.out.println("");
            return false;
        }
        return true;
    }
}

