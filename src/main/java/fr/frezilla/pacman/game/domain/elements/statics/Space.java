package fr.frezilla.pacman.game.domain.elements.statics;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Space extends StaticElement {
    
    private SpaceType spaceType;
    
}
