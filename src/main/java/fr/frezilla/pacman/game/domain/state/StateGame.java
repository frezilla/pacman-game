package fr.frezilla.pacman.game.domain.state;

import fr.frezilla.pacman.game.domain.characters.Characters;
import fr.frezilla.pacman.game.domain.worlds.World;
import lombok.Data;

@Data
public final class StateGame {
    
    private final Characters characters;
    private final World world;
    
}
