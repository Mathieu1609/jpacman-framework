package nl.tudelft.jpacman.multiplayers;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.tudelft.jpacman.Launcher;

public class Classement extends JFrame {

	private JPanel panel ;
	private Launcher l;
	private int numeroJoueur=0;
	
	public void classementJoueur()
	{
		panel=new JPanel();
		l=new Launcher();
		/**
		 *  check if blinky is différent of null, if yes, create label blinky 
		 */
		if(l.cM.jBlinky!=null )
		{
			numeroJoueur++;
			JLabel Joueur1= new JLabel("Blinky,joueur"+numeroJoueur +",Votre score est :"+l.cM.jBlinky.getScore());
			panel.add(Joueur1);
		}
		/**
		 * 
		 *  check if pinky is différent of null, if yes, create label pinky 
		 */
		if(l.cM.jPinky!=null )
		{
			numeroJoueur++;
			JLabel Joueur2= new JLabel("Pinky,joueur"+numeroJoueur +", Votre score est :" +l.cM.jPinky.getScore());
			panel.add(Joueur2);
		}
		/**
		 *  check if clyde is différent of null, if yes, create label clyde 
		 */
		 
		if(l.cM.jClyde!=null )
		{
			numeroJoueur++;
			JLabel Joueur4= new JLabel("Clyde,joueur"+numeroJoueur +", Votre score est :" +l.cM.jClyde.getScore());
			panel.add(Joueur4);
		}
		/**
		 * 
		 *  check if inky is différent of null, if yes, create label inky 
		 */
		if(l.cM.jInky!=null )
		{
			numeroJoueur++;			
			JLabel Joueur3= new JLabel("Inky,joueur"+numeroJoueur +", Votre score est :"+l.cM.jInky.getScore());
			panel.add(Joueur3);
		}
		
				
		this.setTitle("Classement des joueurs");
		this.setSize(700,300);
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
