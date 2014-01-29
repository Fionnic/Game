import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayerKeys extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;

	public Rectangle player;
	public Rectangle hat1, hat2;
	public Rectangle shorts;
	public Rectangle platform;
	public Rectangle ch1, ch2, ch3, ch4;
	public Rectangle jetpack, fire;

	public Point mousePoint;

	public int keyUp = KeyEvent.VK_W;
	public int keyRight = KeyEvent.VK_D;
	public int keyLeft = KeyEvent.VK_A;
	public int keySpace = KeyEvent.VK_SPACE;
	public int leftMouse = MouseEvent.BUTTON1;
	public int playerW = 30;
	public int playerH = 50;
	public int platformW = 1500;
	public int platformH = 30;

	public boolean jumping = false;
	public boolean right = false;
	public boolean left = false;
	public boolean space = false;
	public boolean mouseActive = true;
	public boolean midAir = false;
	
	public PlayerKeys(Display f, Images i) {

		setBackground(Color.GRAY);

		player = new Rectangle(200, 200, playerW, playerH);
		hat1 = new Rectangle(200, 200, playerW, playerH / 4);
		hat2 = new Rectangle(210, 206, playerW + 5, playerH / 8);
		shorts = new Rectangle(200, 236, playerW, playerH / 3);
		jetpack = new Rectangle(190, 212, playerW - 5, (playerH / 2) - 1);
		fire = new Rectangle(190, 236, 10, 10);
		platform = new Rectangle(-100, 450, platformW, platformH);
		ch1 = new Rectangle(0, 0, 2, 23);
		ch2 = new Rectangle(0, 0, 2, 23);
		ch3 = new Rectangle(0, 0, 23, 2);
		ch4 = new Rectangle(0, 0, 23, 2);

		f.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == keyUp) {
					jumping = true;
				}
				if (e.getKeyCode() == keyRight) {
					right = true;
				}
				if (e.getKeyCode() == keyLeft) {
					left = true;
				}
				if (e.getKeyCode() == keySpace) {
					space = true;
				}
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == keyUp) {
					jumping = false;
				}
				if (e.getKeyCode() == keyRight) {
					right = false;
				}
				if (e.getKeyCode() == keyLeft) {
					left = false;
				}
				if (e.getKeyCode() == keySpace) {
					space = false;
				}
			}
		});

		f.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mousePoint = new Point(e.getX(), e.getY() - 20);
			}
		});

		f.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				mousePoint = new Point(e.getX(), e.getY() - 20);
			}
		});
		
		
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D gpc = (Graphics2D) g;
		gpc.setColor(Color.BLACK);
		gpc.fill(player);
		gpc.setColor(Color.BLACK);
		gpc.fill(platform);
		gpc.setColor(Color.BLACK);
		gpc.draw(ch1);
		gpc.draw(ch2);
		gpc.draw(ch3);
		gpc.draw(ch4);
		gpc.setColor(Color.LIGHT_GRAY);
		gpc.fill(ch1);
		gpc.fill(ch2);
		gpc.fill(ch3);
		gpc.fill(ch4);
		gpc.fill(hat1);
		gpc.fill(hat2);
		gpc.fill(shorts);
		gpc.setColor(Color.MAGENTA);
		gpc.fill(jetpack);

		if (player.y <= 396) {
			player.y++;
			hat1.y++;
			hat2.y++;
			shorts.y++;
			jetpack.y++;
			fire.y++;
			midAir = true;
		}

		if (right) {
			player.x++;
			hat1.x++;
			hat2.x++;
			hat2.x = player.x + 12;
			shorts.x++;
			jetpack.x++;
			jetpack.x = player.x - 10;
			fire.x++;
			fire.x = jetpack.x;
		}
		if (left) {
			player.x--;
			hat1.x--;
			hat2.x--;
			hat2.x = player.x - 18;
			shorts.x--;
			jetpack.x--;
			jetpack.x = player.x + 16;
			fire.x--;
			fire.x = jetpack.x + 15;
		}
		if (jumping) {
			player.y -= 3;
			hat1.y -= 3;
			hat2.y -= 3;
			shorts.y -= 3;
			jetpack.y -= 3;
			fire.y -= 3;
			if (player.y == 300) {
				jumping = false;
			}
		}
		if (space) {
			gpc.setColor(Color.RED);
			gpc.fill(fire);
			player.y -= 2;
			hat1.y -= 2;
			hat2.y -= 2;
			shorts.y -= 2;
			jetpack.y -= 2;
			fire.y -= 2;
		}
		if (mouseActive) {
			ch1.x = mousePoint.x;
			ch1.y = mousePoint.y + 15;
			ch2.x = mousePoint.x;
			ch2.y = mousePoint.y - 37;
			ch3.x = mousePoint.x + 15;
			ch3.y = mousePoint.y;
			ch4.x = mousePoint.x - 37;
			ch4.y = mousePoint.y;
		}
		if(midAir) {
			
		}

		repaint();
	}

	public void run() {

	}
}
