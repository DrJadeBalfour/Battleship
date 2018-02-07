import java.util.*;

public class Med extends Ship {

	private Location Loc1,Loc2,Loc3;
	
	public Med(int Health,int x1,int y1,int x2,int y2,int x3,int y3) {
		super(Health);
		Loc1 = new Location(x1,y1);
		Loc2 = new Location(x2,y2);
		Loc3 = new Location(x3,y3);
	}

	@Override
	public boolean inThere(int x, int y) {
		return ((Loc1.equals(x, y))||(Loc2.equals(x, y))||(Loc3.equals(x, y)));
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
	
	public int getLoc3X() {
		return Loc3.getX();
	}
	
	public int getLoc3Y() {
		return Loc3.getY();
	}
	
	@Override
	public ArrayList<Location> List() {
		ArrayList<Location> List = new ArrayList<Location>();
		List.add(Loc1);
		List.add(Loc2);
		List.add(Loc3);
		return List;
	}

	@Override
	public String toString() {
		return "Med";
	}

	@Override
	public boolean Dead() {
		for(Location k : List())
			if(k.isGood())
				return false;
		return true;
	}
}
