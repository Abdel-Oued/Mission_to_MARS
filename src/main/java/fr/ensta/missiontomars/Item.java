package fr.ensta.missiontomars;

/**
 * Classe des objets a transporter.
 */
public class Item {
    private String name;
    private int weight;

    /**
     * Constructeur de la classe Item
     * @param name designation de l'item
     * @param weight poids de l'item
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Constructeur de la classe Item anonyme.
     * @param weight poids de l'item
     */
    public Item(int weight) {
        this.weight = weight;
        this.name = "none";
    }

    /**
     * Getter qui retourne le nom d'un item
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter qui retourne le poids d'un item
     * @return name
     */
    public int getWeight() {
        return weight;
    }
}
