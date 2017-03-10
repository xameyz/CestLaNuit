package Maven.Maven;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.ArrayList;

public class Img {
	File file;
	float Lattitude;
	float Longitude;
	ArrayList<String> commentaire;
	String nom;

	public Img(File f, float la, float lon) {
		this.file = f;
		this.Lattitude = la;
		this.Longitude = lon;
		this.commentaire = new ArrayList<String>();
		this.nom = f.getName();
	}

	public void addComm(String com) throws EmptyStringException {
		if (com == "") {
			throw new EmptyStringException();
		} else {
			this.commentaire.add(com);
		}
	}
	
	public void printImg(Img im){
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(new Printable(){
	        	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
	                	if (pageIndex != 0) {
	                		return NO_SUCH_PAGE;
	                	}
	                	graphics.drawImage(im.file, 0, 0, im.file.getWidth(), im.file.getHeight(), null);
	                	return PAGE_EXISTS;
	        	}
		});     
		try {
			printJob.print();
		} catch (PrinterException e) {             
			e.printStackTrace();
		}
	}
}
