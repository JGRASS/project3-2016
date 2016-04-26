package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baza.TabelaZaScore;
import gui.kontrolor.GUIKontrolor;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Score extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblPlayer;
	private JLabel jlblImeIgraca;
	private JPanel panel_1;
	private JButton btnOk;
	private JScrollPane scrollPane;
	private JTable jtblScore;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Score() {
		setTitle("Score");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Score.class.getResource("/resursi/ghosticon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 40));
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getLblPlayer());
			panel.add(getJlblImeIgraca());
		}
		return panel;
	}
	private JLabel getLblPlayer() {
		if (lblPlayer == null) {
			lblPlayer = new JLabel("Player:");
			lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblPlayer;
	}
	private JLabel getJlblImeIgraca() {
		if (jlblImeIgraca == null) {
			jlblImeIgraca = new JLabel(GUIKontrolor.igraci.vratiIgraca(GUIKontrolor.indexTrenutnogIgraca).getIme());
			jlblImeIgraca.setForeground(Color.RED);
			jlblImeIgraca.setFont(new Font("Tahoma", Font.BOLD, 18));
			jlblImeIgraca.setBounds(148, 13, 286, 30);
		}
		return jlblImeIgraca;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(10, 40));
			panel_1.add(getBtnOk());
		}
		return panel_1;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOk.setAlignmentX(Component.RIGHT_ALIGNMENT);
			btnOk.setPreferredSize(new Dimension(55, 30));
		}
		return btnOk;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getJtblScore());
		}
		return scrollPane;
	}
	private JTable getJtblScore() {
		if (jtblScore == null) {
			jtblScore = new JTable();
			jtblScore.setRowHeight(30);
			jtblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jtblScore.setFillsViewportHeight(true);
			jtblScore.setModel(new TabelaZaScore(GUIKontrolor.vratiTrenutnogIgraca()));
			
		}
		return jtblScore;
	}
}
