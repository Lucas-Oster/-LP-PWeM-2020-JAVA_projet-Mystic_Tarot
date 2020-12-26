package model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe de gestion de sauvegarde du paquet par serialisation
 * @author lucas Oster
 * @version 1.0
 */
public class LectureEcritureSerial {
	/**
	 * permet de crée un fichier .serial et de stocker un objet
	 * @param nomFichier à ercire 
	 * @param parObjet à sauvergarder
	 */
	public static void ecriture(String nomFichier, Object parObjet) {
		ObjectOutputStream oos =null;
		try {
			// ouverture d'un flux de sortie vers le fichier "personne.serial"
			FileOutputStream fos = new FileOutputStream(nomFichier);

			// création d'un "flux objet" avec le flux fichier
			oos= new ObjectOutputStream(fos);
			try {
				// sérialisation : écriture de l'objet dans le flux de sortie
				oos.writeObject(parObjet); 
				// on vide le tampon
				oos.flush();
				System.out.println(" on a serialise : " +parObjet );
			} finally {
				//fermeture des flux
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}

	}
	/**
	 * permet de lire un fichier .serial
	 * @param nomFichier le nom du fichier à lire
	 * @return l'objec lu
	 */
	public static Object lecture(String nomFichier) {
		ObjectInputStream flux;
		Object objetLu=null;
		try {
			flux =new ObjectInputStream(new FileInputStream (nomFichier));
			objetLu = (Object)flux.readObject();
			flux.close();
		}
		catch (ClassNotFoundException parException) {
			System.err.println(parException.toString());
			System.exit(1);
		}
		catch (IOException parException) {
			System.err.println("Erreur de lecture de fichier "+ parException.toString());
		}
		return objetLu;
	}
}
