package vue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import Controleur.Controleur;
import model.Carte;
import model.JeuCartesTarot;
import model.LectureEcritureSerial;
/**
 * Classe principale de l'interface graphique,
 * Point de lancement du jeu de tarot,
 * Regroupe tout les pannels
 * @author lucas Oster
 * @version 1.0
 */
public class FenetreTarot extends JFrame{
	//La classe connait tout
	JeuCartesTarot jeu=null;
	Controleur controleur=null;
	JPanel grandPanelDroite=null;
	CarteUniquePanel carteUniquePane;
	AfficheCartesPanel afficheCartesPane;
	public FenetreTarot() {
		super("Jeu de Tarot");
		// importation du modele
		jeu = (JeuCartesTarot) LectureEcritureSerial.lecture("testEcriture.Serial");

		JPanel contentPane = (JPanel) getContentPane();
		//panel de gauche
		PanelGauche panelGauche=new PanelGauche();
		this.add(panelGauche);

		//panel de droite
		afficheCartesPane=new AfficheCartesPanel(jeu);
		grandPanelDroite = new JPanel();
		this.add(grandPanelDroite);
		GridLayout gridDroite = new GridLayout(2,2);
		grandPanelDroite.setLayout(gridDroite);
		carteUniquePane = new CarteUniquePanel(jeu.getCarte(0));
		grandPanelDroite.add(afficheCartesPane);
		grandPanelDroite.add(carteUniquePane);
		// separateur
		JSplitPane mainSplitPane =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelGauche ,grandPanelDroite);
		contentPane.add(mainSplitPane, BorderLayout.CENTER);
		Controleur controleur=new Controleur( jeu,  afficheCartesPane, carteUniquePane,
				this, panelGauche); 
	}
	public AfficheCartesPanel getAfficheCartesPane() {
		return afficheCartesPane;
	}
	public void setAfficheCartesPane(AfficheCartesPanel afficheCartesPane) {
		this.afficheCartesPane = afficheCartesPane;
	}
	public static void main(String [] args){
		// main principal de lancement de l'application
		FenetreTarot tarot=new FenetreTarot();

		//tarot.pack();
		tarot.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		tarot.setVisible(true);
		tarot.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/**
	 * permet de rafraichir le panel de droite apres modification ou suppresion
	 */
	public void repaintDroite() {
		// TODO Auto-generated method stub
		grandPanelDroite.removeAll();
		grandPanelDroite.add(afficheCartesPane);
		grandPanelDroite.add(carteUniquePane);
		grandPanelDroite.updateUI();
	}
}
