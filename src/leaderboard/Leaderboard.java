// Bryan Neill     
// Leaderboard.java
//Created tetris game that saves your score to an ArrayList written to a .txt file. Also implements
//menu that allows you to play the game and view the leaderboard sorted by top score (shows top 5).
// Eclipse Mars

package leaderboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Menu;

public class Leaderboard extends JFrame{
	
	private JPanel titlePanel = new JPanel();
	private JPanel scorePanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	private JLabel title;
	private JLabel scores;
	private JButton back;
	private ScoreManager sm = new ScoreManager();
	private String scoreList = sm.getHighscoreString();
	
	public Leaderboard() {
		initUI();
	}

	private void initUI() {
		title = new JLabel("Leaderboard");
		scores = new JLabel();
		scores.setText("<html><body>" + scoreList + "</body></html>");
		back = new JButton("Back");
		
		setLayout(new BorderLayout());
		
		titlePanel.add(title);
		scorePanel.add(scores);
		btnPanel.add(back);
		add(titlePanel, BorderLayout.NORTH);
		add(scorePanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 400);
		
		back.addActionListener(new ButtonListener());
		
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			Object str = e.getSource();
			
			if(str == back) {
				
				Menu menu = new Menu();
				menu.setVisible(true);
				
			}
		}
	}
}