package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Carte;
import model.JeuCartesTarot;
import model.LectureEcritureSerial;
import vue.AfficheCartesPanel;
import vue.BoutonCarte;
import vue.CarteUniquePanel;
import vue.FenetreTarot;
import vue.PanelGauche;

/**
 * Classe de gestion des evenements de l'application 
 * Cette classe connait le jeu, la fenetre principale et tous les panneaux utiles
 * @author lucas Oster
 * @version 1.0
 */
public class Controleur implements ActionListener{
	private JeuCartesTarot jeu;
	private AfficheCartesPanel afficheCartesPane;
	private CarteUniquePanel carteUniquePane;
	private FenetreTarot tarot;
	private PanelGauche panelGauche;

	public Controleur(JeuCartesTarot jeu, AfficheCartesPanel afficheCartesPane, CarteUniquePanel carteUniquePane,
			FenetreTarot tarot, PanelGauche panelGauche) {
		super();
		this.jeu = jeu;
		this.afficheCartesPane = afficheCartesPane;
		this.carteUniquePane = carteUniquePane;
		this.tarot = tarot;
		this.panelGauche = panelGauche;
		afficheCartesPane.enregistreEcouteur(this);
		panelGauche.enregistreEcouteur(this);
		carteUniquePane.enregistreEcouteur(this);

	}
	/**
	 * gere les evenements comme 
	 *  -les recherches
	 *  -les suppressions
	 *  -les modifications,
	 *  -les creations de cartes
	 *  -aficher les attributs d'une carte selectionner
	 *  -ouvrir une photo pour la creation de carte
	 *  -les actions du menu (quitter et sauvegarder)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {

		if(evt.getSource() instanceof BoutonCarte) {
			Carte carte =((BoutonCarte) evt.getSource()).getCarte();
			carteUniquePane.setCarte(carte);
		}
		else if(evt.getActionCommand().equals("rechercher par nom")){
			Carte carte = jeu.getCarte(""+panelGauche.getNomRecherche().getText());
			carteUniquePane.setCarte(carte);
			//this.tarot.pack();
			System.out.println("OK "+carte);

		}else if(evt.getActionCommand().equals("rechercher par numero")){
			try {
				int i = Integer.parseInt(panelGauche.getNumRecherche().getText());
				Carte carte = jeu.getCarte(i-1);
				carteUniquePane.setCarte(carte);
				//this.tarot.pack();
				System.out.println("OKnum"+carte);
			}catch(Exception e){
				javax.swing.JOptionPane.showMessageDialog(null,"Recherche impossible : veuillez entrer un nombre"); 

			}
			int i = Integer.parseInt(panelGauche.getNumRecherche().getText());
			Carte carte = jeu.getCarte(i-1);
			carteUniquePane.setCarte(carte);
			//this.tarot.pack();
			System.out.println("OKnum"+carte);

		}else if(evt.getActionCommand().equals("Quitter")) {
			System.out.println("OK dispose");
			System.exit(0);

		}else if(evt.getActionCommand().equals("Sauvegarder le jeu")) {
			System.out.println("ok sauvegarde");
			LectureEcritureSerial.ecriture("testEcriture.serial", jeu);

		}else if(evt.getActionCommand().equals("Supprimer")) {
			Carte carte = carteUniquePane.getCarte();
			jeu.suppr(carte);
			afficheCartesPane = new AfficheCartesPanel(jeu);
			tarot.setAfficheCartesPane(afficheCartesPane);
			tarot.repaintDroite();
			afficheCartesPane.enregistreEcouteur(this);
			System.out.println("suppr ok");

		}else if(evt.getActionCommand().equals("Enregistrer les modifications")) {
			String nouveauNomCarte = carteUniquePane.getNomCarteTxt().getText();
			String nouvelleDescriptionCarte = carteUniquePane.getDescriCarteDes().getText();

			Carte carte = carteUniquePane.getCarte();
			carte.setNom(nouveauNomCarte);
			carte.setDescription(nouvelleDescriptionCarte);


			System.out.println("Modif nom ok"+carteUniquePane.getNomCarteTxt().getText());
			System.out.println("Modif des ok"+carteUniquePane.getDescriCarteDes().getText());
		}else if(evt.getActionCommand().equals("Ouvrir une image")) {
			String[] extensions = new String[] {"png","jpg","bmp","gif","jpeg"};
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file", extensions);                                

			JFileChooser choix = new JFileChooser("image");
			choix.setFileFilter(filter);
			int retour=choix.showOpenDialog(panelGauche);
			if(retour==JFileChooser.APPROVE_OPTION){
				// un fichier a été choisi (sortie par OK)
				// nom du fichier  choisi 
				choix.getSelectedFile().getName();

				// chemin absolu du fichier choisi
				choix.getSelectedFile().getAbsolutePath();
				System.out.println(choix.getSelectedFile().getAbsolutePath());
				ImageIcon imageNewCarte = new ImageIcon(choix.getSelectedFile().getAbsolutePath());
				panelGauche.setImageNewCarte(imageNewCarte);
			}// pas de fichier choisi


			System.out.println("image ok ");
		}else if(evt.getActionCommand().equals("valider")) {
			String nomNewCarte = panelGauche.getTitreCarte().getText();
			String descriNewCarte = panelGauche.getDescriCarte().getText();
			Carte carte=new Carte(nomNewCarte,descriNewCarte,panelGauche.getImageNewCarte());
			jeu.add(carte);
			afficheCartesPane = new AfficheCartesPanel(jeu);
			tarot.setAfficheCartesPane(afficheCartesPane);
			tarot.repaintDroite();
			afficheCartesPane.enregistreEcouteur(this);
			carteUniquePane.setCarte(carte);
			//tarot.pack();
			//tarot.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			System.out.println(carte);
		}

	}

}
