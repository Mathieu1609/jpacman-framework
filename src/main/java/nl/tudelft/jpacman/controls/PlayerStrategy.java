package nl.tudelft.jpacman.controls;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;

public class PlayerStrategy extends ControlStrategy{
	
	public PlayerStrategy(Game game, Player player) 
	{
		super(game, player);
	}
	public Direction nextMove()
	{
		return lastdir;
	}
}
