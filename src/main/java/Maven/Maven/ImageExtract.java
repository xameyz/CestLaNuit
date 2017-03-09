package Maven.Maven;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JFileChooser;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDescriptor;
import com.drew.metadata.exif.GpsDirectory;


public class ImageExtract {

	public static Img LoadImage(){
		File repertoireCourant = null;
		try {
			repertoireCourant = new File(".").getCanonicalFile();
			System.out.println("Répertoire courant : " + repertoireCourant);
		} catch(IOException e) {}

		JFileChooser dialogue = new JFileChooser(repertoireCourant);

		dialogue.showOpenDialog(null);

		System.out.println("Fichier choisi : " + dialogue.getSelectedFile());
		File f = dialogue.getSelectedFile();
		Img monimage= new Img(f, getLatitude(f), getLongitude(f));
		return monimage;
	}

	public static float getLatitude(File file) {
		String latitude="";
		try{
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			if (metadata.containsDirectoryOfType(GpsDirectory.class)) {
				Collection<GpsDirectory> gpsDirs = metadata.getDirectoriesOfType(GpsDirectory.class);
				for (GpsDirectory gpsDirectory : gpsDirs) {
					GpsDescriptor gpsDesc = new GpsDescriptor(gpsDirectory);
					latitude=latitude+gpsDesc.getGpsLatitudeDescription();
				}
			}
		}
		catch(ImageProcessingException e){
			System.out.println("erreur 1");
		}
		catch(IOException e){
			System.out.println("erreur 2");
		}
		catch( java.lang.ClassCastException e){
			System.out.println("erreur 3");
		}
		//convertion dms to dd:
		String[] tab0 =latitude.split("°");
		tab0[1] = tab0[1].substring(1, tab0[1].length());
		String[] tab1 =tab0[1].split("'");
		tab1[1] = tab1[1].substring(1, tab1[1].length()-1);
		float Degree = Integer.parseInt(tab0[0]);
		float Minute = Integer.parseInt(tab1[0]);
		float Second = Integer.parseInt(tab1[1]);
		float DD= Degree + Minute/60 + Second/3600;
		return DD;
	}

	public static float getLongitude(File file) {
		String longitude="";
		try{
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			if (metadata.containsDirectoryOfType(GpsDirectory.class)) {
				Collection<GpsDirectory> gpsDirs = metadata.getDirectoriesOfType(GpsDirectory.class);
				for (GpsDirectory gpsDirectory : gpsDirs) {
					GpsDescriptor gpsDesc = new GpsDescriptor(gpsDirectory);
					longitude=longitude+gpsDesc.getGpsLongitudeDescription();
				}
			}
		}
		catch(ImageProcessingException e){
			System.out.println("erreur 1");
		}
		catch(IOException e){
			System.out.println("erreur 2");
		}
		catch( java.lang.ClassCastException e){
			System.out.println("erreur 3");
		}
		//convertion dms to dd:
		String[] tab0 =longitude.split("°");
		tab0[1] = tab0[1].substring(1, tab0[1].length());
		String[] tab1 =tab0[1].split("'");
		tab1[1] = tab1[1].substring(1, tab1[1].length()-1);
		float Degree = Integer.parseInt(tab0[0]);
		float Minute = Integer.parseInt(tab1[0]);
		float Second = Integer.parseInt(tab1[1]);
		float DD= Degree + Minute/60 + Second/3600;
		return DD;
	}
}