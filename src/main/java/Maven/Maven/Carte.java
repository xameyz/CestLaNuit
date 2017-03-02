package Maven.Maven;


import javax.swing.*;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.DefaultWaypointRenderer;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Carte {
	private JXMapKit map;
	private List<DefaultWaypoint> list_waypoints;
	private CustomPainter painter;
	
	public Carte() {
		
		
		this.list_waypoints = new ArrayList<DefaultWaypoint>();
	    list_waypoints.add(new DefaultWaypoint (51.50, -0.12));
	
	    this.map = new JXMapKit();
	    this.map.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
	    
	    this.painter = new CustomPainter();
	    
	    Component mouseClick = new MyComponent(this)  ; 
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