package Arian_Project_2DSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class GamePlay extends JPanel implements KeyListener, ActionListener
{
	private static Color colorg=new Color(102, 0, 255);
	private static Color colort=new Color(175, 175, 175);
	
	private int[] snakeXlenght=new int[750];
	private int[] snakeYlenght=new int[750];
	
	private boolean left=false;
	private boolean up=false;
	private boolean right=false;
	private boolean down=false;
	
	private ImageIcon leftMouth;
	private ImageIcon upMouth;
	private ImageIcon rightMouth;
	private ImageIcon downMouth;
	
	private int lenghtSnake=3;
	
	private Timer timer;
	private int delay=100;
	private int moves=0;
	
	private ImageIcon snakeImage;
	private ImageIcon titleImage;
	
	public GamePlay() 
	{
	
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer (delay, this);
		timer.start();
		
	}
	public void paint(Graphics g) 
	{
		
		if(moves==0) 
		{
			snakeXlenght[2]=50;
			snakeXlenght[1]=80;
			snakeXlenght[0]=110;
		
			snakeYlenght[2]=100;
			snakeYlenght[1]=100;
			snakeYlenght[0]=100;
		}
		
	// rysowanie tytułowej belki wymiary formularza 900x700
		g.setColor(Color.DARK_GRAY);
		g.drawRect(14, 10, 853, 55);
		g.setColor(colort);
		g.fillRect(16, 12, 850, 52);
		// draw the title image
		titleImage=new ImageIcon("res/snaketitlem.png");
		titleImage.paintIcon(this, g, 400, 10);

		
	// draw border for game	
		
		g.setColor(Color.DARK_GRAY);
		g.drawRect(14, 73, 853, 578);
		
	// draw bacground for the gameplay
		g.setColor(colorg);
		g.fillRect(16, 75, 850, 575);
		
		rightMouth= new ImageIcon("res/rightMouth.png");
		rightMouth.paintIcon(this, g, snakeXlenght[0], snakeYlenght[0]);
		
		for(int i=0; i<lenghtSnake; ++i) 
		{
			if(i==0 && left) 
			{
				leftMouth= new ImageIcon("res/leftMouth.png");
				leftMouth.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if(i==0 && up) 
			{
				upMouth= new ImageIcon("res/upMouth.png");
				upMouth.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if(i==0 && right) 
			{
				rightMouth= new ImageIcon("res/rightMouth.png");
				rightMouth.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if(i==0 && down) 
			{
				downMouth= new ImageIcon("res/downMouth.png");
				downMouth.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if(i!=0) 
			{
				snakeImage= new ImageIcon("res/snakeImage.png");// ciało wąża
				snakeImage.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
		}
		
		g.dispose();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(left) 
		{
			for(int r =lenghtSnake-1; r>=0; r--) 
			{
				snakeYlenght[r+1]=snakeYlenght[r];	
			}
			for(int r =lenghtSnake; r>=0; r--) 
			{
				if(r==0) 
				{
					snakeXlenght[r] = snakeXlenght[r] - 30;	
				}
				else
				{
					snakeXlenght[r] = snakeXlenght[r-1];	
				}
				if(snakeXlenght[r] < 14)
				{
					snakeXlenght[r] = 853;
				}
			}
			repaint();
		}
		if(up) 
		{
			for(int r =lenghtSnake-1; r>=0; r--) 
			{
				snakeXlenght[r+1]=snakeXlenght[r];	
			}
			for(int r =lenghtSnake; r>=0; r--) 
			{
				if(r==0) 
				{
					snakeYlenght[r] = snakeYlenght[r] - 30;	
				}
				else
				{
					snakeYlenght[r] = snakeYlenght[r-1];	
				}
				if(snakeYlenght[r]<75)
				{
					snakeYlenght[r] = 575;
				}
			}
			repaint();	
			
		}
		if(right) 
		{
			for(int r =lenghtSnake-1; r>=0; r--) 
			{
				snakeYlenght[r+1]=snakeYlenght[r];	
			}
			for(int r =lenghtSnake; r>=0; r--) 
			{
				if(r==0) 
				{
					snakeXlenght[r] = snakeXlenght[r] + 30;	
				}
				else
				{
					snakeXlenght[r] = snakeXlenght[r-1];	
				}
				if(snakeXlenght[r]>853)
				{
					snakeXlenght[r] = 14;
				}
			}
			repaint();	
		}
		if(down)
		{
			for(int r =lenghtSnake-1; r>=0; r--) 
			{
				snakeXlenght[r+1]=snakeXlenght[r];	
			}
			for(int r =lenghtSnake; r>=0; r--) 
			{
				if(r==0) 
				{
					snakeYlenght[r] = snakeYlenght[r] + 30;	
				}
				else
				{
					snakeYlenght[r] = snakeYlenght[r-1];	
				}
				if(snakeYlenght[r] > 640)
				{
					snakeYlenght[r] = 75;
				}
			}
			repaint();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		{
			moves++;
			left=true;
			if(!right)
			{
				left=true;
			}
			else
			{
				left=false;
				right=true;
			}	
			up=false;
			down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) 
		{
			moves++;
			up=true;
			if(!down)
			{
				up=true;
			}
			else
			{
				up=false;
				down=true;
			}	
			
			left=false;
			right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
		{
			moves++;
			right=true;
			if(!left)
			{
				right=true;
			}
			else
			{
				right=false;
				left=true;
			}	
			up=false;
			down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) 
		{
			moves++;
			down=true;
			if(!up)
			{
				down=true;
			}
			else
			{
				down=false;
				up=true;
			}	
			
			left=false;
			right=false;
		}
		
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
