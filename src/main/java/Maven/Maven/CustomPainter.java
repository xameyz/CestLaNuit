package Maven.Maven;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

class CustomPainter extends WaypointPainter {
    public void setWaypoints(List<? extends Waypoint> waypoints) {
        super.setWaypoints((Set<? extends JXMapViewer>) new HashSet<Waypoint>(waypoints));
    }
}