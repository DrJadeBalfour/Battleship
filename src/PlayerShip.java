public class PlayerShip {

	private boolean picked; 
	private boolean ship;
	
	public PlayerShip() {
		setPicked(setShip(false));
	}

	public boolean isPicked() {
		return picked;
	}

	public void setPicked(boolean picked) {
		this.picked = picked;
	}

	public boolean isShip() {
		return ship;
	}

	public boolean setShip(boolean ship) {
		this.ship = ship;
		return ship;
	}	
}
