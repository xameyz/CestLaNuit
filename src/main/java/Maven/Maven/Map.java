package Maven.Maven;

import java.awt.Component;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class Map {

	private JXMapKit map;
	private Set<CustomDefaultWaypoint> set_waypoints;
	private CustomPainter painter;
	private ImgManager imgManager;

	public Map() {

		this.imgManager = new ImgManager();
		this.set_waypoints = new HashSet<CustomDefaultWaypoint>();
		
		this.set_waypoints.add(new CustomDefaultWaypoint(51.50, -0.12, 1));
		this.centerImg(new GeoPosition(43.93, 2.15));

		this.map = new JXMapKit();
		this.map.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);

		this.painter = new CustomPainter();

		this.map.getMainMap().setOverlayPainter(painter);
		Component clic_on_map = new MyComponent(this);
		this.map.getMainMap().addMouseListener(((MouseListener) clic_on_map));
		
		this.init();
		
	}

	public void paint() {
		this.painter.setWaypoints(set_waypoints);
		this.map.getMainMap().repaint();
	}

	public JXMapKit getMap() {
		return this.map;
	}

	public ImgManager getImgManager() {
		return this.imgManager;
	}
	
	public ArrayList<Img> getImgList() {
		return this.imgManager.imgList;
	}
	

	public void addWaypoint(double coord_x, double coord_y, int key) {
		this.set_waypoints.add(new CustomDefaultWaypoint(coord_x, coord_y, key));
		this.paint();
	}

	public void addWaypoint(GeoPosition point, int key) {
		this.set_waypoints.add(new CustomDefaultWaypoint(point, key));
		this.paint();
	}

	public void addImg() throws IOException {
		
		Img new_image = ImageExtract.LoadImage();
		this.imgManager.imgList.add(new_image);
		this.addWaypoint(new_image.Lattitude, new_image.Longitude, this.imgManager.imgList.size()-1);

	}
	
	public void centerImg(GeoPosition pos) {
		this.map.setCenterPosition(pos);
		this.paint();
	}
	
	public void init() {
		
		if (!this.imgManager.imgList.isEmpty()) {
			
			for (int i=0; i<this.imgManager.imgList.size();i++) {
				this.set_waypoints.add(
						new CustomDefaultWaypoint(this.imgManager.imgList.get(i).Lattitude, this.imgManager.imgList.get(i).Longitude, i)
						);
			}
		}
//		if (!this.imgManager.imgHashtable.isEmpty()) {
//			for (int i = 0; i < this.imgManager.imgHashtable.size(); i++) {
//				this.set_waypoints.add(
		
//					new CustomDefaultWaypoint(this.imgManager.imgHashtable.get(i).Lattitude, this.imgManager.imgHashtable.get(i).Longitude));
//			}
//			
//		}
		this.paint();
		
		
	}

	public Collection<? extends DefaultWaypoint> getSetWaypoints() {
		return this.set_waypoints;
	}

}