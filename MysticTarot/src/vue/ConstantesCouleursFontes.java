package vue;
import java.awt.Color;
import java.awt.Font;
/**
 * Classe de gestion des fontes des caracteres
 * @author lucas Oster
 * @version 1.0
 */
public interface ConstantesCouleursFontes {
	final Color MASTIC = new Color (179, 177, 145);
	final Color VANILLE = new Color (225, 206, 154);
	final Color ROUGE = new Color (150,15,15);
	final Color VERT = new Color (150,150,15);
	final Color BLEU = new Color (126, 187, 228);
	final Color ORANGE = new Color (255,198,170);
	final Color VIOLET = new Color (175,135,240);

	final Font FONT_18 = new Font ("Verdana", Font.BOLD,18);
	final Font FONT_14 = new Font ("Verdana", Font.BOLD,14);
	final Font FONT_12 = new Font ("Verdana", Font.BOLD,12);
	final Font FONT_11 = new Font ("Verdana", Font.BOLD,11);
}