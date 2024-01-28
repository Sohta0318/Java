package dev.lpa;

import java.util.Arrays;

public class Maze {
    public static final int MAZE_SIZE = 4;
    private final String[][] cells = new String[MAZE_SIZE][MAZE_SIZE];

    public Maze() {
        for(var row : cells){
            Arrays.fill(row, "");
        }
    }

    public int[] getNextLocation(int[] lastStop){

        int[] nextStop = new int[2];
        nextStop[1] = (lastStop[1] == Maze.MAZE_SIZE -1) ? 0 : lastStop[1] + 1;
        nextStop[0] = lastStop[0];
        if(nextStop[1] == 0) {
            nextStop[0] = (lastStop[0] == Maze.MAZE_SIZE -1) ? 0 : lastStop[0] +1;
        }
        return nextStop;
    }

    public void moveLocation (int locX, int locY, String name){

        cells[locX][locY] = name.substring(0,1);
        resetSearchedCells(name);
    }

    public void resetSearchedCells(String  name){

        for(var row : cells){
            Arrays.asList(row).replaceAll(
                    c -> c.equals("!" + name.charAt(0)) ? "" : c);
        }
    }

    public boolean searchCell(String partner, int[] nextStop, int[] lastStop){
        if(cells[nextStop[0]][nextStop[1]].equals(partner.substring(0,1))){
            return true;
        }
        cells[lastStop[0]][lastStop[1]] = "!" + partner.charAt(0);
        return false;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(cells);
    }
}
