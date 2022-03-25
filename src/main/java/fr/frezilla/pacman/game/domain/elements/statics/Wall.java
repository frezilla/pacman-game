package fr.frezilla.pacman.game.domain.elements.statics;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Wall extends StaticElement {
    
    private WallType wallType;
    
}
