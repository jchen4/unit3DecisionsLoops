import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the grid of Actors that maintains the state of the game (alive cells contains actors; dead cells do not)
    private BoundedGrid<Actor> grid;
   
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;

    // the game board will have 10 rows and 10 columns
    private final int ROWS = 75;
    private final int COLS = 75;
    
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife() throws InterruptedException
    {
        // create the grid, of the specified size, that contains Actors
        grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();

    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame() throws InterruptedException
    {
        // create and add rocks (a type of Actor) to the thirty-something intial locations
        grid.put(new Location(6, 1), new Rock());        
        grid.put(new Location(6, 2), new Rock());        
        grid.put(new Location(7, 1), new Rock());
        grid.put(new Location(7, 2), new Rock());

        grid.put(new Location(6, 11), new Rock());              
        grid.put(new Location(7, 11), new Rock());        
        grid.put(new Location(8, 11), new Rock());        
        grid.put(new Location(5, 12), new Rock());
        grid.put(new Location(9, 12), new Rock());        
        grid.put(new Location(10, 14), new Rock());       
        grid.put(new Location(10, 13), new Rock());        
        grid.put(new Location(4, 14), new Rock());        
        grid.put(new Location(4, 13), new Rock());        
        grid.put(new Location(7, 15), new Rock());        
        grid.put(new Location(5, 16), new Rock());        
        grid.put(new Location(9, 16), new Rock());        
        grid.put(new Location(6, 17), new Rock());       
        grid.put(new Location(7, 17), new Rock());        
        grid.put(new Location(8, 17), new Rock());        
        grid.put(new Location(7, 18), new Rock());
       
        grid.put(new Location(4, 21), new Rock());
        grid.put(new Location(5, 21), new Rock());
        grid.put(new Location(6, 21), new Rock());
        grid.put(new Location(4, 22), new Rock());
        grid.put(new Location(5, 22), new Rock());
        grid.put(new Location(6, 22), new Rock());       
        grid.put(new Location(3, 23), new Rock());
        grid.put(new Location(7, 23), new Rock());
        grid.put(new Location(2, 25), new Rock());
        grid.put(new Location(3, 25), new Rock());
        grid.put(new Location(7, 25), new Rock());
        grid.put(new Location(8, 25), new Rock());
        
        grid.put(new Location(4, 36), new Rock());
        grid.put(new Location(5, 36), new Rock());
        grid.put(new Location(4, 35), new Rock());
        grid.put(new Location(5, 35), new Rock());
        
        
        for (int i = 0; i <= 1000; i++)
        {
            this.createNextGeneration();
            Thread.sleep(100);
            world.show();
        }
    }

    /**
     * Returns the actor at the specified row and column from grid. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = this.world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }

    /**
     * creates and removes actors according to the rules of Conway's game of life
     */
    public  void createNextGeneration()
    {
        // create the grid of specified size, that contains actors
        Grid<Actor> grid = world.getGrid();
        BoundedGrid<Actor> grid2 = new BoundedGrid<Actor>(ROWS, COLS);
        for (int r = 0; r < ROWS; r ++)
        {
            for (int c = 0; c < COLS; c++)
            {
                Location loca = new Location(r, c);
                int neighbors = grid.getOccupiedAdjacentLocations(loca).size();
                if (neighbors ==  3 && this.getActor(r, c) == null)
                {
                    Rock rock5 = new Rock();
                    grid2.put(loca, rock5);
                }
                if (this.getActor(r, c) != null && (neighbors == 3 || neighbors == 2))
                {
                    Rock rock4 = new Rock();
                    grid2.put(loca, rock4);
                }
            }
        }
        world.setGrid(grid2);
    }

    /**
    * Creates an instance of this class. Provides convenient execution.
    *
    */
    public static void main(String[] args) throws InterruptedException
    {
        GameOfLife game = new GameOfLife();
    }

}



