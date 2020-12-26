package vue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controleur.Controleur;
import model.JeuCartesTarot;

/**
 * Classe d'affichage du jeu de carte complet
 * @author lucas Oster
 * @version 1.0
 */
public class AfficheCartesPanel extends JPanel implements ConstantesCouleursFontes{
	private JPanel lesCartes =new JPanel();
	private JLabel titre=new JLabel("Cliquez sur une carte pour afficher ses attributs !");
	private ArrayList<BoutonCarte> btnCartes;

	public AfficheCartesPanel(JeuCartesTarot jeu) {
		lesCartes.setBackground(VIOLET);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		titre.setFont(FONT_14);
		this.add(titre);
		btnCartes=new ArrayList<BoutonCarte>();
		for(int i=0;i<jeu.getCartes().size();i++) {
			btnCartes.add(  new BoutonCarte(jeu.getCarte(i)));
			lesCartes.add(btnCartes.get(i));
		}	
		JScrollPane scrollPane = new JScrollPane(lesCartes);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);	 
		scrollPane.setPreferredSize(new Dimension(1000, 300));       
		this.add(scrollPane);
		this.setBackground(VIOLET);
	}
	/**
	 * permet au controleur d'etre à l'ecoute de tout les boutons
	 * @param controleur qui gere les evenements
	 */
	public void enregistreEcouteur(Controleur controleur) {
		for(int i=0;i<btnCartes.size();i++) {
			btnCartes.get(i).addActionListener(controleur);
		}
	}
}
