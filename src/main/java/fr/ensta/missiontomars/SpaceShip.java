package fr.ensta.missiontomars;

/**
 * Interface SpaceShip
 */
public interface SpaceShip {
    public boolean launch();

    public boolean land();

    public boolean canCarry(Item item);

    public void carry(Item item);
}
