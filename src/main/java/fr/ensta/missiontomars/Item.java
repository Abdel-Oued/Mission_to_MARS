package fr.ensta.missiontomars;

public class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(int weight) {
        this.weight = weight;
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
