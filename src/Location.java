public class Location {
	
	private int x,y;
	private boolean good=true;
	
	public Location(int x,int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean isGood() {
		return good;
	}

	public void setGood() {
		good = false;
	}
	
	public boolean equals(int x,int y) {
		return ((this.x==x)&&(this.y==y));
	}
}
