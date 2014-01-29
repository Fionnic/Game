import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Images extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public int width = main.width;
	public int height = main.height;
	
	public Image crosshair;
	public boolean imagesLoaded = false;
	
	public Images() {
		this.setBackground(Color.GRAY);
	}
	
	public void loadImages() {
		//aint usin this right now
		crosshair = new ImageIcon("C:/Pictures/crosshair.png").getImage();
		imagesLoaded = true;
	}
}
