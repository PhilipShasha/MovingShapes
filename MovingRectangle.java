/* This file is used to create a moving rectangle.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MovingRectangle extends MovingShape {
	public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
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
		if (p.y >= topLeft.y && p.y <= (topLeft.y + height) && p.x >= topLeft.x && p.x <= (topLeft.x + width)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillRect(topLeft.x, topLeft.y, width, height);
		
		g.setColor(borderColor);
		g.drawRect(topLeft.x - 1, topLeft.y - 1, width + 1, height + 1);
		
		if (isSelected()) {
			drawHandles(g);
		}
	}

}
