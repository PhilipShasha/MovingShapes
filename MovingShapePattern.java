/* This file is used to create a moving shape pattern, made with many individual lines to make it more detailed.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MovingShapePattern extends MovingShape {
	public MovingShapePattern(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
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
		g.setColor(borderColor);
		
		g.drawLine(topLeft.x + width / 2, topLeft.y, topLeft.x + (width / 2) + (width / 10), topLeft.y + (height / 10));
		g.drawLine(topLeft.x + width / 2, topLeft.y, topLeft.x + (width / 2) - (width / 10), topLeft.y + (height / 10));
		g.drawLine((int) (topLeft.x + width * 0.1), topLeft.y + height / 10, topLeft.x + width / 2 - width / 10, topLeft.y + height / 10);
		g.drawLine(topLeft.x + (width / 2) + (width / 10), topLeft.y + (height / 10), (int) (topLeft.x + width * 0.9), topLeft.y + height / 10);
		
		g.drawLine((int) (topLeft.x + (width / 10)), topLeft.y + height / 10, (int) (topLeft.x + (width / 10)), (int) (topLeft.y + height / 2 - height * 0.1));
		g.drawLine((int) (topLeft.x + (width / 10)), topLeft.y + height / 2 + height / 10, (int) (topLeft.x + (width / 10)), (int) (topLeft.y + height * 0.9));
		
		g.drawLine(topLeft.x, topLeft.y + height / 2, topLeft.x + width / 10, topLeft.y + height / 2 - height / 10);
		g.drawLine(topLeft.x, topLeft.y + height / 2, topLeft.x + width / 10, topLeft.y + height / 2 + height / 10);
		
		g.drawLine(topLeft.x + width / 10, (int) (topLeft.y + height * 0.9), topLeft.x + width / 2 - width / 10, (int) (topLeft.y + height * 0.9));
		g.drawLine(topLeft.x + width / 2 + width / 10, (int) (topLeft.y + height * 0.9), topLeft.x + width - width / 10, (int) (topLeft.y + height * 0.9));
		
		g.drawLine(topLeft.x + width / 2 + width / 10, (int) (topLeft.y + height * 0.9), topLeft.x + width / 2, topLeft.y + height);
		g.drawLine(topLeft.x + width / 2, topLeft.y + height, topLeft.x + width / 2 - width / 10, (int) (topLeft.y + height * 0.9));
		
		g.drawLine(topLeft.x + width - width / 10, (int) (topLeft.y + height * 0.9), (int) (topLeft.x + width * 0.9), topLeft.y + height / 2 + height / 10);
		g.drawLine(topLeft.x + width - width / 10, topLeft.y + height / 2 + height / 10, topLeft.x + width - width / 10, topLeft.y + height / 2 + height / 10);
		
		g.drawLine(topLeft.x + width - width / 10, topLeft.y + height / 2 + height / 10, topLeft.x + width, topLeft.y + height / 2);
		g.drawLine(topLeft.x + width, topLeft.y + height / 2, topLeft.x + width - width / 10, topLeft.y + height / 2 - height / 10);
		g.drawLine(topLeft.x + width - width / 10, topLeft.y + height / 2 - height / 10, topLeft.x + width - width / 10, topLeft.y + height / 10);
		
		g.drawRect(topLeft.x, topLeft.y, width / 10, height / 10);
		g.drawRect(topLeft.x + width - width / 10, topLeft.y, width / 10, height / 10);
		g.drawRect(topLeft.x, topLeft.y + height - height / 10, width / 10, height / 10);
		g.drawRect(topLeft.x + width - width / 10, topLeft.y + height - height / 10, width / 10, height / 10);
		
		g.drawOval(topLeft.x + width / 10, topLeft.y + height / 10, (int) (width / 2), (int) (height / 2));
		g.drawOval(topLeft.x + width / 10, topLeft.y + height / 2 - height / 10, (int) (width / 2), (int) (height / 2));
		g.drawOval(topLeft.x + width / 2 - width / 10, topLeft.y + height / 10, (int) (width / 2), (int) (height / 2));
		g.drawOval(topLeft.x + width / 2 - width / 10, topLeft.y + height / 2 - height / 10, (int) (width / 2), (int) (height / 2));
		
		
		g.drawLine(topLeft.x + width / 5, topLeft.y + height / 2 - height / 5, topLeft.x + width / 2 - width / 5, topLeft.y + height / 2 - height / 5);
		g.drawLine(topLeft.x + width / 2 - width / 5, topLeft.y + height / 2 - height / 5, topLeft.x + width / 2 - width / 5, topLeft.y + height / 5);
		
		g.drawLine(topLeft.x + width / 2 + width / 5, topLeft.y + height / 2 - height / 5, topLeft.x + width - width / 5, topLeft.y + height / 2 - height / 5);
		g.drawLine(topLeft.x + width / 2 + width / 5, topLeft.y + height / 2 - height / 5, topLeft.x + width / 2 + width / 5, topLeft.y + height / 5);
		
		g.drawLine(topLeft.x + width / 5, topLeft.y + height / 2 + height / 5, topLeft.x + width / 2 - width / 5, topLeft.y + height / 2 + height / 5);
		g.drawLine(topLeft.x + width / 2 - width / 5, topLeft.y + height / 2 + height / 5, topLeft.x + width / 2 - width / 5, topLeft.y + height - height / 5);
		
		g.drawLine(topLeft.x + width / 2 + width / 5, topLeft.y + height / 2 + height / 5, topLeft.x + width - width / 5, topLeft.y + height / 2 + height / 5);
		g.drawLine(topLeft.x + width / 2 + width / 5, topLeft.y + height / 2 + height / 5, topLeft.x + width / 2 + width / 5, topLeft.y + height - height / 5);
		
		g.drawLine(topLeft.x + width / 2 + width / 5, topLeft.y + height / 2 + height / 5, topLeft.x + width / 2 + width / 10, topLeft.y + height / 2 + height / 10);
		
		g.drawLine(topLeft.x + width / 2 + width / 5, topLeft.y + height / 2 - height / 5, topLeft.x + width / 2 + width / 10, topLeft.y + height / 2 - height / 10);
		
		g.drawLine(topLeft.x + width / 2 - width / 5, topLeft.y + height / 2 - height / 5, topLeft.x + width / 2 - width / 10, topLeft.y + height / 2 - height / 10);
		
		g.drawLine(topLeft.x + width / 2 - width / 5, topLeft.y + height / 2 + height / 5, topLeft.x + width / 2 - width / 10, topLeft.y + height / 2 + height / 10);
		
		if (isSelected()) {
			drawHandles(g);
		}
	}

}