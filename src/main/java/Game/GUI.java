package Game;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GUI extends JFrame {
	private static final int MAZE_SIZE = 30;
	private static final int GRID_SIZE = 20; // Adjust this value to change the grid size

	private int[][] maze;

	public GUI(int[][] maze) {
		this.maze = maze;
		paintMaze();
	}

	public GUI(int[][] maze, Tuple s, Tuple e){
		this.maze = maze;
		paintMaze();
		// Initialize the location of Jerry
		JerryLocation jerry = new JerryLocation(s, e, this, 500, 1);
		jerry.start();
		this.addKeyListener((KeyListener) new KeyboardListener());
	}

	private void paintMaze() {
		// enum to increase readability
		getContentPane().removeAll();
		int Empty = 0;
		int Wall = 1;
		int Tom = 2;
		int Jerry = 3;

		// Loop through the whole maze to fill grids with the corresponding color
		for (int i = 0; i < MAZE_SIZE; i++) {
			for (int j = 0; j < MAZE_SIZE; j++) {
				JPanel cell = new JPanel();
				cell.setPreferredSize(new Dimension(GRID_SIZE, GRID_SIZE));
				if (maze[i][j] == Wall) {
					cell.setBackground(Color.GRAY);
				}
				else if(maze[i][j] == Empty) {
					cell.setBackground(Color.WHITE);
				}
				else if(maze[i][j] == Tom) {
					cell.setBackground(Color.BLUE);
				}
				else if(maze[i][j] == Jerry) {
					cell.setBackground(Color.ORANGE);
				}

				add(cell);
			}
		}
		pack();
		revalidate();
		repaint();
	}

	// Update Maze
	public void updateMaze(int maze[][]){

		this.maze = maze;
		//paintMaze();
	}

	public void updateMaze(int row, int col, int nrow, int ncol, int color){
		maze[row][col] = 0;
		maze[nrow][ncol] = color;
		paintMaze();
	}

	// Get Maze
	public int[][] getMaze(){
		return this.maze;
	}
}