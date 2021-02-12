import java.util.ArrayList;
import java.util.Scanner;


public class newsl {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			String[] data = scanner.next().split(",");
			int numberOfLadders = Integer.valueOf(data[0]);
			int numberOfSnakes = Integer.valueOf(data[1]);
			
			ArrayList <Integer> ladderStartingPoints = new ArrayList <Integer> ();
			ArrayList <Integer> ladderEndingPoints = new ArrayList <Integer> ();
			ArrayList <Integer> snakeStartingPoints = new ArrayList <Integer> ();
			ArrayList <Integer> snakeEndingPoints = new ArrayList <Integer> ();
			
			for (int j = 0; j < numberOfLadders; j++) {
				String[] ladderData = scanner.next().split(",");
				ladderStartingPoints.add(Integer.valueOf(ladderData[0]));
				ladderEndingPoints.add(Integer.valueOf(ladderData[1]));
			}
			
			for (int j = 0; j < numberOfSnakes; j++) {
				String[] snakeData = scanner.next().split(",");
				snakeStartingPoints.add(Integer.valueOf(snakeData[0]));
				snakeEndingPoints.add(Integer.valueOf(snakeData[1]));
			}
			
			State initialState = new State(1, 0);
			ArrayList <Integer> visited = new ArrayList <Integer> ();
			ArrayList <State> list = new ArrayList <State> ();
			list.add(initialState);
			visited.add(1);
			
			while (!list.isEmpty()) {
				State top = list.get(0);
				list.remove(0);
				
				if (top.currentCell == 100) {
					System.out.println(top.moves);
					break;
				}
				
				for (int j = 1; j <= 6; j++) {
					int temp = top.currentCell + j;
					int ladderIndex = ladderStartingPoints.indexOf(temp);
					int snakeIndex = snakeStartingPoints.indexOf(temp);
					if (ladderIndex != -1) {
						temp = ladderEndingPoints.get(ladderIndex);
					}
					else if (snakeIndex != -1) {
						temp = snakeEndingPoints.get(snakeIndex);
					}
					if (!visited.contains(temp)) {
						list.add(new State(temp, top.moves + 1));
						visited.add(temp);
					}
				}
			}
		}
		
		scanner.close();
	}
	
	public static class State {
		public int currentCell;
		public int moves;
		
		public State(int currentCell, int moves) {
			this.currentCell = currentCell;
			this.moves = moves;
		}
		
		public String toString() {
			return currentCell + " " + moves;
		}
	}

}

