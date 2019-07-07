// Bryan Neill     
// ScoreManager.java
//Created tetris game that saves your score to an ArrayList written to a .txt file. Also implements
//menu that allows you to play the game and view the leaderboard sorted by top score (shows top 5).
// Eclipse Mars

package leaderboard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreManager {
	
	private ArrayList<Score> scores;
	
	private static final String HIGHSCORE_FILE = "scores.txt";
	
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;
	
	public ScoreManager() {
		scores = new ArrayList<Score>();
	}
	
	public ArrayList<Score> getScores() {
		loadScoreFile();
		sort();
		return scores;
	}
	
	private void sort() {
		ScoreCompare compare = new ScoreCompare();
		Collections.sort(scores, compare);
	}
	
	public void addScore(String name, int score) {
		loadScoreFile();
		scores.add(new Score(name, score));
		updateScoreFile();
	}
	
	public void loadScoreFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
			scores = (ArrayList<Score>) inputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("[Load] File Not Found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Load] IO Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("[Load] Class Not Found Error: " + e.getMessage());
		} finally {
			try {
				System.out.println(outputStream);
				if(outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("IO Error: " + e.getMessage());
			}
		}
	}
	
	public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] File Not Found Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
	}
	
	public String getHighscoreString() {
		
		String highscoreString = "";
		final int max = 5;
		
		ArrayList<Score> scores;
		scores = getScores();
			int i = 0;
			int x = scores.size();
			if(x > max) {
				x = max;
			}
			while (i < x) {
				highscoreString += (i + 1) + ".\t" + 
						scores.get(i).getName()+ ": \t\t" + 
						scores.get(i).getScore() + "<br>";
				i++;
			}
		return highscoreString;
	}

}
