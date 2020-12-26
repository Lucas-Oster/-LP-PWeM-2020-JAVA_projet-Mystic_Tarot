package vue;
import javax.swing.JButton;

import Controleur.Controleur;
import model.Carte;

/**
 * Classe de gestion d'un bouton
 * Le bouton represente une carte du paquet 
 * Cliquer sur un bouton permet d'afficher la carte selectionnee
 * @author lucas Oster
 * @version 1.0
 */
public class BoutonCarte extends JButton {
	Carte carte;
	/**
	 * créer un bouton avec l'image de la carte
	 * @param carte la carte attacher au bouton
	 */
	public BoutonCarte(Carte carte) {
		super(carte.getImageCarte());
		this.carte = carte;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	/**
	 * permet au controleur d'etre à l'ecoute du bouton
	 * @param controleur qui gere les evenements
	 */
	public void enregistreEcouteur(Controleur controleur) {
		this.addActionListener(controleur);
	}


}
