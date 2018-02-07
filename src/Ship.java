import java.util.*;

public abstract class Ship {
	
	private int Health;
	
	public Ship(int Health) {
		this.setHealth(Health);
	}

	public int getHealth() {
		return Health;
	}

	public void setHealth(int health) {
		Health = health;
	}
	
	public abstract boolean inThere(int x,int y);
	
	public abstract ArrayList<Location> List();
	
	public abstract String toString();
	
	public abstract boolean Dead();
}
