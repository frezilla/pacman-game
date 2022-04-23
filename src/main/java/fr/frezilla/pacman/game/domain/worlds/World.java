package fr.frezilla.pacman.game.domain.worlds;

import fr.frezilla.pacman.game.domain.elements.statics.StaticElement;
import java.util.Iterator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public final class World implements Iterable<StaticElement>{
    
    public static final int MAX_CAPACITY = 1000000;
    private final int height;
    private final int width;
    
    @Getter(AccessLevel.NONE) private final StaticElement[] staticElements;
    
    public World(int width, int height) {
        if (width <= 0 || height <= 0 || width * height > MAX_CAPACITY) {
            throw new IllegalArgumentException();
        }
        this.height = height;
        this.width = width;
        staticElements = new StaticElement[this.height * this.width];
    }

    StaticElement get(int index) {
        return staticElements[index];
    }
    
    public StaticElement get(int x, int y) {
        if (x < 0 || y < 0 || x * y >= this.staticElements.length) {
            throw new IllegalArgumentException();
        }
        return this.staticElements[x + y * width];
    }

    @Override
    public Iterator<StaticElement> iterator() {
        return new WorldIterator(this);
    }
    
    public void set(int x, int y, @NonNull StaticElement staticElement) {
        if (x < 0 || y < 0 || x * y >= this.staticElements.length) {
            throw new IllegalArgumentException();
        }
        this.staticElements[x + y * this.width] = staticElement;
    }
    
}
