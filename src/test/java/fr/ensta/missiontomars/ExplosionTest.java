package fr.ensta.missiontomars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Create a rocket and launch multiple time")
class ExplosionTest {

    @Test
    @DisplayName("Should test the probabilistic distribution of explosion of U1")
    void launchU1Test() {
        int numberOfSuccesfulLaunch = 0;
        U1 u1 = new U1();
        u1.carry(new Item(8));
        for(int i=0; i<1000000; i++){
            if(u1.launch()==true) numberOfSuccesfulLaunch++;
        }
        System.out.println(numberOfSuccesfulLaunch);
        assertTrue(948000 <= numberOfSuccesfulLaunch && numberOfSuccesfulLaunch <= 1000000);
    }

    @Test
    @DisplayName("Should test the probabilistic distribution of explosion of U2")
    void launchU2Test() {
        int numberOfSuccesfulLaunch = 0;
        U2 u2 = new U2();
        u2.carry(new Item(11));
        for(int i=0; i<1000000; i++){
            if(u2.launch()==true) numberOfSuccesfulLaunch++;
        }
        System.out.println(numberOfSuccesfulLaunch);
        assertTrue(958000 <= numberOfSuccesfulLaunch && numberOfSuccesfulLaunch <= 1000000);
    }
}