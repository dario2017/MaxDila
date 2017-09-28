package maxDilaFirstTry;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Game {
	JFrame frame;
	JButton playerBtn, cashBtn, oswiecim, katowice;
	JLabel cities, status;
	JPanel mainPanel, statusPanel, cityPanel;
	
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();		
	}
	
	public void startGame() {
		frame = new JFrame("MaxDila");
		mainPanel = new JPanel();
		statusPanel = new JPanel();
		cityPanel = new JPanel();
		playerBtn = new JButton("Gracz:");
		cashBtn = new JButton("Pieni¹dze: ");
		oswiecim = new JButton("Oœwiêcim");
		katowice = new JButton("Katowice");
		cities = new JLabel("Miasta");
		status = new JLabel("Status");
		
		statusPanel.add(status);
		statusPanel.add(playerBtn);
		statusPanel.add(cashBtn);
		cityPanel.add(oswiecim);
		cityPanel.add(katowice);
		
		mainPanel.add(statusPanel);
		mainPanel.add(cityPanel);
		
		GridLayout gridLay = new GridLayout();
		mainPanel.setLayout(gridLay);
		
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
	}
}
