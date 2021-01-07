package fr.ensta.missiontomars;

import java.util.Random;

/**
 * Classe de rocket de type U2
 */
public class U2 extends Rocket{
    double chance_explosion;
    double chance_crash;

    public static Random alea = new Random();

    /**
     * Constructeur de la classe U2
     */
    public U2(){
        super(18, 29, 120);
    }

    /**
     * Methode qui indique le resultat lancement
     * @return vrai (true) si le lancement a reussi ou faux (false) sinon
     */
    public boolean launch(){
        double cargo_carried = this.currentWeight - this.weight;
        double cargo_limit = this.maxWeight - this.weight;
        this.chance_explosion = 0.04 * Math.pow(cargo_carried / cargo_limit, 5);
        float proba = alea.nextFloat();  //on prend un nombre aleatoire entre 0.0 et 1.0
        return proba > chance_explosion;  //Si ce nombre est superieur a chance_explosion alors pas d'explosion
    }

    /**
     * Methode qui indique le resultat d'un atterrissage
     * @return vrai (true) si l'atterrissage a reussi ou faux (false) sinon
     */
    public boolean land(){
        double cargo_carried = this.currentWeight - this.weight;
        double cargo_limit = this.maxWeight - this.weight;
        this.chance_crash = 0.08 * Math.pow(cargo_carried / cargo_limit, 5);
        float proba = alea.nextFloat();  //on prend un nombre aleatoire entre 0.0 et 1.0
        return proba > chance_crash;  //Si ce nombre est superieur a chance_crash alors pas de crash
    }
}
