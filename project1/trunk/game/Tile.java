package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Tile extends JLabel {

	// for random rotation
	Random rand = new Random();
	private int n = rand.nextInt(3) + 1;

	private int angle = n * 90;
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	private Color thisColor = Color.ORANGE;

	public Tile(String newID) {
		id = newID;
		setBackground(thisColor);
		setOpaque(true);
		setMinimumSize(new Dimension(101, 101));
		setPreferredSize(new Dimension(101, 101));
	}

	// copy constructor
	public Tile(Tile originalCopy) {
		this.setBackground(originalCopy.getBackground());
		this.setText(originalCopy.getText());
		this.setBorder(originalCopy.getBorder());
		this.setName(originalCopy.getName());
		this.setPreferredSize(originalCopy.getPreferredSize());
		this.setMinimumSize(originalCopy.getMinimumSize());
		this.setLocation(originalCopy.getLocation());
		this.setHorizontalAlignment(originalCopy.getHorizontalAlignment());
		this.setId(originalCopy.getId());
		this.setSize(originalCopy.getSize());
		this.setFont(originalCopy.getFont());
		this.setAngle(originalCopy.getAngle());

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.rotate(angle * Math.PI / 180, this.getBounds().width / 2, this.getBounds().height / 2);

		for (int i = 0; i < FileManager.matrix.size(); i++) {
			if (this.getName() == "infoTile" && this.getId().equals("" + i)) {
				ArrayList<Line> temp = FileManager.matrix.get(i);
				for (Line l : temp) {
					int temp1 = (int) l.getCoordinates()[0];
					int temp2 = (int) l.getCoordinates()[1];
					int temp3 = (int) l.getCoordinates()[2];
					int temp4 = (int) l.getCoordinates()[3];
					g2.drawLine(temp1, temp2, temp3, temp4);
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getId() {
		return id;
	}

	public void setId(String newId) {
		id = newId;
	}

	public String getAccesibleContext() {
		return id;
	}

	public int getAngle() {
		return angle;

	}

	public void changeAngle() {
		angle += 90;
	}

	public void setAngle(int ang) {
		angle = ang;
	}

}
