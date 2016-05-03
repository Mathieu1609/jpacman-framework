package nl.tudelft.jpacman.multiplayers;


import java.util.ArrayList;

public class Joueur {

	private int numero;
	private int score;
	private String name;
	private ArrayList<Joueur> listJoueur;
	private int nbrJoueur;
	
	public Joueur(String name,int numero,int score){
		
		this.name=name;
		this.numero=numero;
		this.score=score;
		
	}
	public Joueur(){}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ArrayList<Joueur> getListJoueur() {
		return listJoueur;
	}
	public void setListJoueur(ArrayList<Joueur> listJoueur) {
		this.listJoueur = listJoueur;
	}
	public void setNbrJoueur(int n)
	{
		this.nbrJoueur=n;
	}
	public int getNbrJoueur()
	{
		return nbrJoueur;
	}
	public void addJoueur(Joueur j)
	{
		listJoueur.add(j);
	}
	public String getName() {
		return name;
	}
	
}
