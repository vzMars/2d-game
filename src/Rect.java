import java.awt.Graphics;

public class Rect {
	int x;
	int y;
	int w;
	int h;

	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void go_UP(int dy) {
		y -= dy;
	}

	public void go_DN(int dy) {
		y += dy;
	}

	public void go_LT(int dx) {
		x -= dx;
	}

	public void go_RT(int dx) {
		x += dx;
	}

	public boolean overlaps(Rect r) {
		return (x <= r.x + r.w) &&
			   (x + w >= r.x)   &&
			   (y <= r.y + r.h) &&
			   (y + h >= r.y);
	}
	
	public void pushAwayFrom(Rect r) {
		if(wasLeftOf(r)) pushLeftOf(r);
		if(wasRightOf(r)) pushRightOf(r);
		if(wasAbove(r)) pushAbove(r);
		if(wasBelow(r)) pushBelow(r);
	}
	
	public boolean wasLeftOf(Rect r) {
		return x - 2 < r.x - w + 1;
	}
	
	public boolean wasRightOf(Rect r) {
		return x + 2 > r.x + r.w - 1;
	}

	public boolean wasAbove(Rect r) {
		return y - 2 < r.y - h + 1;
	}
	
	public boolean wasBelow(Rect r) {
		return y + 2 > r.y + r.h - 1;
	}

	public void pushLeftOf(Rect r) {
		x = r.x - w - 1;
	}
	
	public void pushRightOf(Rect r) {
		x = r.x + r.w + 1;
	}
	
	public void pushAbove(Rect r) {
		y = r.y - h - 1;
	}
	
	public void pushBelow(Rect r) {
		y = r.y + r.h + 1;
	}
	
	public void draw(Graphics pen) {
		pen.drawRect(x, y, w, h);
	}

}