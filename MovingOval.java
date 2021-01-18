/* This file is used to create a moving oval.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MovingOval extends MovingShape {
	public MovingOval(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
        topLeft = new Point(x,y);
        width = w;
        height = h;
        marginWidth = mw;
        marginHeight = mh;
        borderColor = c;
        fillColor = fc;
        setPath (pathType);
    }

	@Override
	public boolean contains(Point p) {
		Point EndPt = new Point(topLeft.x + width, topLeft.y + height);
		double dx = (2 * p.x - topLeft.x - EndPt.x) / (double) width;
		double dy = (2 * p.y - topLeft.y - EndPt.y) / (double) height;
		return dx * dx + dy * dy < 1.0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillOval(topLeft.x, topLeft.y, width, height);
		
		g.setColor(borderColor);
		g.drawOval(topLeft.x, topLeft.y, width, height);
		
		if (isSelected()) {
			drawHandles(g);
		}
	}

}
