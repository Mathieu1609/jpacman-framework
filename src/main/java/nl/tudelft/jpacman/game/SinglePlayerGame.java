package nl.tudelft.jpacman.game;

import java.util.List;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.controls.ControlStrategy;
import nl.tudelft.jpacman.controls.PlayerStrategy;
import nl.tudelft.jpacman.controls.ScoreStrategy;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;

import com.google.common.collect.ImmutableList;

/**
 * A game with one player and a single level.
 * 
 * @author Jeroen Roosen 
 */
public class SinglePlayerGame extends Game {

	private ControlStrategy pacmanControls;
	/**
	 * The player of this game.
	 */
	private final Player player;

	/**
	 * The level of this game.
	 */
	private final Level level;

	/**
	 * Create a new single player game for the provided level and player.
	 * 
	 * @param p
	 *            The player.
	 * @param l
	 *            The level.
	 */
	protected SinglePlayerGame(Player p, Level l) {
		assert p != null;
		assert l != null;

		this.player = p;
		this.level = l;
		level.registerPlayer(p);
		this.pacmanControls = new PlayerStrategy(this,p);
	}

	@Override
	public List<Player> getPlayers() {
		return ImmutableList.of(player);
	}

	@Override
	public Level getLevel() {
		return level;
	}
	public ControlStrategy getPacmanControls(){
		return this.pacmanControls;
	}
	public void toggleAI(){
		if (pacmanControls instanceof PlayerStrategy){
			pacmanControls.stop();
			pacmanControls = new ScoreStrategy(this,player);
		}
		else{
			pacmanControls.stop();
			pacmanControls = new PlayerStrategy(this,player);
		}
	}
	/**
	 * Moves the player one square to the north if possible.
	 */
	public void moveUp() {
		move(player, Direction.NORTH);
	}

	/**
	 * Moves the player one square to the south if possible.
	 */
	public void moveDown() {
		move(player, Direction.SOUTH);
	}

	/**
	 * Moves the player one square to the west if possible.
	 */
	public void moveLeft() {
		move(player, Direction.WEST);
	}

	/**
	 * Moves the player one square to the east if possible.
	 */
	public void moveRight() {
		move(player, Direction.EAST);
	}

}
