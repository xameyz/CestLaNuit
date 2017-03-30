package Maven.Maven;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;


public class Custom_DefaultWaypoint extends DefaultWaypoint {
	
	private int key;
	private GeoPosition position;

	
	public Custom_DefaultWaypoint(double latitude, double longitude)
	{
		this(new GeoPosition(latitude, longitude));
	}

	public Custom_DefaultWaypoint(GeoPosition coord) {
		this.position = coord;
	}
}
