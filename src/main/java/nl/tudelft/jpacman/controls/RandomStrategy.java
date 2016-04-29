package nl.tudelft.jpacman.controls;

import java.util.Random;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;

public class RandomStrategy extends ControlStrategy{
	
	
	public RandomStrategy(Game game, Player player) 
	{
		super(game, player);
	}

	public Direction nextMove()
	{
		Random rand = new Random();
		Direction[] dirs_list = Direction.values();
		Direction dir = dirs_list[rand.nextInt(dirs_list.length)];
		Square sq = player.getSquare().getSquareAt(dir);	
		if(sq.isAccessibleTo(player))
		{
			return dir;
		}
		return nextMove();
	}
}
