package model;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Classe de gestion d'un paquet de cartes
 * @author lucas Oster
 * @version 1.0
 */
public class JeuCartesTarot implements Serializable {
	static private final long serialVersionUID = 6L;
	private ArrayList<Carte> cartes=new ArrayList<Carte>();

	/**
	 * permet d'ajouter une carte au jeu
	 * @param carte la carte à ajouter
	 */
	public void add(Carte carte) {
		cartes.add(carte);
	}
	/**
	 * recherche une carte avec son numero
	 * @param i numero de la carte à chercher (i=0,1,2,3...)
	 * @return carte la carte correpondante au numero
	 * ou null si la carte n'est pas trouvée
	 */
	public Carte getCarte(int i) {
		Carte carte=null;
		if(i<cartes.size()) {
			return cartes.get(i);
		}
		return carte;
	}
	/**
	 * recherche une carte avec son nom
	 * @param nom nom de la carte à chercher
	 * @return carte la carte correpondante au nom ou null si la carte n'est pas trouvée
	 */
	public Carte getCarte(String nom) {
		Carte carte=null;
		for(int i=0;i<cartes.size();i++) {
			if (nom.equalsIgnoreCase(cartes.get(i).getNom())) {
				return cartes.get(i);
			}
		}
		return carte;
	}
	@Override
	/**
	 * Transforme le jeu en une chaine de caracteres,
	 * utilisee pour les tests.
	 */
	public String toString() {
		return "JeuCartesTarot [cartes=" + cartes + "]";
	}

	/**
	 * supprime une carte
	 * @param carte la carte à supprimer
	 */
	public void suppr(Carte carte) {	
		cartes.remove(carte);	 
	}
	/**
	 * retourne la ArrayList de Carte
	 * @return cartes 
	 */
	public ArrayList<Carte> getCartes() {
		return cartes;
	}
	/**
	 * utilisée en phase de développement,
	 * elle a servi à tester le model,
	 * à regenerer rapidement neuf cartes
	 * et à les enregistrer grace à la serialisation
	 */
	public static void generationDeNeufCartes() {
		//test questions 2, 3, 4
		Carte a =new Carte("Bateleur");
		Carte b =new Carte("Papesse");
		Carte c = new Carte("Imperatrice");
		Carte d = new Carte("Empereur");
		Carte e =new Carte("Pape");
		Carte f = new Carte("Amoureux");
		Carte g = new Carte("Chariot");
		Carte h = new Carte("Justice");
		Carte i = new Carte("Ermite");
		a.setDescription("Le Bateleur est la première carte du tarot de Marseille.");
		b.setDescription("La Papesse est la deuxième carte du tarot de Marseille.");
		c.setDescription("L'Impératrice est la troisième carte du tarot de Marseille.");
		d.setDescription("L'Empereur est la quatrieme carte du tarot de Marseille.");
		e.setDescription("Le Pape est la cinquieme carte du tarot de Marseille.");
		f.setDescription("L'amoureux est la sixieme carte du tarot de Marseille.");
		g.setDescription("le Chariot est la septieme carte du tarot de Marseille.");
		h.setDescription("La Justice est la huitieme carte du tarot de Marseille.");
		i.setDescription("L'Ermite est la neuvieme carte du tarot de Marseille.");
		a.setImageCarte(new ImageIcon("image"+File.separator+"1.jpg"));
		b.setImageCarte(new ImageIcon("image"+File.separator+"2.jpg"));
		c.setImageCarte(new ImageIcon("image"+File.separator+"3.jpg"));
		d.setImageCarte(new ImageIcon("image"+File.separator+"4.jpg"));
		e.setImageCarte(new ImageIcon("image"+File.separator+"5.jpg"));
		f.setImageCarte(new ImageIcon("image"+File.separator+"6.jpg"));
		g.setImageCarte(new ImageIcon("image"+File.separator+"7.jpg"));
		h.setImageCarte(new ImageIcon("image"+File.separator+"8.jpg"));
		i.setImageCarte(new ImageIcon("image"+File.separator+"9.jpg"));
		JeuCartesTarot jeu =new JeuCartesTarot();
		//test ajout de carte
		jeu.add(a);
		jeu.add(b);
		jeu.add(c);
		jeu.add(d);
		jeu.add(e);
		jeu.add(f);
		jeu.add(g);
		jeu.add(h);
		jeu.add(i);
		System.out.println("le jeu : "+ jeu);
		LectureEcritureSerial.ecriture("testEcriture.serial", jeu);
	}

}



