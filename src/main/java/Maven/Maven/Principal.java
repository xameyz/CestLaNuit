package Maven.Maven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.SwingUtilities;

public class Principal {

	public static void main(String[] args) {
		// map
		Map current_map = new Map();

		// Panel de du bas avec des boutons
		JPanel panelDown = new JPanel();
		JButton buttonAdd = new JButton("Ajouter Image");// ajouter listner

		JButton buttonExit = new JButton("Quitter");// ajouter listner pour
													// quitter
		panelDown.setLayout(new FlowLayout());
		panelDown.setBackground(Color.blue);
		panelDown.setPreferredSize(new Dimension(800, 50));
		panelDown.add(buttonExit);
		panelDown.add(buttonAdd);

		// panelde gauche
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new FlowLayout());
		panelLeft.setBackground(Color.lightGray);
		panelLeft.setPreferredSize(new Dimension(200, 300));
		panelLeft.add(new ListeIm("space.jpg"));

		// panelde gauche
		JPanel panel_R = new JPanel();
		panel_R.setLayout(new FlowLayout());
		panel_R.setBackground(Color.lightGray);
		panel_R.setPreferredSize(new Dimension(200, 300));
		JPanel a = new ListeIm("space.jpg");

		// problème d'affichage des images

		// frame
		final JFrame frame = new JFrame();

		frame.add(current_map.getMap());
		frame.add(panelLeft, BorderLayout.WEST);
		frame.add(panel_R, BorderLayout.EAST);

		frame.add(panelDown, BorderLayout.SOUTH);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setVisible(true);
			}
		});
	}

}