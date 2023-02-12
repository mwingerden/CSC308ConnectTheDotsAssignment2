import java.awt.*;

public abstract class Draw {
    protected int x;
    protected int y;

    public Draw(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void draw(Graphics g);
}
