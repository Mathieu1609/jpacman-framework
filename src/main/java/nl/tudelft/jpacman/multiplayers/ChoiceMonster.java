package nl.tudelft.jpacman.multiplayers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.tudelft.jpacman.Launcher;

public class ChoiceMonster extends JFrame implements ActionListener {
	
	private JButton twoPlayers,thirdPlayers,fourPlayers;
	private JButton blinky,clyde,inky,pinky;
	private JLabel player;
	private int numPlayer;
	private JPanel panel = new JPanel();
	public Joueur jInky,jClyde,jPinky,jBlinky,j;
	public ArrayList<Joueur>listJ=new ArrayList<Joueur>();
	private Launcher l = new Launcher();
	
	/**
	 * Creating buttons for different Monsters
	 */
	public void buttonGhost()
	{
		j=new Joueur();
		blinky = new JButton("Blinky");
		clyde = new JButton("Clyde");
		inky = new JButton("Inky");
		pinky = new JButton("Pinky");
		blinky.addActionListener(this);
		blinky.setVisible(false);
		blinky.setForeground(Color.RED);
		pinky.setForeground(Color.PINK);
		clyde.setForeground(Color.ORANGE);
		inky.setForeground(Color.CYAN);
		pinky.setVisible(false);
		clyde.setVisible(false);
		inky.setVisible(false);
		inky.addActionListener(this);
		pinky.addActionListener(this);
		clyde.addActionListener(this);
		JPanel panel2=new JPanel();
		panel2.add(blinky);
		panel2.add(inky);
		panel2.add(pinky);
		panel2.add(clyde);
		panel.add(panel2);
		panel.add(player,BorderLayout.SOUTH);
	}
	/**
	 * it brings up the buttons one time we chose a number of players
	 */
	public void appaerButtonGhost()
	{
		blinky.setVisible(true);
		pinky.setVisible(true);
		clyde.setVisible(true);
		inky.setVisible(true);
	}
	/**
	 * update texte player 
	 */
	public void affplayer()
	{
	
		player.setText("Joueur "+ numPlayer +", Veuillez chosir votre monstre");
		
	}
	/**
	 * creating buttons for choosing the number of players
	 */
	public void buttonPlayer()
	{
		player= new JLabel("Joueur "+ numPlayer +", Veuillez chosir votre monstre");
		twoPlayers = new JButton("2 joueurs");
		thirdPlayers = new JButton("3 joueurs");
		fourPlayers = new JButton("4 joueurs");
		twoPlayers.addActionListener(this);
	
		thirdPlayers.addActionListener(this);
		
		fourPlayers.addActionListener(this);

		this.setTitle("Nombre de joueurs");
		this.setSize(500,300);
		panel.add(twoPlayers);
		panel.add(thirdPlayers);
		panel.add(fourPlayers);
		this.setContentPane(panel);
		this.setVisible(true);
		buttonGhost();
	}
	/**
	 * manages the event of button clicks
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(pinky))
		{
			((JComponent) source).setVisible(false); 
			numPlayer++;
			affplayer();
			jPinky=new Joueur("pinky",numPlayer,0);
			listJ.add(jPinky);
			if (numPlayer==j.getNbrJoueur()+1)
				{
				launchGame();
				}
		}
		if(source.equals(clyde))
		{
			((JComponent) source).setVisible(false); 
			numPlayer++;
			affplayer();
			jClyde=new Joueur("clyde",numPlayer,0);
			listJ.add(jClyde);
			if (numPlayer==j.getNbrJoueur()+1)
			{
				launchGame();
			}
		
		}
		if(source.equals(inky))
		{
			((JComponent) source).setVisible(false);
			numPlayer++;
			affplayer(); 
			jInky=new Joueur("inky",numPlayer,0);
			listJ.add(jInky);
			if (numPlayer==j.getNbrJoueur()+1)
			{
				launchGame();
			}
		}
		if(source.equals(blinky))
		{
			((JComponent) source).setVisible(false);
			numPlayer++;
			affplayer(); 
			jBlinky=new Joueur("blinky",numPlayer,0);
			listJ.add(jBlinky);
			if (numPlayer==j.getNbrJoueur()+1)
			{
				launchGame();
			}
		}
		
		if(source.equals(twoPlayers))
		{
			nbrJoueur(2);
		}
		if(source.equals(thirdPlayers))
		{
			nbrJoueur(3);
		}		
		if(source.equals(fourPlayers))
		{
			nbrJoueur(4);
		}
					
	}
	public void launchGame()
	{
		l.launch();	this.setVisible(false);	
	}
	public void nbrJoueur( int nbr)
	{
		appaerButtonGhost();
		numPlayer=1;
		affplayer();
		j.setNbrJoueur(nbr);
		
	}
	

}
