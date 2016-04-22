package gui.kontrolor;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import baza.Kategorije;
import gui.GlavniProzor;
import gui.Pobeda;
import gui.PocetniProzor;
import gui.Poraz;

public class GUIKontrolor {

	public static String trazenaRec = "";
	public static int brojPromasaja = 0;
	public static LinkedList<Character> koriscenaSlova = new LinkedList<>();
	public static int brojKoriscenihSlova = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocetniProzor frame = new PocetniProzor();
					frame.setVisible(true);
					Poraz p = new Poraz();
					p.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziGlavniProzor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziPobedu() {
		try {
			Pobeda dialog = new Pobeda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void prikaziPoraz() {
		try {
			Poraz dialog = new Poraz();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String vratiString(String kategorija) {
		Kategorije k = new Kategorije();
		Random r = new Random();
		int randomBroj = r.nextInt(20);
		String recZaPrikaz = "";

		if (kategorija.equalsIgnoreCase("movies")) {
			trazenaRec = k.getFilmovi()[randomBroj];
		}
		if (kategorija.equalsIgnoreCase("classical books")) {
			trazenaRec = k.getKnjige()[randomBroj];
		}
		if (kategorija.equalsIgnoreCase("countries")) {
			trazenaRec = k.getDrzave()[randomBroj];
		}
		if (kategorija.equalsIgnoreCase("hystoric people")) {
			trazenaRec = k.getIstorijskeLicnosti()[randomBroj];
		}
		if (kategorija.equalsIgnoreCase("famous people")) {
			trazenaRec = k.getPoznateLicnosti()[randomBroj];
		}
		if (kategorija.equalsIgnoreCase("famous brands")) {
			trazenaRec = k.getBrendovi()[randomBroj];
		}
		for (int i = 0; i < trazenaRec.length(); i++) {
			if (trazenaRec.charAt(i) != ' ')
				recZaPrikaz += '*';
			else
				recZaPrikaz += ' ';
		}
		return recZaPrikaz;
	}

	public static char[] dodajSlovo(char slovo) {
		if (trazenaRec != null) {
			char[] recZaPrikazNiz = new char[trazenaRec.length()];
			for (int i = 0; i < recZaPrikazNiz.length; i++) {
				for (int j = 0; j < koriscenaSlova.size(); j++) {
					if (trazenaRec.charAt(i) == koriscenaSlova.get(j)) {
						recZaPrikazNiz[i] = koriscenaSlova.get(j);
					} else {
						recZaPrikazNiz[i] = '*';
					}
				}
			}
			boolean postoji = false;
			for (int i = 0; i < trazenaRec.length(); i++) {
				if (trazenaRec.charAt(i) == slovo) {
					recZaPrikazNiz[i] = slovo;
					postoji = true;
				}
			}
			koriscenaSlova.add(slovo);
			if (!postoji && brojPromasaja<6) {
				brojPromasaja += 1;
			}

			return recZaPrikazNiz;
		} else {
			throw new RuntimeException("");
		}
	}

	public static void koriscenaSlova(char slovo) {
		koriscenaSlova.add(slovo);
	}

}
