package Maven.Maven;

import java.awt.Component;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.DefaultWaypoint;

public class Carte {
	private JXMapKit map;
	private List<DefaultWaypoint> list_waypoints;
	private CustomPainter painter;

	public Carte() {
		this.list_waypoints = new ArrayList<DefaultWaypoint>();
		list_waypoints.add(new DefaultWaypoint(51.50, -0.12));

		this.map = new JXMapKit();
		this.map.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);

		this.painter = new CustomPainter();

		Component mouseClick = new MyComponent(this);
		this.map.getMainMap().addMouseListener(((MouseListener) mouseClick));
	}

	public void paint() {
		this.painter.setWaypoints(list_waypoints);
		this.map.getMainMap().setOverlayPainter(painter);
		this.map.getMainMap().repaint();
	}

	public JXMapKit getCarte() {
		return this.map;
	}

	public void addWaypoint(double xpx, double ypx) {
		this.list_waypoints.add(new DefaultWaypoint(xpx, ypx));
		this.paint();
	}

	public List<DefaultWaypoint> getListe() {
		return this.list_waypoints;
	}
}