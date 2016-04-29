package nl.tudelft.jpacman.controls;

import java.util.ArrayList;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;

public abstract class ControlStrategy
{
	protected Game game;
	protected Player player;
	protected Direction last_dir;
	protected boolean running;
	
	protected final int MOVE_INTERVAL = 175;
	
	public ControlStrategy(Game game, Player player) 
	{
		this.game = game;
		this.player = player;
		start();
	}
	protected Direction opposite(Direction direction)
	{
		switch(direction)
		{
		case NORTH:
			return Direction.SOUTH;
		case SOUTH:
			return Direction.NORTH;
		case WEST:
			return Direction.EAST;
		case EAST:
			return Direction.WEST;
		default:
			break;
		}
		return direction;
	}
	protected boolean isIntersection(Square square)
	{
		Direction[] dirs_list = Direction.values();
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		if (square.isAccessibleTo(player))
		{	
			for(int i=0; i < dirs_list.length; i++)
			{
				if (square.getSquareAt(dirs_list[i]).isAccessibleTo(player))
				{
					dirs.add(dirs_list[i]);
					if ((dirs.size() == 2 && dirs.get(0) != opposite(dirs.get(1)))
							|| dirs.size() > 2)
						return true;
				}
			}
		}
		return false;
	}
	public void setDirection(Direction dir)
	{
		if (player.getSquare().getSquareAt(dir).isAccessibleTo(player))
		{
			this.last_dir = dir;
		}
	}
	protected void move(Direction dir)
	{
		if (player.getSquare().getSquareAt(dir).isAccessibleTo(player))
		{
			this.last_dir = dir;
			this.game.move(player, dir);
		}
	}
	public void start()
	{	
		running = true;
		Runnable run = new Runnable() {
		    public void run() {
		        while(player.isAlive() && running)
		    	{
		   			if (game.isInProgress())
		   			{
		   				Direction nextMove = nextMove();
		   				if (nextMove != null)
		   						move(nextMove);
		   			}
	    			try{
		   				Thread.sleep(MOVE_INTERVAL);
		   			} catch (InterruptedException e) {
		    				e.printStackTrace();
		    		}
		   			
		   		}      
		    }
		 };
		 new Thread(run).start();
	}
	public void stop()
	{
		this.running = false;
	}
	public abstract Direction nextMove();
	
}
