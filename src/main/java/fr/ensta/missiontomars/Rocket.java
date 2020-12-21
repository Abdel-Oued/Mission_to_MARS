package fr.ensta.missiontomars;

public class Rocket implements SpaceShip {
    protected int weight;  // poids de la rocket vide
    protected int maxWeight;  // poids de la rocket vide + poids de charge maximale
    protected int currentWeight;  // poids de la rocket vide + charge actuelle

    public Rocket(int weight, int maxWeight) {
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.currentWeight = weight;  // A la création, la rocket est vide
    }

    public boolean launch(){
        return true;
    }

    public boolean land(){
        return true;
    }

    public boolean canCarry(Item item){
        return this.currentWeight + item.getWeight() <= this.maxWeight;
    }

    public void carry(Item item){
        if(canCarry(item)) this.currentWeight = this.currentWeight + item.getWeight();
    }
}
