// Bryan Neill     
// Menu.java
//Created tetris game that saves your score to an ArrayList written to a .txt file. Also implements
//menu that allows you to play the game and view the leaderboard sorted by top score (shows top 5).
// Eclipse Mars

package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import leaderboard.Leaderboard;

public class Menu extends JFrame{
	
	private JPanel titlePanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	private JLabel title;
	private JButton play;
	private JButton scores;
	
	public Menu() {
		
		initUI();
	}
	
	private void initUI() {
		
		title = new JLabel("Tetris");
		play = new JButton("Play");
		scores = new JButton("Leaderboard");

		setLayout(new BorderLayout());
		
		titlePanel.add(title);
		btnPanel.add(play);
		btnPanel.add(scores);
		add(titlePanel, BorderLayout.NORTH);
		add(btnPanel, BorderLayout.CENTER);
		
		setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 400);
		
		play.addActionListener(new ButtonListener());
		scores.addActionListener(new ButtonListener());
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			Object str = e.getSource();
			
			if(str == play) {
				
				EventQueue.invokeLater(new Runnable() {
//					
					@Override
					public void run() {
						Tetris game = new Tetris();
			            game.setVisible(true);
					}
				});
	            
			} else if(str == scores) {
				
				EventQueue.invokeLater(new Runnable() {
//					
					@Override
					public void run() {
						Leaderboard scores = new Leaderboard();
						scores.setVisible(true);
					}
				});
				
			}
			
		}
	}

}
