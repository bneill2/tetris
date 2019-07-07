// Bryan Neill     
// Tetris.java
//Created tetris game that saves your score to an ArrayList written to a .txt file. Also implements
//menu that allows you to play the game and view the leaderboard sorted by top score (shows top 5).
// Eclipse Mars

package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame{
	
	private JLabel statusbar;
	
	public Tetris() {
		
		initUI();
	}
	
	private void initUI() {
		
		statusbar = new JLabel(" 0");
		add(statusbar, BorderLayout.SOUTH);
		
		Board board = new Board(this);
		add(board);
		board.start();
		
		setTitle("Tetris");
		setSize(200, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public JLabel getStatusBar() {
		
		return statusbar;
	}
	
//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				Tetris game = new Tetris();
//	            game.setVisible(true);
//			}
//		});
//		
//	}
//	

}
