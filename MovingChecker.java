/* This file is used to create a moving checker with random checker sizes of 2-7. The checker colors alternate between fill color and border color.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;


public class MovingChecker extends MovingShape {
	private int ncolumn = (int) (Math.random() * 6) + 2;
	private int nrow = (int) (Math.random() * 6) + 2;

	public MovingChecker(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
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
	public void draw(Graphics g) { // if there are left over pixels due to uneven divisions, add 1 pixel to each square till there are none left over, repeat for each row/column
		
		int wremaining = width % nrow;
		int hremaining = height % ncolumn;
		int wleft = wremaining;
		int hleft = hremaining;
		boolean cswitch = true;
		double totalrow = topLeft.x;
		double totalcolumn = topLeft.y;
		
		Rectangle2D rect = new Rectangle2D.Double(topLeft.x, topLeft.y, width / nrow, height / ncolumn); 
		Graphics2D g2 = (Graphics2D) g;
		for (int i = ncolumn; i > 0; i--) {
			for (int j = nrow; j > 0; j--) {
				if (cswitch) {
					g2.setColor(fillColor);
					cswitch = false;
				}
				else {
					g2.setColor(borderColor);
					cswitch = true;
				}
				
				if (wleft > 0 && hleft > 0) {
					rect.setRect(totalrow, totalcolumn, (width / nrow) + 1, (height / ncolumn) + 1);
					g2.fill(rect);
					totalrow += (width / nrow) + 1;
					wleft += -1;
				}
				else if (wleft > 0) {
					rect.setRect(totalrow, totalcolumn, (width / nrow) + 1, height / ncolumn);
					g2.fill(rect);
					totalrow += (width / nrow) + 1;
					wleft += -1;
				}
				else if (hleft > 0) {
					rect.setRect(totalrow, totalcolumn, width / nrow, (height / ncolumn) + 1);
					g2.fill(rect);
					totalrow += width / nrow;
				}
				else {
					rect.setRect(totalrow, totalcolumn, width / nrow, height / ncolumn);
					g2.fill(rect);
					totalrow += width / nrow;
				}
				
				
			}
			wleft = wremaining;
			totalrow = topLeft.x;
			if (nrow % 2 == 0) {
				cswitch = !cswitch;
			}
			if (hleft > 0) {
				hleft += -1;
				totalcolumn += (height /ncolumn) + 1;
			}
			else {
				totalcolumn += height / ncolumn;
			}
			
		}
		if (isSelected()) {
			drawHandles(g);
		}
	}

}
