package Maven.Maven;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JComponent;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

class MyComponent extends JComponent implements MouseListener {
	
	private Carte map;
	private List<DefaultWaypoint> waypoints;
	private int current_zoom;
	
	public MyComponent(Carte _map) {
		this.map=_map;
		this.waypoints=this.map.getListe();
		
	}
	
    public void mouseClicked(MouseEvent clic) {
    	
    	this.current_zoom=this.map.getCarte().getMainMap().getZoom();
        Point mousePosition_Point = map.getCarte().getMousePosition();
        boolean flag=true;
        
        for (int i=0; i<this.waypoints.size();i++) {
        	System.out.println(this.waypoints.get(i).getPosition());
        	GeoPosition waypoint_courant_geo = this.waypoints.get(i).getPosition();
        	Point2D waypoint_courant_Point2D = this.map.getCarte().getMainMap().convertGeoPositionToPoint(waypoint_courant_geo);
        	Point waypoint_courant_Point = new Point((int)waypoint_courant_Point2D.getX(), (int)waypoint_courant_Point2D.getY());
//        	
        	if (waypoint_courant_Point.x-mousePosition_Point.x<(20-this.current_zoom) && mousePosition_Point.y-waypoint_courant_Point.y<(20-this.current_zoom) && mousePosition_Point.x-waypoint_courant_Point.x<(20-this.current_zoom)) {
        		System.out.println("HOURRRA");
        		System.out.println("zoom"+current_zoom);
        	}
        	
        	else {
        		flag=false;
        	}
        	
        	
        }
        if (flag==false) {
        	this.map.addWaypoint(mousePosition_Point.getX(), mousePosition_Point.getY());
        	
        }

    }

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
    
}