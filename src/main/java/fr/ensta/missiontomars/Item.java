package fr.ensta.missiontomars;

/**
 * Classe des objets à transporter.
 */
public class Item {
    private String name;
    private int weight;

    /**
     * Constructeur de la classe Item
     * @param name désignation de l'item
     * @param weight poids de l'item
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(int weight) {
        this.weight = weight;
        this.name = "none";
    }

    // getter
    public String getName() {
        return name;
    }

    // getter
    public int getWeight() {
        return weight;
    }
}
