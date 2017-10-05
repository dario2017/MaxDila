package maxDilaFirstTry;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import maxDilaFirstTry.Rozgrywka.StarterGry;

public class Game {
	JFrame frame;
	JScrollPane scrollPane;
	JButton startGame, oswiecimBtn, tychyBtn, katowiceBtn, myslowiceBtn, bedzinBtn, bytomBtn, buyBtn, sellBtn, bankBtn, shopBtn;
	JLabel playerStatusLabel, dayLabel, cashLabel, currentCityLabel, bankDepositLabel, bankLoanLabel, citiesLabel, eventsLabel, drugsPricesLabel, owningsLabel;
	JPanel mainPanel, panel1, panel2, panel3, panel11, panel12, panel31, panel32, panel33;
	JTextArea eventsArea;
	int day, cash, bankDeposit, bankLoan, LSDPrice, grassPrice, kokaPrice, heraPrice, haszPrice;;
	String currentCity;
	String[] drugs = {"LSD", "Grass", "Koka", "Hera", "Hasz"};
	
	
	public static void main(String[] args) {
		Game graj = new Game();
		graj.startGame();
		graj.play();
	}
	
	public void startGame() {
		frame = new JFrame("MaxDila");
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
// ALL PANELS
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		panel11 = new JPanel();
		panel11.setLayout(new BoxLayout(panel11, BoxLayout.Y_AXIS));
		panel11.setPreferredSize(new Dimension(300, 0));
		panel12 = new JPanel(new GridLayout(0, 2));
//		panel12.setPreferredSize(new Dimension(100, 200));
		panel31 = new JPanel();
		panel32 = new JPanel();
		panel32.setLayout(new BoxLayout(panel32, BoxLayout.Y_AXIS));
		panel33 = new JPanel();
		
// PANEL1 (UPPER LEFT) LABELS	
		startGame = new JButton("Startuj gre");
		playerStatusLabel = new JLabel("Status gracza:");
		dayLabel = new JLabel("Dzieñ: ");
		cashLabel = new JLabel("Pieni¹dze: ");
		currentCityLabel = new JLabel("Miasto: ");
		bankDepositLabel = new JLabel("Pieni¹dze w banku: ");
		bankLoanLabel = new JLabel("D³ug w banku: ");
		
// PANEL1 (UPPER RIGHT) BUTTONS
		oswiecimBtn = new JButton("Oœwiêcim");
		tychyBtn = new JButton("Tychy");
		katowiceBtn = new JButton("Katowice");
		myslowiceBtn = new JButton("Mys³owice");
		bedzinBtn = new JButton("Bêdzin");
		bytomBtn = new JButton("Bytom");
		
// PANEL2 (MIDDLE) JTEXTAREA
		eventsArea = new JTextArea(5, 50);
		eventsArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(eventsArea);
		eventsArea.setLineWrap(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
// PANEL3 (LOWER LEFT) JLIST
		JList<String> listOfDrugs = new JList<String>(drugs);
		listOfDrugs.setPreferredSize(new Dimension(200, 160));
		
// PANEL3 (LOWER MIDDLE) BUTTONS
		buyBtn = new JButton("Kup");
		sellBtn = new JButton("Sprzedaj");
		bankBtn = new JButton("Bank");
		shopBtn = new JButton("Sklep");
		
// PANEL3 (LOWER RIGHT) JLIST
		String[] myDrugs = {};
		JList<String> listOfOwnedDrugs = new JList<String>(myDrugs);
		listOfOwnedDrugs.setPreferredSize(new Dimension(200, 160));
		
		
		panel33.add(listOfOwnedDrugs);
		panel32.add(buyBtn);
		panel32.add(sellBtn);
		panel32.add(bankBtn);
		panel32.add(shopBtn);
		panel31.add(listOfDrugs);
		
		panel2.add(scrollPane);
		
		panel11.add(startGame);
		panel11.add(playerStatusLabel);
		panel11.add(dayLabel);
		panel11.add(cashLabel);
		panel11.add(currentCityLabel);
		panel11.add(bankDepositLabel);
		panel11.add(bankLoanLabel);
		panel12.add(oswiecimBtn);
		panel12.add(tychyBtn);
		panel12.add(katowiceBtn);
		panel12.add(myslowiceBtn);
		panel12.add(bedzinBtn);
		panel12.add(bytomBtn);

		panel3.add(panel31);
		panel3.add(panel32);
		panel3.add(panel33);
		
		panel1.add(panel11);
		panel1.add(panel12);
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
			
	}
	
	public void play() {
		startGame.addActionListener(new StarterGry());
		oswiecimBtn.addActionListener(new ChangeCityListener());
		tychyBtn.addActionListener(new ChangeCityListener());
		katowiceBtn.addActionListener(new ChangeCityListener());
		myslowiceBtn.addActionListener(new ChangeCityListener());
		bedzinBtn.addActionListener(new ChangeCityListener());
		bytomBtn.addActionListener(new ChangeCityListener());
		
		
	}
	
	class StarterGry implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			day = 1;
			cash = 1000;
			bankDeposit = 0;
			bankLoan = 0;
			dayLabel.setText("Dzieñ:   " + day);
			cashLabel.setText("Pieni¹dze:    " + cash);
			bankDepositLabel.setText("Pieni¹dze w banku:    " + bankDeposit);
			bankLoanLabel.setText("D³ug:    " + bankLoan);
			eventsArea.setText("Zaczynasz gre z 1000 CBLN. Wybierz miasto do którego chcesz pojechaæ.. \n");
		}
	}
	
	class ChangeCityListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			day++;
			dayLabel.setText("Dzieñ:   " + day);
			Object obj = e.getSource();
			if (obj == oswiecimBtn) {
				currentCity = oswiecimBtn.getText();
			} else if (obj == tychyBtn) {
				currentCity = tychyBtn.getText();
			} else if (obj == katowiceBtn) {
				currentCity = katowiceBtn.getText();
			} else if (obj == myslowiceBtn) {
					currentCity = myslowiceBtn.getText();
			} else if (obj == bedzinBtn) {
				currentCity = bedzinBtn.getText();
			} else if (obj == bytomBtn) {
				currentCity = bytomBtn.getText();
			}
			currentCityLabel.setText("Miasto:   " + currentCity);
			eventsArea.append("Przyjecha³eœ do " + currentCity + ". Bilet kosztowa³ 1 CBLN\n");
	// scrolls down JTextArea (eventsArea) automaticly 
			eventsArea.setCaretPosition(eventsArea.getDocument().getLength());
			cash -= 1;
			cashLabel.setText("Pieni¹dze:    " + cash);
			
			LSDPrice = (int) (Math.random() * 10);
			drugs[0] = "LSD    " + LSDPrice;
			
			
		}
	}
}
