package Maven.Maven;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class ImgManager extends JPanel {
	public Hashtable<Integer, Img> imgHashtable;

	public static void main(String[] args) {
		File f = new File("Donnees\\image.png");
		System.out.println(f.getAbsolutePath());
	}

	public ImgManager() {
		this.imgHashtable = new Hashtable<Integer, Img>();
		File dossier;
		try {
			dossier = new File("Donnees").getCanonicalFile();
			String[] liste = dossier.list();
			for (int i = 0; i < liste.length; i++) {
				if (liste[i].endsWith(".jpg") || liste[i].endsWith(".gif") || liste[i].endsWith(".png")
						|| liste[i].endsWith(".bnp") || liste[i].endsWith(".tif")) {
					File f = new File("Donnees\\" + liste[i]).getCanonicalFile();
					float lon = ImageExtract.getLatitude(f);
					float lat = ImageExtract.getLongitude(f);
					Img im = new Img(f, lon, lat);
					int code = im.hashCode();
					this.imgHashtable.put(code, im);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ImgManager(Image image) {
		// à modifier pour la hashtable car juste pour un test avec une image
		//this.image = image;

	}

	public ImgManager(String file) {
		// à modifier pour la hashtable car juste pour un test avec une image
		//this.image = getToolkit().getImage(file);
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
		//g2.drawImage(this.image, x, y, width / 2, height / 2, this);
		// g.drawImage(this.image, x, y, width*9, height*9, this);
	}
}
