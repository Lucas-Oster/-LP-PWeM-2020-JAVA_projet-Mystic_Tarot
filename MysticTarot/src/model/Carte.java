package model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
/**
 * Classe de gestion d'une carte
 * @author lucas Oster
 * @version 1.0
 */
public class Carte implements Serializable{
	static private final long serialVersionUID = 6L;
	private String nom;
	private String description;
	private ImageIcon imageCarte;

	public Carte(String nom, String description, ImageIcon imageCarte) {
		super();
		this.nom = nom;
		this.description = description;
		this.imageCarte = imageCarte;
	}

	public Carte(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public Carte(String nom) {
		super();
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Carte [nom=" + nom + ", description=" + description + ", imageCarte=" + imageCarte + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ImageIcon getImageCarte() {
		return imageCarte;
	}

	public void setImageCarte(ImageIcon imageCarte) {
		this.imageCarte = imageCarte;
	}

	public String getDescription() {
		return description;
	}

}
