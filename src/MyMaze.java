// Names:Josh Rivera
// x500s:river573
/**
 * Known Bugs:
 * -Occasionally will create unsolvable mazes
 * -On mazes that have more than 10 cells some cells will be unreachable but the maze can still be solved
 *
 */

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

    public static MyMaze makeMaze(int rows, int cols) {
        MyMaze theMaze = new MyMaze(rows, cols);
        Stack1Gen<int[]> mazeStack = new Stack1Gen<int[]>();
        int[] coords = new int[]{0,0};
        theMaze.maze[0][0].setVisited(true);
        mazeStack.push(coords);
        while (mazeStack.isEmpty() == false){
            int[] top = mazeStack.top();


            //case where you can only move right and down
            if((top[0] == 0 && top[1] < cols - 1) || (top[0] < rows - 1 && top[1] < cols - 1)){
                int availCells = 2;
                while (availCells != 0){
                    //in this case -> right = 1 and down = 2
                    int dir = getRandNum(1,3);
                    if (dir == 1 && theMaze.maze[top[0]][top[1] + 1].getVisited() == false){
                        mazeStack.push(new int[]{top[0], top[1] + 1});
                        theMaze.maze[top[0]][top[1] + 1].setVisited(true);
                        theMaze.maze[top[0]][top[1]].setRight(false);
                        break;
                    }//breaking out of loop since we found an available cell to the right
                    else if (dir == 2 && theMaze.maze[top[0] + 1][top[1]].getVisited() == false){
                        mazeStack.push(new int[]{top[0] + 1, top[1]});
                        theMaze.maze[top[0] + 1][top[1]].setVisited(true);
                        theMaze.maze[top[0]][top[1]].setBottom(false);
                        break;
                    }//breaking out of loop since we found available cell below
                    availCells--;
                }//while loop
                if (availCells == 0){
                    mazeStack.pop();
                }//no un-visited cells
            }//right and down case

            //case where you can only move right and up
            else if ((top[0] == rows - 1 && top[1] < cols - 1) || (top[0] > 0 && top[1] < cols - 1)){
                int availcells = 2;
                while (availcells != 0){
                    //in this case -> right = 1 and up = 2
                    int dir = getRandNum(1,3);
                    if (dir == 1 && theMaze.maze[top[0]][top[1] + 1].getVisited() == false){
                        mazeStack.push(new int[]{top[0], top[1] + 1});
                        theMaze.maze[top[0]][top[1] + 1].setVisited(true);
                        theMaze.maze[top[0]][top[1]].setRight(false);
                        break;
                    }//breaking out of loop since we found an available cell to the right
                    else if (dir == 2 && theMaze.maze[top[0] - 1][top[1]].getVisited() == false){
                        mazeStack.push(new int[]{top[0] - 1, top[1]});
                        theMaze.maze[top[0] - 1][top[1]].setVisited(true);
                        theMaze.maze[top[0] - 1][top[1]].setBottom(false);
                        break;
                    }//breaking out of loop since we found available cell above
                    availcells--;
                }//while loop
                if (availcells == 0){
                    mazeStack.pop();
                }//no unvisited cells
            }//right and up case

            //left and down
            else if ((top[0] == 0 && top[1] > 0) || (top[0] < rows - 1 && top[1] > 0)){
                int availcells = 2;
                while (availcells != 0){
                    //in this case -> left = 1 and down = 2
                    int dir = getRandNum(1,3);
                    if(dir == 1 && theMaze.maze[top[0]][top[1] - 1].getVisited() == false){
                        mazeStack.push(new int[]{top[0], top[1 - 1]});
                        theMaze.maze[top[0]][top[1] - 1].setVisited(true);
                        theMaze.maze[top[0]][top[1] - 1].setRight(false);
                        break;
                    }//breaking out of loop since we found available cell to the left
                    else if(dir == 2 && theMaze.maze[top[0] + 1][top[1]].getVisited() == false){
                        mazeStack.push(new int[]{top[0] + 1, top[1]});
                        theMaze.maze[top[0] + 1][top[1]].setVisited(true);
                        theMaze.maze[top[0]][top[1]].setBottom(false);
                        break;
                    }//breaking out of loop since we found available cell below
                    availcells--;
                }//while loop
                if(availcells == 0){
                    mazeStack.pop();
                }//no unvisited cells
            }//left and down only case

            //left and up
            else if ((top[0] == rows - 1 && top[1] > 0) || (top[0] > 0 && top[1] > 0)){
                int availcells = 2;
                while (availcells != 0){
                    //in this case -> left = 1 and up = 2
                    int dir = getRandNum(1,3);
                    if(dir == 1 && theMaze.maze[top[0]][top[1] - 1].getVisited() == false){
                        mazeStack.push(new int[]{top[0], top[1] - 1});
                        theMaze.maze[top[0]][top[1] - 1].setVisited(true);
                        theMaze.maze[top[0]][top[1] - 1].setRight(false);
                        break;
                    }//breaking out of loop since we found available cell to the left
                    else if(dir == 2 && theMaze.maze[top[0] - 1][top[1]].getVisited() == false){
                        mazeStack.push(new int[]{top[0] - 1, top[1]});
                        theMaze.maze[top[0] - 1][top[1]].setVisited(true);
                        theMaze.maze[top[0] - 1][top[1]].setBottom(false);
                        break;
                    }//breaking out of loop since we found available cell above
                    availcells--;
                }//while loop
                if(availcells == 0){
                    mazeStack.pop();
                }//no unvisited cells
            }// left and up only case

            //can go in any direction
            else{
                int availCells = 4;
                while(availCells != 0){
                    //in this case -> right = 1, left = 2, down = 3, up = 4
                    int dir = getRandNum(1,5);
                    if(dir == 1 && theMaze.maze[top[0]][top[1] + 1].getVisited() == false){
                        mazeStack.push(new int[]{top[0], top[1] + 1});
                        theMaze.maze[top[0]][top[1] + 1].setVisited(true);
                        theMaze.maze[top[0]][top[1]].setRight(false);
                        break;
                    }//breaking out of loop since we found available cell to right
                    else if(dir == 2 && theMaze.maze[top[0]][top[1] - 1].getVisited() == false){
                        mazeStack.push(new int[]{top[0], top[1] - 1});
                        theMaze.maze[top[0]][top[1] - 1].setVisited(true);
                        theMaze.maze[top[0]][top[1] - 1].setRight(false);
                        break;
                    }//breaking out of loop since we found available cell to the left
                    else if(dir == 3 && theMaze.maze[top[0] + 1][top[1]].getVisited() == false){
                        mazeStack.push(new int[]{top[0] + 1, top[1]});
                        theMaze.maze[top[0] + 1][top[1]].setVisited(true);
                        theMaze.maze[top[0]][top[1]].setBottom(false);
                        break;
                    }//breaking out of loop since we found available cell below
                    else if(dir == 4 && theMaze.maze[top[0] - 1][top[1]].getVisited() == false){
                        mazeStack.push(new int[]{top[0] - 1, top[1]});
                        theMaze.maze[top[0] - 1][top[1]].setVisited(true);
                        theMaze.maze[top[0] - 1][top[1]].setBottom(false);
                        break;
                    }//breaking out of loop since we found available cell above
                    availCells--;
                }//while loop
                if(availCells == 0){
                    mazeStack.pop();
                }//no unvisited cells
            }//can move in any direction
        }//looping thru stack
        for(int i = 0; i < theMaze.maze.length; i ++){
            for(int j = 0; j < theMaze.maze[0].length; j++){
                theMaze.maze[i][j].setVisited(false);
            }
        }
        return theMaze;
    }//makeMaze

    public void printMaze() {
        String print = "|";
        for(int i = 0; i < maze.length; i++){
            if (i == 0){
                print += "---|".repeat(maze[0].length);
                print += "\n";
            }
            if (i > 0){
                print += "\n";
            }
            for(int j = 0; j < maze[0].length; j++){
                if (i == maze.length - 1 && j == maze[0].length - 1){
                    if (maze[i][j].getVisited() == false){
                        print += "    ";
                    }
                    else{print += " *  ";}
                    continue;
                }
                if (j == 0 && i != 0){
                    print += "|";
                }
                else if (j == 0 && i == 0){
                    print += " ";
                }
                print += maze[i][j].toStringTop();
            }
            print += "\n";
            for (int p = 0; p < maze[0].length; p++){
                if (p == 0){
                    print += "|";
                }
                print += maze[i][p].toStringBot();
            }
        }

        System.out.println(print);
    }//printMaze

    /* TODO: Solve the maze using the algorithm found in the writeup. */
    public void solveMaze() {

    }

    //function found at https://www.baeldung.com/java-generating-random-numbers-in-range
    public static int getRandNum(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args){
        MyMaze test = makeMaze(3,3);
        test.printMaze();


    }
}
