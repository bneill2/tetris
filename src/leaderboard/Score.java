// Bryan Neill     
// Score.java
//Created tetris game that saves your score to an ArrayList written to a .txt file. Also implements
//menu that allows you to play the game and view the leaderboard sorted by top score (shows top 5).
// Eclipse Mars

package leaderboard;

import java.io.Serializable;

public class Score implements Serializable{
	
	private int score;
	private String name;
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public Score(String name, int score) {
		this.score = score;
		this.name = name;
	}

}
