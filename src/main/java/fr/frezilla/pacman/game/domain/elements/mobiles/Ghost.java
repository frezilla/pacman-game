package fr.frezilla.pacman.game.domain.elements.mobiles;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Ghost extends MobileElement {
    
    private GhostColor color;
    private GhostStatus status;
    
    
}
