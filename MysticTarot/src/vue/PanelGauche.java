package vue;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controleur.Controleur;
/**
 * Classe d'affichage de la partie gauche de la fenetre (Menu, Recherches, creation)
 * @author lucas Oster
 * @version 1.0
 */
public class PanelGauche extends JPanel implements ConstantesCouleursFontes{
	// pour le JMenu
	JMenu menuFichier;
	JMenuItem sauvegarde;
	JMenuItem quitter;
	// pour la recherche
	JTextField nomRecherche;
	JTextField numRecherche;
	JButton btnRechercheNom;
	JLabel LabelRechNom;
	JLabel LabelRechNum;
	JButton btnRechercheNum;
	// pour la nouvelle carte
	JTextField titreCarte;
	JTextArea DescriCarte;
	JButton btnOpenImg;
	JButton btnValidation;
	ImageIcon imageNewCarte;

	public PanelGauche(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//création de la barre des menus
		JMenuBar myMenuBar=new JMenuBar();
		//Positionnement de la barre des menus avec la methode setBounds()
		myMenuBar.setBounds(0, 0, 500, 30);
		//Création du menu Fichier
		menuFichier = new JMenu("Fichier");
		sauvegarde=new JMenuItem("Sauvegarder le jeu");
		quitter = new JMenuItem("Quitter");
		menuFichier.add(sauvegarde);
		menuFichier.add(quitter);
		//Ajout du menu à la barre des menus
		myMenuBar.add(menuFichier);

		// recherche d une carte
		JLabel recherche = new JLabel("rechercher une carte");
		recherche.setFont(FONT_14);
		LabelRechNom= new JLabel("Tapez le nom de la carte à chercher :");
		nomRecherche=new JTextField("RechercheNom");
		btnRechercheNom=new JButton("rechercher par nom");
		LabelRechNum= new JLabel("Tapez le numero de la carte à chercher (1, 2, ...) :");
		numRecherche=new JTextField("RechercheNum");
		btnRechercheNum=new JButton("rechercher par numero");

		// ajout d une nouvelle carte
		JLabel ajouter = new JLabel("Ajouter une carte");
		ajouter.setFont(FONT_14);
		JLabel ajNomCarte= new JLabel("Nom de la carte à ajouter");
		titreCarte = new JTextField("nom");
		JLabel ajDescriCarte= new JLabel("Description de la carte à ajouter");
		DescriCarte = new JTextArea("Description");
		JLabel ajimgCarte= new JLabel("Image de la carte à ajouter");
		btnOpenImg = new JButton("Ouvrir une image");
		btnValidation = new JButton("valider");

		this.setBackground(BLEU);
		// tous les ajouts au JPanel
		this.add(myMenuBar);
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(recherche);
		this.add(LabelRechNom);
		this.add(nomRecherche);
		this.add(btnRechercheNom);
		this.add(LabelRechNum);
		this.add(numRecherche);
		this.add(btnRechercheNum);
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(ajouter);
		this.add(ajNomCarte);
		this.add(titreCarte);
		this.add(ajDescriCarte);
		this.add(DescriCarte);
		this.add(ajimgCarte);
		this.add(btnOpenImg);
		this.add(btnValidation);
	}
	public JTextField getNomRecherche() {
		return nomRecherche;
	}
	public void setNomRecherche(JTextField nomRecherche) {
		this.nomRecherche = nomRecherche;
	}
	public JTextField getNumRecherche() {

		return numRecherche;
	}
	public void setNumRecherche(JTextField numRecherche) {
		this.numRecherche = numRecherche;

	}
	public JButton getBtnRechercheNom() {
		return btnRechercheNom;
	}
	public void setBtnRechercheNom(JButton btnRechercheNom) {
		this.btnRechercheNom = btnRechercheNom;
	}
	public JLabel getLabelRechNom() {
		return LabelRechNom;
	}
	public void setLabelRechNom(JLabel labelRechNom) {
		LabelRechNom = labelRechNom;
	}
	public JLabel getLabelRechNum() {
		return LabelRechNum;
	}
	public void setLabelRechNum(JLabel labelRechNum) {
		LabelRechNum = labelRechNum;
	}
	public JButton getBtnRechercheNum() {
		return btnRechercheNum;
	}
	public void setBtnRechercheNum(JButton btnRechercheNum) {
		this.btnRechercheNum = btnRechercheNum;
	}
	public JTextField getTitreCarte() {
		return titreCarte;
	}
	public JTextArea getDescriCarte() {
		return DescriCarte;
	}
	public ImageIcon getImageNewCarte() {
		return imageNewCarte;
	}
	public void setImageNewCarte(ImageIcon imageNewCarte) {
		this.imageNewCarte = imageNewCarte;
	}
	public JButton getBtnValidation() {
		return btnValidation;
	}
	public void setBtnValidation(JButton btnValidation) {
		this.btnValidation = btnValidation;
	}
	/**
	 * permet au controleur d'etre à l'ecoute des boutons
	 * @param controleur qui gere les evenements
	 */
	public void enregistreEcouteur(Controleur controleur) {
		quitter.addActionListener(controleur);
		sauvegarde.addActionListener(controleur);
		btnRechercheNom.addActionListener(controleur);
		btnRechercheNum.addActionListener(controleur);
		btnOpenImg.addActionListener(controleur);
		btnValidation.addActionListener(controleur);

	}
}