package fr.frezilla.pacman.game.utils;

import java.util.Random;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class RandomGenerator {
    
    public final static int MAX = 1000;
    
    public static int generateNegativeInt() {
        return -generatePositiveInt();
    }
    
    public static int generateNumber(int low, int high) {
        if (low >= high) {
            throw new IllegalArgumentException();
        }
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }
    
    public static int generatePositiveInt() {
        return generateNumber(1, MAX);
    }
    
    
    
}
