import java.awt.*;

public class Dot extends Draw {

    public Dot(int x, int y) {
        super(x, y);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x-4, y-4, 10,10);
    }
}
