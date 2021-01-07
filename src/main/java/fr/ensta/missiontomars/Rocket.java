package fr.ensta.missiontomars;

/**
 * Classe de rocket
 */
public class Rocket implements SpaceShip {
    protected int cost;
    protected int weight;
    protected int maxWeight;
    protected int currentWeight;  // poids de la rocket vide + charge actuelle

    /**
     * Constructeur de la classe Rocket
     * @param weight    poids de la rocket vide
     * @param maxWeight poids de la rocket vide + poids de charge maximale
     * @param cost      prix de la rocket
     */
    public Rocket(int weight, int maxWeight, int cost) {
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.currentWeight = weight;  // A la création, la rocket est vide
        this.cost = cost;
    }

    /**
     * Méthode qui indique le résultat lancement
     * @return vrai (true) si le lancement à réussi ou faux (false) sinon
     */
    public boolean launch(){
        return true;
    }

    /**
     * Méthode qui indique le résultat d'un atterrissage
     * @return vrai (true) si le l'atterrissage à réussi ou faux (false) sinon
     */
    public boolean land(){
        return true;
    }

    /**
     * Méthode qui indique si un item peut être pris
     * @param item item testé
     * @return vrai (true) si l'item peut être pris ou faux (false) sinon
     */
    public boolean canCarry(Item item){
        return this.currentWeight + item.getWeight() <= this.maxWeight;
    }

    /**
     * Méthode qui ajoute un item au cargo
     * @param item item à ajouter au cargo
     */
    public void carry(Item item){
        if(canCarry(item)) this.currentWeight = this.currentWeight + item.getWeight();
    }
}
