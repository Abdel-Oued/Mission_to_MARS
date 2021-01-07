package fr.ensta.missiontomars;

/**
 * Interface SpaceShip representant un engin spatial
 */
public interface SpaceShip {

    /**
     * Methode qui indique le resultat lancement.
     * @return vrai (true) si le lancement a reussi ou faux (false) sinon
     */
    public boolean launch();

    /**
     * Methode qui indique le resultat d'un atterrissage.
     * @return vrai (true) si le l'atterrissage a reussi ou faux (false) sinon
     */
    public boolean land();

    /**
     * Methode qui indique si un item peut etre pris
     * @param item item teste
     * @return vrai (true) si l'item peut etre pris ou faux (false) sinon
     */
    public boolean canCarry(Item item);

    /**
     * Methode qui ajoute un item au cargo
     * @param item item a ajouter au cargo
     */
    public void carry(Item item);
}
