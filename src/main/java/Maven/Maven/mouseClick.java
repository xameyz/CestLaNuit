package Maven.Maven;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;

import javax.swing.JComponent;

import org.jxmapviewer.viewer.DefaultWaypoint;

class MyComponent extends JComponent implements MouseListener {

	/** generated. */
	private static final long serialVersionUID = 6845230025649741885L;
	private Map current_map;

	public MyComponent(Map _map) {
		this.current_map = _map;
	}

	public void mouseClicked(MouseEvent clic) {

		Point mousePosition_Point = current_map.getMap().getMousePosition();

		isWaypointsAroundClick method = new isWaypointsAroundClick();
		HashSet<DefaultWaypoint> result_list = method.isWaypointsAroundClick(this.current_map, mousePosition_Point);
		if (!result_list.isEmpty()) {

			System.out.println("Un waypoint a été trouvé à proximité");
		} else {
			System.out.println("Aucun waypoint à proximité");
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