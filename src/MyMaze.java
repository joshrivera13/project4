// Names:Josh Rivera
// x500s:river573

import java.util.Random;

public class MyMaze{
    Cell[][] maze;

    public MyMaze(int rows, int cols) {
        maze = new Cell[rows][cols];
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                maze[i][j] = new Cell();
            }
        }
    }//constructor

    /* TODO: Create a new maze using the algorithm found in the writeup. */
    public static MyMaze makeMaze(int rows, int cols) {
        MyMaze theMaze = new MyMaze(rows, cols);
        Stack1Gen<Cell[][]> mazeStack = new Stack1Gen<Cell[][]>();
        mazeStack.push();





        return null;
    }

    /* TODO: Print a representation of the maze to the terminal */
    public void printMaze() {
    }

    /* TODO: Solve the maze using the algorithm found in the writeup. */
    public void solveMaze() {
    }

    public static void main(String[] args){
        /* Any testing can be put in this main function */
    }
}
