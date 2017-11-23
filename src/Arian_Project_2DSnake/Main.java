package Arian_Project_2DSnake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Main {

	
	
	private void titleAlign(JFrame frame) 
	{
		Font ffont=new Font("Arial", Font.BOLD,12);
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(ffont);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);
    }
	public void createAndShowGUI() {
		 	JFrame frame = new JFrame();
		 	GamePlay gameplay=new GamePlay();
			frame.setTitle("Sssssnake");
			frame.setBounds(10, 10, 910, 710);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addComponentListener(new ComponentAdapter() 
			{
				public void componentResized(ComponentEvent e) 
				{
	                titleAlign(frame);
	            }
			});
	        frame.setResizable(false);// blokuje możliwośc zmiany rozmiaru formularza
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);//ustawia formularz na środku ekranu
			frame.add(gameplay);
	}	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
            new Main().createAndShowGUI();
        });
		
		
	}

}
