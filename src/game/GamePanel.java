package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel<BufferImage, BufferIemage> extends JPanel implements Runnable, KeyListener {
   
	public static final int WIDTH = 400;
	public static final int HEIGHT =400;
	private static final int SIZE = 0;
	private static final Color r = null;
	private static final String GREEN = null;
	private static final int  = 0;
	//Render
	private Graphics2D g2d;
	private BufferedImage image;
	//Game Loop
	private Thread thread;
	private boolean running;
	private long targetTime;
	
	//Game stuff
	Entity head;
	ArrayList<Entity>snake;
	private Color color;
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	}  
	@Override
	public void addNotify( ) {
	super.addNotify();
	thread =new Thread(this);
	 thread.start();
	}
	private void setFPS(int fps){ 
		targetTime=1000 /fps;
	}
	public void keyPressed(KeyEvent arg0) {
		

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		

	}

	@Override
	public void run() {
		if (running)return;
		init();
		long startTime = 0;
		long elapsed;
		long wait;
		while(running)
		startTime= System.nanoTime();
		 update();
		 requestRender();
		
		elapsed=System.nanoTime() - startTime;
		wait=targetTime - elapsed /1000000;
		if (wait>0) {
			try {
				Thread.sleep(wait);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		
		}

	}
	private void init() {
		image =new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		g2d=image.createGraphics();
		running =true;
		setUplevel();
		setFPS (10);
		
		}
	private void setUplevel() {
		snake =new ArrayList<Entity>();
		head =new Entity(SIZE);
		head.setPosition(WIDTH / 2,HEIGHT/ 2);
		 snake.add(head);
		
		for (int i= 1;i<10;i++);
		Entity e =new Entity(SIZE);
		head.setPosition(head.getX() + (i* SIZE),head.getY() );
		snake.add(e);
	}
	private void requestRender() {
		render(g2d);
		Graphics g = getGraphics();
		g.drawImage(image,0,0,null);
		g.dispose();
		
		
		
		
	}
	private void update() {
		
		}
	
	public void render (Graphics2D g2d) {
		g2d.clearRect(0,0, WIDTH,HEIGHT);
		
		g2d.setColor(Color.GREEN);
		for (Entity e : snake) {
		e.render(g2d);
		
		
		
	
	}

	}
