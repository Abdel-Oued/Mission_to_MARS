package fr.ensta.missiontomars;

import java.util.Random;

/**
 * Classe de rocket de type U1
 */
public class U1 extends Rocket {
    double chance_explosion;
    double chance_crash;

    public static Random alea = new Random();

    public U1() {
        super(10, 18, 100);
    }

    /**
     * Méthode qui indique le résultat lancement
     * @return vrai (true) si le lancement à réussi ou faux (false) sinon
     */
    public boolean launch() {
        double cargo_carried = this.currentWeight - this.weight;
        double cargo_limit = this.maxWeight - this.weight;
        this.chance_explosion = 0.05 * Math.pow(cargo_carried / cargo_limit, 5);
        float proba = alea.nextFloat();  //on prend un nombre aléatoire entre 0.0 et 1.0
        return proba > chance_explosion;  //Si ce nombre est supérieur à chance_explosion alors pas d'explosion
    }

    /**
     * Méthode qui indique le résultat d'un atterrissage
     * @return vrai (true) si l'atterrissage à réussi ou faux (false) sinon
     */
    public boolean land() {
        double cargo_carried = this.currentWeight - this.weight;
        double cargo_limit = this.maxWeight - this.weight;
        this.chance_crash = 0.01 * Math.pow(cargo_carried / cargo_limit, 5);
        float proba = alea.nextFloat();  //on prend un nombre aléatoire entre 0.0 et 1.0
        return proba > chance_crash;  //Si ce nombre est supérieur à chance_crash alors pas de crash
    }
}