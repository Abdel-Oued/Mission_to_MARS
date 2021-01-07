package fr.ensta.missiontomars;

/**
 * Classe de rocket.
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
        this.currentWeight = weight;  // A la creation, la rocket est vide
        this.cost = cost;
    }

    /**
     * Methode qui indique le resultat lancement.
     * @return vrai (true) si le lancement a reussi ou faux (false) sinon
     */
    public boolean launch(){
        return true;
    }

    /**
     * Methode qui indique le resultat d'un atterrissage.
     * @return vrai (true) si le l'atterrissage a reussi ou faux (false) sinon
     */
    public boolean land(){
        return true;
    }

    /**
     * Methode qui indique si un item peut etre pris
     * @param item item teste
     * @return vrai (true) si l'item peut etre pris ou faux (false) sinon
     */
    public boolean canCarry(Item item){
        return this.currentWeight + item.getWeight() <= this.maxWeight;
    }

    /**
     * Methode qui ajoute un item au cargo
     * @param item item a ajouter au cargo
     */
    public void carry(Item item){
        if(canCarry(item)) this.currentWeight = this.currentWeight + item.getWeight();
    }
}
