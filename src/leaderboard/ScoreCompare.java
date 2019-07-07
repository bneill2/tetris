// Bryan Neill     
// ScoreCompare.java
//Created tetris game that saves your score to an ArrayList written to a .txt file. Also implements
//menu that allows you to play the game and view the leaderboard sorted by top score (shows top 5).
// Eclipse Mars

package leaderboard;

import java.util.Comparator;

public class ScoreCompare implements Comparator<Score>{
	
	public int compare(Score score1, Score score2) {
		
		int sc1 = score1.getScore();
		int sc2 = score2.getScore();
		
		if (sc1 > sc2) {
			return -1;
			
		} else if(sc1 < sc2) {
			return 1;
		} else {
			return 0;
		}
	}

}
