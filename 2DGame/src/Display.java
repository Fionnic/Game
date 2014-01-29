import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JPanel gp = (JPanel) getGlassPane();
	public Images i;
	public PlayerKeys k;

	public Display() {
		i = new Images();
		gp.setVisible(true);
		k = new PlayerKeys(this, i);

		gp.setLayout(new GridLayout(1, 1, 0, 0));
		this.setLayout(new GridLayout(1, 1, 0, 0));
		
		gp.add(k);
		this.add(i);
	}
}
