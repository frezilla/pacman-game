package fr.frezilla.pacman.game.domain.worlds;

import fr.frezilla.pacman.game.domain.elements.statics.Space;
import fr.frezilla.pacman.game.domain.elements.statics.StaticElement;
import fr.frezilla.pacman.game.utils.RandomGenerator;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

class WorldTest {
    
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
    
    private Executable buildExecutableToConstruct(int width, int height) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                buildWorld(width, height);
            }
        };
    }
    
    private Executable buildExecutableToSet(int width, int height, final StaticElement staticElement) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                World world;
                try {
                    world = buildRandomWorld();
                } catch (IllegalArgumentException e) {
                    world = null;
                }
                if (world != null) {
                    world.set(width, height, staticElement);
                }
            }
        };
    }
    
    @Test
    void accessorsTest() {
        final StaticElement staticElement = new Space();
        int width;
        int height;

        width = RandomGenerator.generateNegativeInt();
        height = RandomGenerator.generateNegativeInt();
        assertThrows(IllegalArgumentException.class, buildExecutableToSet(width, height, staticElement));
        
        width = RandomGenerator.generateNegativeInt();
        height = 0;
        assertThrows(IllegalArgumentException.class, buildExecutableToSet(width, height, staticElement));
        
        width = RandomGenerator.generateNegativeInt();
        height = RandomGenerator.generatePositiveInt();
        assertThrows(IllegalArgumentException.class, buildExecutableToSet(width, height, staticElement));
        
        width = 0;
        height = RandomGenerator.generateNegativeInt();
        assertThrows(IllegalArgumentException.class, buildExecutableToSet(width, height, staticElement));
        
        width = RandomGenerator.generatePositiveInt();
        height = RandomGenerator.generateNegativeInt();
        assertThrows(IllegalArgumentException.class, buildExecutableToSet(width, height, staticElement));
        
        
        assertAll((Executable) () -> {
            World world = buildRandomWorld();
            
            int x = RandomGenerator.generateNumber(0, world.getWidth());
            int y = RandomGenerator.generateNumber(0, world.getHeight());
            world.set(x, y, staticElement);
            
            assertEquals(staticElement, world.get(x, y));
        });
    }
    
    @Test
    void constructionTest() {
        int width;
        int height;

        width = RandomGenerator.generateNegativeInt();
        height = RandomGenerator.generateNegativeInt();
        assertThrows(IllegalArgumentException.class, buildExecutableToConstruct(width, height));
        
        width = RandomGenerator.generateNegativeInt();
        height = RandomGenerator.generatePositiveInt();
        assertThrows(IllegalArgumentException.class, buildExecutableToConstruct(width, height));
        
        width = RandomGenerator.generatePositiveInt();
        height = RandomGenerator.generateNegativeInt();
        assertThrows(IllegalArgumentException.class, buildExecutableToConstruct(width, height));
                
        assertAll((Executable) () -> {
            int w = RandomGenerator.generatePositiveInt();
            int h = RandomGenerator.generatePositiveInt();
            World world = buildWorld(w, h);
            
            assertEquals(w, world.getWidth());
            assertEquals(h, world.getHeight());
        });
    }

    @Test
    void iteratorTest() {
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
