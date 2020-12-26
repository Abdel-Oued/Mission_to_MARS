package fr.ensta.missiontomars;

import java.util.Random;

public class U1 extends Rocket{
    double chance_explosion;  // chance de décoller
    double chance_crash;  // chance d'attérir

    public static Random alea = new Random();  //

    public U1(){
        super(10, 18, 100);
    }

    public boolean launch(){
        double cargo_carried = this.currentWeight - this.weight;
        double cargo_limit = this.maxWeight - this.weight;
        this.chance_explosion = 0.05 * Math.pow(cargo_carried / cargo_limit, 2);
        float proba = alea.nextFloat();   //on prend un nombre aléatoire entre 0.0 et 1.0
        return proba > chance_explosion;  //Si ce nombre est supérieur à chance_explosion alors pas de
    }

    public boolean land(){
        double cargo_carried = this.currentWeight - this.weight;
        double cargo_limit = this.maxWeight - this.weight;
        this.chance_crash = 0.01 * Math.pow(cargo_carried / cargo_limit, 2);
        float proba = alea.nextFloat();  //on prend un nombre aléatoire entre 0.0 et 1.0
        return proba > chance_crash;  //Si ce nombre est supérieur à chance_explosion alors pas de crash
    }
}
