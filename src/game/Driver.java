// Bryan Neill     
// Driver.java
//Created tetris game that saves your score to an ArrayList written to a .txt file. Also implements
//menu that allows you to play the game and view the leaderboard sorted by top score (shows top 5).
// Eclipse Mars

package game;

import java.awt.EventQueue;

public class Driver {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
					
			@Override
			public void run() {
				Menu menu = new Menu();
			    menu.setVisible(true);
			}
		});
	}

}
