package Maven.Maven;

import java.awt.Component;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class Map {

	private JXMapKit map;
	private Set<DefaultWaypoint> waypoints;
	private CustomPainter painter;
	private ListeIm image_list;

	public Map() {

		this.image_list = new ListeIm();
		this.waypoints = new HashSet<DefaultWaypoint>();

		this.waypoints.add(new DefaultWaypoint(51.50, -0.12));

		this.map = new JXMapKit();
		this.map.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);

		this.painter = new CustomPainter();

		this.map.getMainMap().setOverlayPainter(painter);
		Component clic_on_map = new MyComponent(this);
		this.map.getMainMap().addMouseListener(((MouseListener) clic_on_map));

		this.init();

	}

	public void paint() {
		this.painter.setWaypoints(waypoints);
		this.map.getMainMap().repaint();
	}

	public JXMapKit getMap() {
		return this.map;
	}

	public ListeIm getList_image() {
		return this.image_list;
	}

	public void addWaypoint(double coord_x, double coord_y) {
		this.waypoints.add(new DefaultWaypoint(coord_x, coord_y));
		this.paint();
	}

	public void addWaypoint(GeoPosition point) {
		this.waypoints.add(new DefaultWaypoint(point));
		this.paint();
	}

	public void addImg() throws IOException {
		
		Img new_image = ImageExtract.LoadImage();
		// this.image_list.list.put(key, value)
		this.addWaypoint(new_image.Lattitude, new_image.Longitude);

	}

	public void init() {

		for (int i = 0; i < this.image_list.list.size(); i++) {
			this.waypoints.add(
					new DefaultWaypoint(this.image_list.list.get(i).Lattitude, this.image_list.list.get(i).Longitude));
		}
		this.paint();

	}

	public Collection<? extends DefaultWaypoint> getWayPoint() {
		return this.waypoints;
	}

}