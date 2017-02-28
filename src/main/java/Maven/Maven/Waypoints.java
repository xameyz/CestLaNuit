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

class CustomPainter extends WaypointPainter {
    public void setWaypoints(List<? extends Waypoint> waypoints) {
        super.setWaypoints((Set<? extends JXMapViewer>) new HashSet<Waypoint>(waypoints));
    }
}
class MyComponent extends JComponent implements MouseListener {
	
	JXMapViewer m;
	List<DefaultWaypoint> waypoints;
	public MyComponent(JXMapViewer map, List<DefaultWaypoint> waypoints2) {
		this.m=map;
		this.waypoints=waypoints2;
	}
    public void mouseClicked(MouseEvent arg0) {
    	
        System.out.println("here was a click ! ");
        System.out.println(m.getMousePosition());
        Point test2 = m.getMousePosition();
//        test2.setLocation(arg0.getPoint().getX(), arg0.getPoint().getY());
        
        
//        Rectangle rect = m.getViewportBounds();
//        
//        Point p = arg0.getPoint();
//        GeoPosition g = m.convertPointToGeoPosition(p);
//        
//        
//        double latg = g.getLatitude();
//        double longg= g.getLongitude();
//        
//        m.getTil
//        
//        System.out.println("clic"+g);
//        
        
        for (int i=0; i<this.waypoints.size();i++) {
        	GeoPosition a = this.waypoints.get(i).getPosition();
        	Point2D test = m.convertGeoPositionToPoint(a);
        	Point test3 = new Point((int)test.getX(), (int)test.getY());
//        	if (test2.distance(test)<10) {
//        		System.out.println("FUCK YEAH");
//        	}
        	
        	if (test3.x-test2.x<20 && test2.y-test3.y<20 && test2.x-test3.x<20 && test3.y-test2.y<20) {
        		System.out.println("HOURRRA");
        	}
        	
        	
        	
        	
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

public class Waypoints {
    public static void main(String[] args) {
        List<DefaultWaypoint> waypoints = new ArrayList<DefaultWaypoint>();
        waypoints.add(new DefaultWaypoint(51.5, 0));
        waypoints.add(new DefaultWaypoint (45.33, 3.69));

        final JXMapKit jxMapKit = new JXMapKit();
        jxMapKit.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
        CustomPainter painter = new CustomPainter();
        painter.setWaypoints(waypoints);
        
        jxMapKit.getMainMap().setOverlayPainter(painter);
        
        System.out.println(waypoints.get(0).getPosition());
        final JFrame frame = new JFrame();
        frame.add(jxMapKit);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        System.out.println(waypoints.get(0));
        Component mouseClick = new MyComponent(jxMapKit.getMainMap(), waypoints)  ; 
        
        
        jxMapKit.getMainMap().addMouseListener(((MouseListener) mouseClick));

        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}