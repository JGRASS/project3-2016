package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import baza.Slova;
import gui.kontrolor.GUIKontrolor;
import gui.kontrolor.tabele.TabelaZaRec;

public class GlavniProzor extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelZaRec;
	private JPanel panelZaDugmice;
	private JLabel lblKategorija;
	private JComboBox<String> comboBoxKategorije;
	private JLabel lblIzaberiSlovo;
	private JComboBox<Character> comboBoxSlova;
	private JLabel lblTryTheWhole;
	private JTextField textField;
	private JLabel lblPrazanProstor1;
	private JLabel lblPrazanProstor2;
	private JLabel lblPrazanProstor3;
	private JButton btnExitGame;
	private JLabel jlblPrazanProstor4;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnTry;
	private JPanel panelZaSliku;
	private JLabel jlblSlika1;
	private JButton btnGiveUp;
	private JPanel jpnlIgrac;
	private JLabel jlblPlayer;
	private JLabel jlblImeIgraca;
	private JButton btnOk;
	private ImageIcon image1;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;
	private ImageIcon image7;
	private ImageIcon image6;
	private JButton btnBegin;
	private String [] kategorije;

	public GlavniProzor(String [] kategorije) throws IOException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontrolor.ugasiAplikaciju();
			}

		});
		this.kategorije = kategorije;
		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/resursi/ghosticon.png")));
		setResizable(false);
		setPreferredSize(new Dimension(1000, 2000));
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 509, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelZaRec(), BorderLayout.SOUTH);
		contentPane.add(getPanelZaDugmice(), BorderLayout.EAST);
		contentPane.add(getPanelZaSliku(), BorderLayout.CENTER);
		contentPane.add(getJpnlIgrac(), BorderLayout.NORTH);
		image1 = new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala1.jpg"));
		image2 = new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala2.jpg"));
		image3 = new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala3.jpg"));
		image4 = new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala4.jpg"));
		image5 = new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala5.jpg"));
		image6 = new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala6.jpg"));
		image7 = new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala7.jpg"));
	}

	private JPanel getPanelZaRec() {
		if (panelZaRec == null) {
			panelZaRec = new JPanel();
			panelZaRec.setPreferredSize(new Dimension(10, 50));
			panelZaRec.add(getScrollPane());

		}
		return panelZaRec;
	}

	private JPanel getPanelZaDugmice() {
		if (panelZaDugmice == null) {
			panelZaDugmice = new JPanel();
			panelZaDugmice.setPreferredSize(new Dimension(200, 10));
			panelZaDugmice.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelZaDugmice.add(getLblPrazanProstor1());
			panelZaDugmice.add(getLblKategorija());
			panelZaDugmice.add(getComboBoxKategorije());
			panelZaDugmice.add(getLblPrazanProstor2());
			panelZaDugmice.add(getLblIzaberiSlovo());
			panelZaDugmice.add(getComboBoxSlova());
			panelZaDugmice.add(getBtnOk());
			panelZaDugmice.add(getLabel_1());
			panelZaDugmice.add(getLblTryTheWhole());
			panelZaDugmice.add(getTextField());
			panelZaDugmice.add(getBtnTry());
			panelZaDugmice.add(getLabel_2());
			panelZaDugmice.add(getBtnBegin());
			panelZaDugmice.add(getBtnExitGame());
			panelZaDugmice.add(getBtnGiveUp());
		}
		return panelZaDugmice;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setForeground(Color.BLUE);
			table.setFont(new Font("Tahoma", Font.BOLD, 16));
			table.setPreferredSize(new Dimension(480, 18));
			table.setFillsViewportHeight(true);
			table.setShowHorizontalLines(false);
			table.setRowSelectionAllowed(false);
			table.setModel(new TabelaZaRec("Default word".toCharArray()));
			table.setTableHeader(null);
		}
		return table;
	}

	private JLabel getLblKategorija() {
		if (lblKategorija == null) {
			lblKategorija = new JLabel("Category:");
			lblKategorija.setHorizontalAlignment(SwingConstants.CENTER);
			lblKategorija.setPreferredSize(new Dimension(70, 25));
		}
		return lblKategorija;
	}

	private JComboBox<String> getComboBoxKategorije() {
		if (comboBoxKategorije == null) {
			comboBoxKategorije = new JComboBox<String>();
			comboBoxKategorije.setPreferredSize(new Dimension(100, 25));
			comboBoxKategorije.setModel(new DefaultComboBoxModel<>(kategorije));
		}

		return comboBoxKategorije;
	}

	private JLabel getLblIzaberiSlovo() {
		if (lblIzaberiSlovo == null) {
			lblIzaberiSlovo = new JLabel("Pick a letter:");
			lblIzaberiSlovo.setHorizontalAlignment(SwingConstants.CENTER);
			lblIzaberiSlovo.setPreferredSize(new Dimension(180, 25));
		}
		return lblIzaberiSlovo;
	}

	private JComboBox<Character> getComboBoxSlova() {
		if (comboBoxSlova == null) {
			comboBoxSlova = new JComboBox<Character>();
			comboBoxSlova.setPreferredSize(new Dimension(40, 25));
			comboBoxSlova.setModel(new DefaultComboBoxModel<>(Slova.getSlova()));	
		}
		return comboBoxSlova;
	}

	private JLabel getLblTryTheWhole() {
		if (lblTryTheWhole == null) {
			lblTryTheWhole = new JLabel("Try the whole word:");
			lblTryTheWhole.setHorizontalAlignment(SwingConstants.CENTER);
			lblTryTheWhole.setPreferredSize(new Dimension(170, 25));
		}
		return lblTryTheWhole;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setPreferredSize(new Dimension(190, 25));
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblPrazanProstor1() {
		if (lblPrazanProstor1 == null) {
			lblPrazanProstor1 = new JLabel("");
			lblPrazanProstor1.setPreferredSize(new Dimension(200, 50));
		}
		return lblPrazanProstor1;
	}

	private JLabel getLblPrazanProstor2() {
		if (lblPrazanProstor2 == null) {
			lblPrazanProstor2 = new JLabel("");
			lblPrazanProstor2.setPreferredSize(new Dimension(170, 25));
		}
		return lblPrazanProstor2;
	}

	private JLabel getLabel_1() {
		if (lblPrazanProstor3 == null) {
			lblPrazanProstor3 = new JLabel("");
			lblPrazanProstor3.setPreferredSize(new Dimension(170, 25));
		}
		return lblPrazanProstor3;
	}

	private JButton getBtnExitGame() {
		if (btnExitGame == null) {
			btnExitGame = new JButton("Exit game");
			btnExitGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontrolor.ugasiAplikaciju();
				}
			});
			btnExitGame.setPreferredSize(new Dimension(100, 25));
		}
		return btnExitGame;
	}

	private JLabel getLabel_2() {
		if (jlblPrazanProstor4 == null) {
			jlblPrazanProstor4 = new JLabel("");
			jlblPrazanProstor4.setPreferredSize(new Dimension(170, 70));
		}
		return jlblPrazanProstor4;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(480, 21));
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JButton getBtnTry() {
		if (btnTry == null) {
			btnTry = new JButton("Try!");
			btnTry.setEnabled(false);
			btnTry.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBoxKategorije.setEnabled(false);
					if(!GUIKontrolor.probajOdjednom(textField.getText().toString().trim())) promeniSliku();
				}	
			});
			btnTry.setPreferredSize(new Dimension(100, 25));
		}
		return btnTry;
	}

	private JLabel getJlblSlika1() {
		if (jlblSlika1 == null) {
			jlblSlika1 = new JLabel("");
			jlblSlika1.setIcon(new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala1.jpg")));

		}
		return jlblSlika1;
	}

	private void promeniSliku() {

		switch (GUIKontrolor.vratiBrojPromasaja()) {

		case 0:
			jlblSlika1.setIcon(image1);
			break;
		case 1:
			jlblSlika1.setIcon(image2);
			break;
		case 2:
			jlblSlika1.setIcon(image3);
			break;
		case 3:
			jlblSlika1.setIcon(image4);
			break;
		case 4:
			jlblSlika1.setIcon(image5);
			break;
		case 5:
			jlblSlika1.setIcon(image6);
			break;
		case 6:
			jlblSlika1.setIcon(image7);
			break;
		}
	}

	private JPanel getPanelZaSliku() {
		if (panelZaSliku == null) {
			panelZaSliku = new JPanel();
			panelZaSliku.add(getJlblSlika1());
		}
		return panelZaSliku;
	}

	private JButton getBtnGiveUp() {
		if (btnGiveUp == null) {
			btnGiveUp = new JButton("Give up");
			btnGiveUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontrolor.odustani();
				}
			});
			btnGiveUp.setPreferredSize(new Dimension(100, 25));
		}
		return btnGiveUp;
	}

	private JPanel getJpnlIgrac() {
		if (jpnlIgrac == null) {
			jpnlIgrac = new JPanel();
			jpnlIgrac.setPreferredSize(new Dimension(10, 40));
			jpnlIgrac.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			jpnlIgrac.add(getJlblPlayer());
			jpnlIgrac.add(getJlblImeIgraca());
		}
		return jpnlIgrac;
	}

	private JLabel getJlblPlayer() {
		if (jlblPlayer == null) {
			jlblPlayer = new JLabel("Player:");
			jlblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return jlblPlayer;
	}

	private JLabel getJlblImeIgraca() {
		if (jlblImeIgraca == null) {
			jlblImeIgraca = new JLabel(GUIKontrolor.vratiTrenutnogIgraca().getIme());
			jlblImeIgraca.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jlblImeIgraca.setForeground(Color.RED);
		}
		return jlblImeIgraca;
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.setPreferredSize(new Dimension(70, 25));
			btnOk.setEnabled(false);
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					comboBoxKategorije.setEnabled(false);
					char slovo = comboBoxSlova.getSelectedItem().toString().trim().charAt(0);
					comboBoxSlova.removeItemAt(comboBoxSlova.getSelectedIndex());
					comboBoxSlova.revalidate();
					char [] recZaPrikazNiz;
					if((recZaPrikazNiz = GUIKontrolor.ubaciSlovo(slovo)).length > 0){
						table.setModel(new TabelaZaRec(recZaPrikazNiz));
					}else promeniSliku();
					GUIKontrolor.probajCeluRec();
				}
			});
		}
		return btnOk;
	}
	private JButton getBtnBegin() {
		if (btnBegin == null) {
			btnBegin = new JButton("Begin");
			btnBegin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					char [] recZaPrikazNiz = GUIKontrolor.pokreniPartiju(comboBoxKategorije.getSelectedItem().toString());
					if (recZaPrikazNiz.length > 1){
						table.setModel(new TabelaZaRec(recZaPrikazNiz));
						table.setTableHeader(null);
						comboBoxKategorije.setEnabled(false);
						btnOk.setEnabled(true);
						btnTry.setEnabled(true);
					}else JOptionPane.showMessageDialog(getContentPane(), "");
				}
			});
			btnBegin.setPreferredSize(new Dimension(100, 25));
		}
		return btnBegin;
	}
}
