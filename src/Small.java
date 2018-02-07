import java.util.*;

public class Small extends Ship {

	private Location Loc1,Loc2;
	
	public Small(int Health,int x1,int y1,int x2,int y2) {
		super(Health);
		Loc1 = new Location(x1,y1);
		Loc2 = new Location(x2,y2);
	}

	public int getLoc1X() {
		return Loc1.getX();
	}
	
	public int getLoc1Y() {
		return Loc1.getY();
	}
	
	public int getLoc2X() {
		return Loc2.getX();
	}
	
	public int getLoc2Y() {
		return Loc2.getY();
	}
	
	@Override
	public boolean inThere(int x, int y) {
		return ((Loc1.equals(x, y))||(Loc2.equals(x, y)));
	}

	@Override
	public ArrayList<Location> List() {
		ArrayList<Location> List = new ArrayList<Location>();
		List.add(Loc1);
		List.add(Loc2);
		return List;
	}

	@Override
	public String toString() {
		return "Small";
	}
	
	@Override
	public boolean Dead() {
		for(Location k : List())
			if(k.isGood())
				return false;
		return true;
	}
}
