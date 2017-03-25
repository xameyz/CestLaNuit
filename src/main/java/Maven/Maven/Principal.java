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
		JPanel panel_Down = new JPanel();
		JButton buttonAdd = new JButton("Ajouter Image");// ajouter listner

		JButton buttonExit = new JButton("Quitter");// ajouter listner pour
													// quitter
		panel_Down.setLayout(new FlowLayout());
		panel_Down.setBackground(Color.blue);
		panel_Down.setPreferredSize(new Dimension(800, 50));
		panel_Down.add(buttonExit);
		panel_Down.add(buttonAdd);

		// panel de gauche
		JPanel panel_L = new JPanel();
		panel_L.setLayout(new FlowLayout());
		panel_L.setBackground(Color.lightGray);
		panel_L.setPreferredSize(new Dimension(200, 300));
		JPanel panel_img = new ListeIm("space.jpg");
		panel_img.setPreferredSize(new Dimension(150,250));
		panel_L.add(panel_img);
		
		// panel de droite
		JPanel panel_R = new JPanel();
		panel_R.setLayout(new FlowLayout());
		panel_R.setBackground(Color.lightGray);
		panel_R.setPreferredSize(new Dimension(200, 300));
		JPanel panel_img_s = new ListeIm("space.jpg");
		panel_img_s.setPreferredSize(new Dimension(150,250));
		panel_R.add(panel_img_s);

		// problème d'affichage des images

		// frame
		final JFrame frame = new JFrame();

		frame.add(current_map.getMap());
		frame.add(panel_L, BorderLayout.WEST);
		frame.add(panel_R, BorderLayout.EAST);

		frame.add(panel_Down, BorderLayout.SOUTH);
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