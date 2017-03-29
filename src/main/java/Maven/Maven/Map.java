package Maven.Maven;

import java.awt.Component;
import java.awt.event.MouseListener;
import java.io.IOException;
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

		this.set_waypoints.add(new CustomDefaultWaypoint(51.50, -0.12));

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

	public Hashtable<Integer, Img> getListBddImage() {
		return this.imgManager.imgHashtable;
	}
	
	public ImgManager getImgManager() {
		return this.imgManager;
	}

	public void addWaypoint(double coord_x, double coord_y) {
		this.set_waypoints.add(new CustomDefaultWaypoint(coord_x, coord_y));
		this.paint();
	}

	public void addWaypoint(GeoPosition point) {
		this.set_waypoints.add(new CustomDefaultWaypoint(point));
		this.paint();
	}

	public void addImg() throws IOException {
		
		Img new_image = ImageExtract.LoadImage();
		// this.image_list.list.put(key, value)
		this.addWaypoint(new_image.Lattitude, new_image.Longitude);

	}

	public void init() {
		
		if (!this.imgManager.imgHashtable.isEmpty()) {
			for (int i = 0; i < this.imgManager.imgHashtable.size(); i++) {
				this.set_waypoints.add(
					new CustomDefaultWaypoint(this.imgManager.imgHashtable.get(i).Lattitude, this.imgManager.imgHashtable.get(i).Longitude));
			}
			
		}
		this.paint();
		
		
	}

	public Collection<? extends DefaultWaypoint> getSetWaypoints() {
		return this.set_waypoints;
	}

}