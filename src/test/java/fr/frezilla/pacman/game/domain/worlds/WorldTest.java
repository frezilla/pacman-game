package fr.frezilla.pacman.game.domain.worlds;

import fr.frezilla.pacman.game.domain.elements.statics.Space;
import fr.frezilla.pacman.game.domain.elements.statics.StaticElement;
import fr.frezilla.pacman.game.utils.RandomGenerator;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

public class WorldTest {
    
    public WorldTest() {
    }
    
    private World buildRandomWorld() {
        return new World(
                RandomGenerator.generateNumber(1, 1000),
                RandomGenerator.generateNumber(1, 1000)
        );
    }
    
    private World buildWorld(int width, int height) {
        return new World(width, height);
    }
    
    @Test
    public void accessorsTest() {
        final StaticElement staticElement = new Space();
        
        assertThrows(
                IllegalArgumentException.class,
                () -> { 
                    World world = buildRandomWorld();
                    world.set(RandomGenerator.generateNegativeInt(), RandomGenerator.generateNegativeInt(), staticElement); 
                }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> { 
                    World world = buildRandomWorld();
                    world.set(RandomGenerator.generateNegativeInt(), 0, staticElement); 
                }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> { 
                    World world = buildRandomWorld();
                    world.set(RandomGenerator.generateNegativeInt(), RandomGenerator.generatePositiveInt(), staticElement); 
                }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> { 
                    World world = buildRandomWorld();
                    world.set(0, RandomGenerator.generateNegativeInt(), staticElement); 
                }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> { 
                    World world = buildRandomWorld();
                    world.set(RandomGenerator.generatePositiveInt(), RandomGenerator.generateNegativeInt(), staticElement); 
                }
        );
        assertAll((Executable) () -> {
            World world = buildRandomWorld();
            
            int x = RandomGenerator.generateNumber(1, world.getWidth());
            int y = RandomGenerator.generateNumber(1, world.getHeight());
            world.set(x, y, staticElement);
            
            assertEquals(staticElement, world.get(x, y));
        });
    }
    
    @Test
    public void constructionTest() {
        assertThrows(
                IllegalArgumentException.class, 
                () -> { buildWorld(RandomGenerator.generateNegativeInt(), RandomGenerator.generateNegativeInt()); }
        );
        assertThrows(
                IllegalArgumentException.class, 
                () -> { buildWorld(RandomGenerator.generateNegativeInt(), RandomGenerator.generatePositiveInt()); }
        );
        assertThrows(
                IllegalArgumentException.class, 
                () -> { buildWorld(RandomGenerator.generatePositiveInt(), RandomGenerator.generateNegativeInt()); }
        );
        assertAll((Executable) () -> {
            int width = RandomGenerator.generatePositiveInt();
            int height = RandomGenerator.generatePositiveInt();
            World world = buildWorld(width, height);
            
            assertEquals(width, world.getWidth());
            assertEquals(height, world.getHeight());
        });
    }

    @Test
    public void iteratorTest() {
        World world = buildRandomWorld();
        final int width = world.getWidth();
        final int height = world.getHeight();
        final StaticElement element = new Space();
        
        int nbElements = width * height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                world.set(i, j, element);
            }
        }
        Iterator<StaticElement> iterator = world.iterator();
        
        int nbElts = 0;
        while (iterator.hasNext()) {
            StaticElement elt = iterator.next();
            assertEquals(element, elt);
            nbElts++;
        }
        
        assertEquals(nbElements, nbElts);
        
    }
}
