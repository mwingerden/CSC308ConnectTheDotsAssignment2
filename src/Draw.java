import java.awt.*;

public abstract class Draw {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected Color color;

    public Draw(int x1, int y1, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }

    public Draw(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    abstract void draw(Graphics g);

    abstract Line updateLine(Draw dot);

    abstract void updateCluster(int width, int height);

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
}
