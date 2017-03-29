package Maven.Maven;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;


public class CustomDefaultWaypoint extends DefaultWaypoint {
	
	private int key;
	private GeoPosition position;

	
	public CustomDefaultWaypoint(double latitude, double longitude)
	{
		super(latitude, longitude);
		
	}

	public CustomDefaultWaypoint(GeoPosition coord) {
		super(coord);
	}
}
