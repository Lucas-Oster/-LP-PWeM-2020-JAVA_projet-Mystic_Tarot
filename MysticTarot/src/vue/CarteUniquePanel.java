package vue;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controleur.Controleur;
import model.Carte;
/**
 * Classe d'affichage d'une carte selectionnee, 
 * permet de la supprimer et de la modifier
 * @author lucas Oster
 * @version 1.0
 */
public class CarteUniquePanel extends JPanel implements ConstantesCouleursFontes{
	Carte carte;
	JTextArea nomCarteTxt;
	JTextArea descriCarteDes;
	ImageIcon image;
	JLabel label;
	JLabel nom;
	JLabel description;
	JLabel imageUnique;
	JButton enregistreCarte;
	JButton supprCarte;
	JLabel labelCarteUnique;
	JLabel labelCarteNonTrouvee;

	public CarteUniquePanel(Carte carte) {
		this.carte=carte;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		labelCarteUnique=new JLabel("Dans cette espace vous pouvez modifier une carte ou la suprimmer :");
		labelCarteUnique.setFont(FONT_14);
		labelCarteNonTrouvee=new JLabel("La carte n'a pas été trouvée");
		labelCarteUnique.setFont(FONT_18);

		nom=new JLabel("Nom de la carte:");
		description=new JLabel("Description de la carte:");
		imageUnique=new JLabel("Image de la carte:");
		nomCarteTxt = new JTextArea(carte.getNom());
		descriCarteDes = new JTextArea(carte.getDescription());
		nomCarteTxt.setPreferredSize(new Dimension(10, 20));
		descriCarteDes.setPreferredSize(new Dimension(10, 40));

		enregistreCarte= new JButton("Enregistrer les modifications");
		supprCarte = new JButton("Supprimer");

		image =carte.getImageCarte();
		label = new JLabel(image, JLabel.CENTER);
		this.init();
	}

	/**
	 * permet de rafraichir l'affichage apres le choix d'une nouvelle carte à afficher
	 * @param carte la carte à afficher
	 */
	public void setCarte(Carte carte) {
		this.carte = carte;
		this.removeAll();
		if(carte!=null) {
			nomCarteTxt = new JTextArea(carte.getNom());
			descriCarteDes = new JTextArea(carte.getDescription());
			image =carte.getImageCarte();
			label = new JLabel(image, JLabel.CENTER);
			this.init();
		}else {
			this.add(labelCarteNonTrouvee);
		}

		this.updateUI();

	}
	/**
	 * méthode utilitaire utilisee dans le constructeur et dans setCarte()
	 */
	private void init() {
		this.add(labelCarteUnique);
		this.add(enregistreCarte);
		this.add(supprCarte);
		this.add(nom);
		this.add(nomCarteTxt);
		this.add(description);
		this.add(descriCarteDes);
		this.add(imageUnique);
		this.add(label);
		this.setBackground(ORANGE);
	}
	/**
	 * permet au controleur d'etre à l'ecoute des boutons
	 * @param controleur qui gere les evenements
	 */
	public void enregistreEcouteur(Controleur controleur) {
		enregistreCarte.addActionListener(controleur);
		supprCarte.addActionListener(controleur);
	}
	public Carte getCarte() {
		return carte;
	}
	public JTextArea getNomCarteTxt() {
		return nomCarteTxt;
	}
	public JTextArea getDescriCarteDes() {
		return descriCarteDes;
	}
}
