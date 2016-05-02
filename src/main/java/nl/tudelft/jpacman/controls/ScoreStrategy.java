package nl.tudelft.jpacman.controls;

import java.util.ArrayList;
import java.util.Random;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.Ghost;

public class ScoreStrategy extends ControlStrategy{
	
	private final int GHOST_MALUS = 100;
	private final int PELLET_BONUS = 10;
	
	public ScoreStrategy(Game game, Player player) 
	{
		super(game, player);
	}
	private int score (Direction dir)
	{
		Square sq = this.player.getSquare().getSquareAt(dir);
		if (!sq.isAccessibleTo(this.player))
			return Integer.MIN_VALUE;
		int score = 0;
		int dist = 1;
		if (dir == lastdir)
			score = score + 5;
		for (Direction direction : Direction.values())
		{
			if (direction != dir && direction != opposite(dir))
			{
				Square sideSquare = sq.getSquareAt(direction);
				for(Unit unit : sideSquare.getOccupants())
				{
					if(unit instanceof Ghost)
					{
						score = score - GHOST_MALUS/2;
					}
				}
			}
		}
		while (sq.isAccessibleTo(this.player))
		{
			for(Unit unit : sq.getOccupants())
			{
				if(unit instanceof Ghost)
					score = score - GHOST_MALUS/dist;
				if(unit instanceof Pellet)
					score = score + PELLET_BONUS/dist;
			}
			sq = sq.getSquareAt(dir);
			dist++;
		}
		return score;
		
	}
	public Direction nextMove()
	{
		if (!isIntersection(player.getSquare()) && lastdir != null) //comment to improve AI
			return lastdir; //comment to improve AI
		Direction[] dirslist = Direction.values();
		int[] scoreslist = new int[dirslist.length];
		int max = Integer.MIN_VALUE;
		for (int i=0; i<dirslist.length; i++)
		{
			scoreslist[i] = score(dirslist[i]);
			if (scoreslist[i] > max)
			{
				max = scoreslist[i];
			}
		}
		ArrayList<Integer> best = new ArrayList<Integer>();
		for (int i=0; i<scoreslist.length; i++)
		{
			if (scoreslist[i] == max)
			{
				best.add(i);
			}
		}
		Random rand = new Random();
		return dirslist[best.get(rand.nextInt(best.size()))];
	}
}
