package fr.frezilla.pacman.game.domain.elements.mobiles;

import fr.frezilla.pacman.game.domain.elements.Element;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class MobileElement extends Element {
    
    private Direction direction;
    private int position;
    private int statusTime;
    private int speed;
    

    
    
    
}
