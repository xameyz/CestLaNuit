package Maven.Maven;

import java.awt.Component;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

public class Map {
	private JXMapKit map;
	private Set<DefaultWaypoint> waypoints;
	private CustomPainter painter;

	public Map() {
		this.waypoints = new HashSet<DefaultWaypoint>();
		this.waypoints.add(new DefaultWaypoint(51.50, -0.12));

		this.map = new JXMapKit();
		this.map.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);

		this.painter = new CustomPainter();

		this.map.getMainMap().setOverlayPainter(painter);
		Component clic_on_map = new MyComponent(this);
		this.map.getMainMap().addMouseListener(((MouseListener) clic_on_map));
		this.paint();
	}

	public void paint() {
		this.painter.setWaypoints(waypoints);
		this.map.getMainMap().repaint();
	}

	public JXMapKit getMap() {
		return this.map;
	}

	public void addWaypoint(double coord_x, double coord_y) {
		this.waypoints.add(new DefaultWaypoint(coord_x, coord_y));
		this.paint();
	}

	public Collection<? extends DefaultWaypoint> getWayPoint() {
		return this.waypoints;
	}

	public void addWaypoint(GeoPosition point) {
		this.waypoints.add(new DefaultWaypoint(point));
		this.paint();
	}
}