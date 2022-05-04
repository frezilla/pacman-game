package fr.frezilla.pacman.game.ihm;

public abstract class AbstractDisplayer implements Displayer {
   
    private final int fps;
    private boolean isRunning;
    
    protected AbstractDisplayer(int fps) {
        if (fps < 1) {
            throw new IllegalArgumentException();
        }
        this.fps = fps;
        this.isRunning = false;
    }
    
    public abstract void dispose();
    
    public abstract void render();
    
    @Override
    public final void run() {
        final long delayPerFrame = (long) 1000000000.0 / this.fps;
        
        long lastTime = System.nanoTime();
        while (isRunning) {
            long nowTime = System.nanoTime();
            if (nowTime - lastTime < delayPerFrame) {
                continue;
            }
            lastTime = nowTime;
            render();
            
            long elapsedTime = System.nanoTime() - lastTime;
            long sleepTime = (delayPerFrame - elapsedTime) / 1000000;
            sleep(sleepTime);
            
        }
        dispose();
    }
    
    private void sleep(long sleepTime) {
        if (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
