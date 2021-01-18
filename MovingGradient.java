/* This file is used to create a moving linear gradient rectangle with the use of the fill color and the border color.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Point;

public class MovingGradient extends MovingShape {
	public MovingGradient(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
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
		Graphics2D g2 = (Graphics2D) g;
		Point start = new Point(topLeft.x, topLeft.y);
		Point end = new Point(topLeft.x + width, topLeft.y + height);
		float[] dist = {0.2f, 0.4f, 0.5f, 0.6f, 0.8f, 1f};
		Color[] colors = {fillColor, borderColor, fillColor, borderColor, fillColor, fillColor};
		LinearGradientPaint lgp = new LinearGradientPaint(start, end, dist, colors);
		g2.setPaint(lgp);
		g2.fillRect((int) topLeft.x, (int) topLeft.y, width, height);
		
		if (isSelected()) {
			drawHandles(g);
		}
	}

}
