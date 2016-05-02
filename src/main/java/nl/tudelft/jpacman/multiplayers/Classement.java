package nl.tudelft.jpacman.multiplayers;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.tudelft.jpacman.Launcher;

public class Classement extends JFrame {

	
	private int numeroJoueur=0;
	
	public void classementJoueur()
	{
		JPanel panel=new JPanel();
		Launcher l=new Launcher();
		/**
		 *  check if blinky is différent of null, if yes, create label blinky 
		 */
		if(l.cM.jBlinky!=null )
		{
			numeroJoueur++;
			JLabel joueur1= new JLabel("Blinky,joueur"+numeroJoueur +",Votre score est :"+l.cM.jBlinky.getScore());
			panel.add(joueur1);
		}
		/**
		 * 
		 *  check if pinky is différent of null, if yes, create label pinky 
		 */
		if(l.cM.jPinky!=null )
		{
			numeroJoueur++;
			JLabel joueur2= new JLabel("Pinky,joueur"+numeroJoueur +", Votre score est :" +l.cM.jPinky.getScore());
			panel.add(joueur2);
		}
		/**
		 *  check if clyde is différent of null, if yes, create label clyde 
		 */
		 
		if(l.cM.jClyde!=null )
		{
			numeroJoueur++;
			JLabel joueur4= new JLabel("Clyde,joueur"+numeroJoueur +", Votre score est :" +l.cM.jClyde.getScore());
			panel.add(joueur4);
		}
		/**
		 * 
		 *  check if inky is différent of null, if yes, create label inky 
		 */
		if(l.cM.jInky!=null )
		{
			numeroJoueur++;			
			JLabel joueur3= new JLabel("Inky,joueur"+numeroJoueur +", Votre score est :"+l.cM.jInky.getScore());
			panel.add(joueur3);
		}
		
				
		this.setTitle("Classement des joueurs");
		this.setSize(700,300);
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
