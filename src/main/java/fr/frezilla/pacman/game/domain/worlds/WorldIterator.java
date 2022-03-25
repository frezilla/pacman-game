package fr.frezilla.pacman.game.domain.worlds;

import fr.frezilla.pacman.game.domain.elements.statics.StaticElement;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class WorldIterator implements Iterator<StaticElement> {
    
    private int index;
    private final int nbElements;
    private final World world;

    public WorldIterator(World world) {
        this.world = world;
        this.nbElements = this.world.getHeight() * this.world.getWidth();
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        return (this.index + 1 < this.nbElements);
    }

    @Override
    public StaticElement next() {
        if (!(this.index + 1 < this.nbElements)) {
            throw new NoSuchElementException();
        }
        this.index++;
        return this.world.get(this.index);
    }
}
