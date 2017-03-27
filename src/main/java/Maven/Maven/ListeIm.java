package Maven.Maven;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ListeIm {
	public Hashtable<Integer, Img> list;
	
	public static void main(String[] args) {
		File f = new File("Donnees\\image.png");
		System.out.println(f.getAbsolutePath());
	}
	public ListeIm() {
		this.list = new Hashtable<Integer, Img>();
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
					this.list.put(code, im);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}