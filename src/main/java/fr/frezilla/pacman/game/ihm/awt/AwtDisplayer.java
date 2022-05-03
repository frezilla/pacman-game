package fr.frezilla.pacman.game.ihm.awt;

import fr.frezilla.pacman.game.ihm.AbstractDisplayer;
import fr.frezilla.pacman.game.ihm.Displayer;

public final class AwtDisplayer extends AbstractDisplayer implements Displayer {
    
    private static final int FPS = 60;
    
    public AwtDisplayer() {
        super(FPS);
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
