import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game extends Applet implements  MouseListener {

	private ArrayList<Ship> Opponent;
	private boolean[][] PTried, OTried;
	private final int Size = 10; 
	private AudioClip Sploosh, Kerboom, Win, Lose;
	private PlayerShip[][] grid;
	private boolean Ready = false, First = true ,hitSomething = false;
	private int pX, pY, Ship = 5, pZ, pS, Direction = 0, End = 0;
	private int Count = 0,Z,S;

	public void init() {
		Opponent = new ArrayList<Ship>();
		Sploosh = getAudioClip(getCodeBase(),"/Battleship/src/Salvatore_Sploosh.wav");
		Kerboom = getAudioClip(getCodeBase(),"/Battleship/src/Salvatore_Kerboom.wav");
		Win = getAudioClip(getCodeBase(),"/Battleship/src/Salvatore_HoorayYay.wav");
		Lose = getAudioClip(getCodeBase(),"/Battleship/src/Salvatore_Siren.wav");
		setUpAll(Opponent);
		PTried = new boolean[Size][Size];
		for(int i=0;i<PTried.length;i++)
			for(int j=0;j<PTried[0].length;j++)
				PTried[i][j]= false;
		OTried = new boolean[Size][Size];
		for(int i=0;i<OTried.length;i++)
			for(int j=0;j<OTried[0].length;j++)
				OTried[i][j]= false;
		grid = new PlayerShip[Size][Size];
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++)
				grid[i][j] = new PlayerShip();
		addMouseListener(this);
	}

	public void setYours(int X, int Y, int Length) {
		boolean yes = false;
		if(Length == 5) 
			showStatus("Carrier: 5");
		else if(Length == 4) 
			showStatus("Battleship: 4");
		else if(Length == 3) 
			if(Count == 2)
				showStatus("Cruiser: 3");
			else
				showStatus("Sub: 3");
		else if(Length == 2) {
			showStatus("Patrol Boat: 2");
		}
		if(First) {
			pX = X;
			pY = Y;
			First = false;
		}
		else if((pX == X)&&(pY == Y))
			First = true;
		if(Length == 5) {
			if((inBounds(pX+4,pY))&&(X == (pX+4))&&(Y == pY)) {
				for(int i=pX;i<=X;i++)
					if(grid[i][Y].isShip()) {
						First = true;
						return;
					}	
				for(int i=pX;i<=X;i++) {
					grid[i][Y].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX-4,pY))&&(X == (pX-4))&&(Y == pY)) {
				for(int i=X;i<=pX;i++)
					if(grid[i][Y].isShip()) {
						First = true;
						return;
					}	
				for(int i=X;i<=pX;i++) {
					grid[i][Y].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX,pY-4))&&(X == pX)&&(Y == (pY-4))) {
				for(int j=Y;j<=pY;j++)
					if(grid[X][j].isShip()) {
						First = true;
						return;
					}	
				for(int j=Y;j<=pY;j++) {
					grid[X][j].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX,pY+4))&&(X == pX)&&(Y == (pY+4))) {
				for(int j=pY;j<=Y;j++)
					if(grid[X][j].isShip()) {
						First = true;
						return;
					}
				for(int j=pY;j<=Y;j++) {
					grid[X][j].setShip(true);
					First = true;
					yes = true;
				}
			}
		}
		else if(Length == 4) {
			if((inBounds(pX+3,pY))&&(X == (pX+3))&&(Y == pY)) {
				for(int i=pX;i<=X;i++)
					if(grid[i][Y].isShip()) {
						First = true;
						return;
					}	
				for(int i=pX;i<=X;i++) {
					grid[i][Y].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX-3,pY))&&(X == (pX-3))&&(Y == pY)) {
				for(int i=X;i<=pX;i++)
					if(grid[i][Y].isShip()) {
						First = true;
						return;
					}	
				for(int i=X;i<=pX;i++) {
					grid[i][Y].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX,pY-3))&&(X == pX)&&(Y == (pY-3))) {
				for(int j=Y;j<=pY;j++)
					if(grid[X][j].isShip()) {
						First = true;
						return;
					}	
				for(int j=Y;j<=pY;j++) {
					grid[X][j].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX,pY+3))&&(X == pX)&&(Y == (pY+3))) {
				for(int j=pY;j<=Y;j++)
					if(grid[X][j].isShip()) {
						First = true;
						return;
					}
				for(int j=pY;j<=Y;j++) {
					grid[X][j].setShip(true);
					First = true;
					yes = true;
				}
			}
		}
		else if(Length == 3) {
			if((inBounds(pX+2,pY))&&(X == (pX+2))&&(Y == pY)) {
				for(int i=pX;i<=X;i++)
					if(grid[i][Y].isShip()) {
						First = true;
						return;
					}	
				for(int i=pX;i<=X;i++) {
					grid[i][Y].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX-2,pY))&&(X == (pX-2))&&(Y == pY)) {
				for(int i=X;i<=pX;i++)
					if(grid[i][Y].isShip()) {
						First = true;
						return;
					}	
				for(int i=X;i<=pX;i++) {
					grid[i][Y].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX,pY-2))&&(X == pX)&&(Y == (pY-2))) { 
				for(int j=Y;j<=pY;j++)
					if(grid[X][j].isShip()) {
						First = true;
						return;
					}	
				for(int j=Y;j<=pY;j++) {
					grid[X][j].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX,pY+2))&&(X == pX)&&(Y == (pY+2))) { 
				for(int j=pY;j<=Y;j++)
					if(grid[X][j].isShip()) {
						First = true;
						return;
					}	
				for(int j=pY;j<=Y;j++) {
					grid[X][j].setShip(true);
					First = true;
					yes = true;
				}
			}
		}
		else if(Length == 2) {
			if((inBounds(pX+1,pY))&&(X == (pX+1))&&(Y == pY)) {
				for(int i=pX;i<=X;i++)
					if(grid[i][Y].isShip()) {
						First = true;
						return;
					}	
				for(int i=pX;i<=X;i++) {
					grid[i][Y].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX-1,pY))&&(X == (pX-1))&&(Y == pY)) {
				for(int i=X;i<=pX;i++)
					if(grid[i][Y].isShip()) {
						First = true;
						return;
					}	
				for(int i=X;i<=pX;i++) {
					grid[i][Y].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX,pY-1))&&(X == pX)&&(Y == (pY-1))) { 
				for(int j=Y;j<=pY;j++)
					if(grid[X][j].isShip()) {
						First = true;
						return;
					}	
				for(int j=Y;j<=pY;j++) {
					grid[X][j].setShip(true);
					First = true;
					yes = true;
				}
			}
			else if((inBounds(pX,pY+1))&&(X == pX)&&(Y == (pY+1))) { 
				for(int j=pY;j<=Y;j++)
					if(grid[X][j].isShip()) {
						First = true;
						return;
					}	
				for(int j=pY;j<=Y;j++) {
					grid[X][j] .setShip(true);
					First = true;
					yes = true;
				}
			}
		}
		if(yes) 
			Count++;
	}

	public void paint(Graphics g) {
		for(int i=0;i<PTried.length;i++) 
			for(int j=0;j<PTried.length;j++) {
				if(PTried[i][j])
					g.setColor(Color.cyan);
				else
					g.setColor(Color.blue);
				g.fillRect(j*30+5,i*30+5,30,30);
			}
		for(int i=0;i<grid.length;i++) 
			for(int j=0;j<grid.length;j++) {
				if(grid[i][j].isPicked())
					if(grid[i][j].isShip())
						g.setColor(Color.red);
					else
						g.setColor(Color.cyan);
				else if(grid[i][j].isShip())
					g.setColor(Color.orange);
				else
					g.setColor(Color.blue);
				g.fillRect(j*30+5,i*30+315,30,30);
			}
		for(Ship q:Opponent) 
			for(Location w:q.List())
				if(!w.isGood()) {
					g.setColor(Color.red);
					g.fillRect(w.getX()*30+5, w.getY()*30+5, 30, 30);
				}
		g.setColor(Color.black);
		for(int i=0;i<Size;i++)
			for(int j=0;j<Size;j++)
				g.drawRect(j*30+5,i*30+5,30,30);
		for(int i=0;i<Size;i++)
			for(int j=0;j<Size;j++)
				g.drawRect(j*30+5,i*30+315,30,30);
	}

	public boolean okay(ArrayList<Ship> Thing ,int x,int y,boolean Vert,String ship) {
		if(Vert) 
			for(Ship q :Thing) {
				if(q.inThere(x, y))
					return false;
				if(q.inThere(x, y+1))
					return false;
				if(!ship.equals("Small")) { 
					if(q.inThere(x, y+2))
						return false;
					if((ship.equals("Battleship")||(ship.equals("Carrier")))) {
						if(q.inThere(x, y+3))
							return false;
						if(ship.equals("Carrier"))
							if(q.inThere(x, y+4))
								return false;
					}
				}
			}
		else
			for(Ship q:Thing) {
				if(q.inThere(x, y))
					return false;
				if(q.inThere(x+1, y))
					return false;
				if(!ship.equals("Small")) { 
					if(q.inThere(x+2, y))
						return false;
					if(ship.equals("Carrier")) {
						if(q.inThere(x+3, y))
							return false;
						if(q.inThere(x+4, y))
							return false;
					}
				}
			}
		return true; 
	}

	public void BattleShip(ArrayList<Ship> Thing) {
		int x, y, V;
		V = (int) (Math.random()*2);
		if(V==0) {
			x = (int) (Math.random()*10);
			y = (int) (Math.random()*7);
			Thing.add(new BattleShip(4, x, y, x, y+1, x, y+2, x, y+3));
		}
		else {
			x = (int) (Math.random()*7);
			y = (int) (Math.random()*10);
			Thing.add(new BattleShip(4, x, y, x+1, y, x+2, y, x+3, y));
		}
	}

	public void Small(ArrayList<Ship> Thing) {
		int x, y, V;
		V = (int) (Math.random()*2);
		if(V==0) {
			do {
				x = (int) (Math.random()*10);
				y = (int) (Math.random()*9);
			}
			while(!okay(Thing, x, y, true, "Small"));
			Thing.add(new Small(4, x, y, x, y+1));
		}
		else {
			do {
				x = (int) (Math.random()*9);
				y = (int) (Math.random()*10);
			}
			while(!okay(Thing, x, y, false, "Small"));
			Thing.add(new Small(4 ,x, y, x+1, y));
		}
	}

	public void Carrier(ArrayList<Ship> Thing) {
		int x, y, V;
		V = (int) (Math.random()*2);
		if(V==0) {
			do {
				x = (int) (Math.random()*10);
				y = (int) (Math.random()*6);
			}
			while(!okay(Thing, x, y, true, "Carrier"));
			Thing.add(new Carrier(4, x, y, x, y+1, x, y+2, x, y+3, x,y+4));
		}
		else {
			do {
				x = (int) (Math.random()*6);
				y = (int) (Math.random()*10);
			}
			while(!okay(Thing,x,y,false,"Carrier"));
			Thing.add(new Carrier(4,x,y,x+1,y,x+2,y,x+3,y,x+4,y));
		}
	}

	public void Med(ArrayList<Ship> Thing) {
		int x,y,V;
		V = (int) (Math.random()*2);
		if(V==0) {
			do {
				x = (int) (Math.random()*10);
				y = (int) (Math.random()*8);
			}
			while(!okay(Thing,x,y,true,"Med"));
			Thing.add(new Med(3,x,y,x,y+1,x,y+2));
		}
		else {
			do {
				x = (int) (Math.random()*8);
				y = (int) (Math.random()*10);
			}
			while(!okay(Thing,x,y,false,"Med"));
			Thing.add(new Med(3,x,y,x+1,y,x+2,y));
		}
	}

	public void setUpAll(ArrayList<Ship> Thing) {
		BattleShip(Thing);
		Carrier(Thing);
		Med(Thing);
		Med(Thing);
		Small(Thing);
	}

	public boolean inBounds(int X,int Y) {
		return ((X>=0)&&(X<Size)&&(Y>=0)&&(Y<Size));
	}

	public int convert(int it) {
		return (it-5)/30;
	}

	public boolean Picked(int X,int Y,int Dir) {
		if(Dir==0) 
			if(inBounds(X-1,Y))
				return grid[X-1][Y].isPicked();
		if(Dir==1)
			if(inBounds(X,Y+1))
				return grid[X][Y+1].isPicked();
		if(Dir==2)
			if(inBounds(X+1,Y))
				return grid[X+1][Y].isPicked();
		if(Dir==3)
			if(inBounds(X,Y-1))
				return grid[X][Y-1].isPicked();
		return true;
	}

	public void hisMove() {
		int o = 0;
		if(hitSomething) {
			if(Direction == 0) 
				Z--;
			else if(Direction == 1)
				S++;
			else if(Direction == 2)
				Z++;
			else if(Direction == 3)
				S--;
			if((!inBounds(Z,S))||(grid[Z][S].isPicked())) {
				Z=pZ;
				S=pS;
				End++;
				if(End == 4) {
					genericMove();
					return;
				}
				do {
					Direction = (int) (Math.random() * 4);
					o++;
					if(o >= 100) 
						break;
				}
				while((Picked(Z,S,Direction))||(o >= 100));
				if( o>= 100) {
					genericMove();
					return;
				}
				if(Direction == 0) 
					Z--;
				else if(Direction == 1)
					S++;
				else if(Direction == 2)
					Z++;
				else if(Direction == 3)
					S--;
				grid[Z][S].setPicked(true);
				if(!grid[Z][S].isShip()) {
					End ++;
					Z = pZ;
					S = pS;
					Direction+=2;
					if(Direction>=4)
						Direction-=4;
					if(End == 2)
						Direction --;
				}
			}
			else {
				grid[Z][S].setPicked(true);
				if(!grid[Z][S].isShip()) {
					End++;
					Z=pZ;
					S=pS;
					Direction += 2;
					if(Direction >= 4)
						Direction -= 4;
					if(End == 2)
						Direction --;
				}
			}
		}
		else if(End ==4) 
			genericMove();
		else  
			genericMove();
	}

	public void genericMove() {
		do {
			Z = (int) (Math.random()*10);
			S = (int) (Math.random()*10);
		}
		while((grid[Z][S].isPicked())||(Z%2==S%2));
		grid[Z][S].setPicked(true);
		if(grid[Z][S].isShip()) {
			pZ =Z;
			pS =S;
			hitSomething = true;
			do
				Direction = (int) (Math.random()*4);
			while(Picked(Z,S,Direction));
		}
		else
			hitSomething = false;
		End =0;
	}

	public boolean didYouWin() {
		for(Ship q: Opponent) 
			for(Location w:q.List())
				if(w.isGood())
					return false;
		return true;
	}

	public boolean didHeWin() {
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++)
				if(grid[i][j].isShip())
					if(!grid[i][j].isPicked())
						return false;
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		showStatus("");
		boolean hit =false;
		int X = arg0.getX();
		int Y = arg0.getY();
		int Row = -1;
		int Col = -1;
		if(arg0.isMetaDown())
			First = true;
		if((Ready)&&(X>=5)&&(X<=305)&&(Y>=5)&&(Y<=305)) {
			Col = convert(X);
			Row = convert(Y);
		}
		else if((!Ready)&&(Y>=315)&&(Y<=605)&&(X>=5)&&(X<=305)) {
			Col = convert(X);
			Row = convert(Y-310);
		}
		if(!Ready) {
			setYours(Row,Col,Ship); 
			if(Count == 1)
				Ship = 4;
			else if((Count==2)||(Count==3))
				Ship = 3;
			else if(Count ==4)
				Ship = 2;
			else if(Count==5)
				Ready =true;
		}
		else if((Ready)&&(inBounds(Row,Col))&&(!PTried[Row][Col])) {
			PTried[Row][Col] = true;
			for(Ship q : Opponent) 
				for(Location w :q.List())
					if(w.equals(Col, Row)) {
						w.setGood();
						q.setHealth(q.getHealth()-1);
						hit = true;				
						if(didYouWin()) {
							showStatus("You win!");
							removeMouseListener(this);
							repaint();
							Win.loop();
							return;
						}
						Kerboom.play();
					}
			if(!hit) 
				Sploosh.play(); 
			hisMove();
		}
		if(Ready)
			if(didHeWin()) {
				showStatus("You lose!");
				removeMouseListener(this);
				Lose.loop();
			}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}