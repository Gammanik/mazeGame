package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public abstract class TileMovement {

	private static Tile previous = new Tile(" ");
	private static boolean infoTileClicked = false;

	public static void addTilesListeners(Container comp) {

		final Component[] components = comp.getComponents();

		for (Component component : components) {

			if (component instanceof Container) {
				Component[] child = ((Container) component).getComponents();

				if (child != null && child.length > 0) {

					addTilesListeners((Container) component);

				}
			}

			component.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent evt) {
					if (SwingUtilities.isLeftMouseButton(evt)) {
						if (component.getName() == "infoTile" && !infoTileClicked) {
							component.setBackground(Color.YELLOW);

							infoTileClicked = true;
							// changing color of previous component
							// in case click on sideTiles again (want to choose
							// another)

							previous = (Tile) component; // remember previous
															// clicked tile

						} else { // when clicked out of SIDE tiles
							if (previous.getName() != "emptyTile")
								previous.setBackground(Color.ORANGE);
							// System.out.println("else case: " +
							// previous.getName());

							// click to a empty tile after an info tile
							if (infoTileClicked && component.getName() == "emptyTile") {
								//// System.out.println(component.getAccessibleContext().getAccessibleText());
								component.setBackground(Color.ORANGE);
								((Tile) component).setId(previous.getId());
								((Tile) component).setText(previous.getText()); // -edit
																				// by
																				// Dylan
								((Tile) component).setFont(new Font("Tahoma", Font.BOLD, 20));
								Border border = BorderFactory.createLineBorder(Color.gray, 0);
								((Tile) component).setBorder(border);
								// the above code sets the text from the
								// previously clicked tile
								// into the currently clicked tile
								((Tile) component).setHorizontalAlignment(SwingConstants.CENTER);
								// the above code centers the numbers in the
								// tiles
								previous.setText(" ");
								border = BorderFactory.createLineBorder(Color.gray, 1);
								previous.setBorder(border);
								previous.setBackground(Color.WHITE); // make for
																		// the
																		// color
																		// cannot
																		// be
																		// changed
								previous.setName("emptyTile"); // marked as used
								previous.setId("");
								component.setName("infoTile");
								((Tile) component).setAngle(((Tile) previous).getAngle());
								((Tile) previous).setAngle(0);
							}
							infoTileClicked = false;
						}
					}
					if (SwingUtilities.isRightMouseButton(evt) && (component.getName() == "infoTile")) {
						((Tile) component).changeAngle();
						component.repaint();
					}

				}

			});
		}
	}

}
