package fr.frezilla.pacman.game.domain.worlds;

import fr.frezilla.pacman.game.domain.elements.statics.StaticElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public final class World implements Iterable<StaticElement>{
    
    private final int height;
    private final int width;
    
    @Getter(AccessLevel.NONE) private final List<StaticElement> staticElements;
    
    public World(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.height = height;
        this.width = width;
        staticElements = new ArrayList<>(this.height * this.width);
    }

    StaticElement get(int index) {
        return staticElements.get(index);
    }
    
    public StaticElement get(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException();
        }
        return this.get(x + y * width);
    }

    @Override
    public Iterator<StaticElement> iterator() {
        return new WorldIterator(this);
    }
    
    public void set(int x, int y, @NonNull StaticElement staticElement) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException();
        }
        this.staticElements.add(x + y * this.width, staticElement);
    }
    
}
