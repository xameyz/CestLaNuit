package Maven.Maven;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Hashtable;

import javax.swing.JPanel;

public class ListeIm extends JPanel {

	public Hashtable<Float, Img> list;

	private Image image = null;

	public ListeIm() {

		this.list = new Hashtable<Float, Img>();

	}

	public ListeIm(Image image) {
		// à modifier pour la hashtable car juste pour un test avec une image
		this.image = image;

	}

	public ListeIm(String file) {
		// à modifier pour la hashtable car juste pour un test avec une image
		this.image = getToolkit().getImage(file);

	}

	protected void paintComponent(Graphics g) {

		int x = 5;
		int y = 5;
		int width = 0;
		int height = 0;

		width = this.getWidth();
		height = this.getHeight();
		/*
		 * for(int i=0;i<=this.list.lenght;i++){
		 * g.drawImage(this.list.list.put(key, value), x, y, width/9, height/9,
		 * this); Graphics2D g2 = (Graphics2D)g ; g2.drawImage(this.list.get(i),
		 * x, y, width/9, height/9, null); }
		 */
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(this.image, x, y, width , height, this);
		// g.drawImage(this.image, x, y, width*9, height*9, this);
		

	}
}