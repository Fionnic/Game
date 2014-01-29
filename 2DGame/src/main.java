import javax.swing.JFrame;

public class main {

	public static Display f = new Display();
	public static int width = 800;
	public static int height = 600;

	public static void main(String[] args) {
		f.setSize(width, height);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("2DGAME");
	}

}
