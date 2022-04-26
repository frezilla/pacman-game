package fr.frezilla.pacman.game.domain.characters;

import fr.frezilla.pacman.game.domain.elements.mobiles.MobileElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NonNull;

@Data
public final class Characters {
    
    private final List<MobileElement> mobileElements;
    
    public Characters() {
        mobileElements = new ArrayList<>();
    }
    
    public void addMobileElement(@NonNull MobileElement mobileElement) {
        mobileElements.add(mobileElement);
    }
    
    public Set<MobileElement> get(int x, int y) {
        return 
                this.mobileElements
                        .stream()
                        .filter(me -> me.getX() == x && me.getY() == y )
                        .collect(Collectors.toSet());
    }
    
}
