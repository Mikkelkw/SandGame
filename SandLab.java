import java.awt.*;
import java.util.*;
import java.util.Random;
public class SandLab
{
  //Step 4,6
  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER=3;
  public static final int ACID=4;
  public static final int GASS=5;
  public static final int CLEAR=6;
  
  //do not add any more fields below
  private int[][] grid;
  private SandDisplay display;
  
  
  Random rand = new Random();
  int r = rand.nextInt(2);

  
  
  /**
   * Constructor for SandLab
   * @param numRows The number of rows to start with
   * @param numCols The number of columns to start with;
   */
  public SandLab(int numRows, int numCols)
  {
    String[] names;
    // Change this value to add more buttons
    //Step 4,6
    names = new String[6];
    // Each value needs a name for the button
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER]="Water";
    names[ACID]="Acid";
    names[GASS]="Gass";
   
    
    grid=new int [numRows][numCols];

    
    //1. Add code to initialize the data member grid with same dimensions
    
    
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
  }
  
  //called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool)
  {
	  grid[row][col]=tool;
   
  }

  //copies each element of grid into the display
  public void updateDisplay()
  {
      //Step 3
   //Hint - use a nested for loop
	  for (int r
			  =0; r<grid.length; r++)
	  {
		for(int c=0;c<grid.length;c++)
		{
			if (grid[r][c]==METAL)
			{
				display.setColor(r, c, Color.GRAY);
			}
			else if(grid[r][c]==EMPTY)
			{
				display.setColor(r, c, Color.BLACK);
			}
			else if (grid[r][c]==SAND)
			{
				display.setColor(r, c, Color.YELLOW);
			}
			else if (grid[r][c]==WATER)
			{
				display.setColor(r,c, Color.BLUE);
			}
			else if(grid[r][c]==ACID)
			{
				display.setColor(r, c, Color.GREEN);
			}
			else if(grid[r][c]==GASS)
			{
				display.setColor(r, c, Color. LIGHT_GRAY);
			}
			else if(grid[r][c]==CLEAR)
			{
				display.setColor(r, c, Color.BLACK);
			}
		}
		 
	  }
    
  }

  //Step 5,7
  //called repeatedly.
  //causes one random particle in grid to maybe do something.
  public void step()
  {
	  
    //Remember, you need to access both row and column to specify a spot in the array
    //The scalar refers to how big the value could be
    int randomR = (int) (Math.random() * grid.length);
    int randomC=(int)(Math.random()*grid[0].length);
    
    if (randomR+1<grid.length && grid[randomR][randomC]==SAND && grid[randomR+1][randomC]==EMPTY)
    {
    	grid[randomR+1][randomC]=SAND;
    	grid[randomR][randomC]=EMPTY;
    }
    else if (randomR+1<grid.length&& randomC>0 &&grid[randomR][randomC]==WATER && grid[randomR+1][randomC]==EMPTY && randomC > -1)
    {
    	grid[randomR][randomC]=EMPTY;
    	grid[randomR+1][randomC]=WATER;
    }
    else if (rand.nextInt(2) == 0 &&randomC>0 &&grid[randomR][randomC]==WATER && grid[randomR][randomC-1]==EMPTY)
    {
    	grid[randomR][randomC-1]=WATER;
    	grid[randomR][randomC]=EMPTY;
    }
    else if (rand.nextInt(2) == 1 && randomC < grid[0].length -1 && randomC<grid.length &&grid[randomR][randomC]==WATER && grid[randomR][randomC+1]==EMPTY)
    {
    	grid[randomR][randomC+1]=WATER;
    	grid[randomR][randomC]=EMPTY;
    }
    // ACID
    
    else if (randomR+1<grid.length&& randomC>0 &&grid[randomR][randomC]==ACID && grid[randomR+1][randomC]==EMPTY && randomC > -1)
    {
    	grid[randomR][randomC]=EMPTY;
    	grid[randomR+1][randomC]=ACID;
    }
    else if (rand.nextInt(2) == 0 &&randomC>0 &&grid[randomR][randomC]==ACID && grid[randomR][randomC-1]==EMPTY)
    {
    	grid[randomR][randomC-1]=ACID;
    	grid[randomR][randomC]=EMPTY;
    }
    else if (rand.nextInt(2) == 1 && randomC < grid[0].length -1 && randomC<grid.length &&grid[randomR][randomC]==ACID && grid[randomR][randomC+1]==EMPTY)
    {
    	grid[randomR][randomC+1]=ACID;
    	grid[randomR][randomC]=EMPTY;
    }
    //m
    else if (randomR+1<grid.length&& randomC>0 &&grid[randomR][randomC]==ACID && grid[randomR+1][randomC]==METAL && randomC > -1)
    {
    	grid[randomR][randomC]=EMPTY;
    	grid[randomR+1][randomC]=ACID;
    }
    else if (rand.nextInt(2) == 0 &&randomC>0 &&grid[randomR][randomC]==ACID && grid[randomR][randomC-1]==METAL)
    {
    	grid[randomR][randomC-1]=ACID;
    	grid[randomR][randomC]=EMPTY;
    }
    else if (rand.nextInt(2) == 1 && randomC < grid[0].length -1 && randomC<grid.length &&grid[randomR][randomC]==ACID && grid[randomR][randomC+1]==METAL)
    {
    	grid[randomR][randomC+1]=ACID;
    	grid[randomR][randomC]=EMPTY;
    }
// w
    else if (randomR+1<grid.length&& randomC>0 &&grid[randomR][randomC]==ACID && grid[randomR+1][randomC]==WATER && randomC > -1)
    {
    	grid[randomR][randomC]=EMPTY;
    	grid[randomR+1][randomC]=ACID;
    }
    else if (rand.nextInt(2) == 0 &&randomC>0 &&grid[randomR][randomC]==ACID && grid[randomR][randomC-1]==WATER)
    {
    	grid[randomR][randomC-1]=ACID;
    	grid[randomR][randomC]=EMPTY;
    }
    else if (rand.nextInt(2) == 1 && randomC < grid[0].length -1 && randomC<grid.length &&grid[randomR][randomC]==ACID && grid[randomR][randomC+1]==WATER)
    {
    	grid[randomR][randomC+1]=ACID;
    	grid[randomR][randomC]=EMPTY;
    }
    //s
    else if (randomR+1<grid.length&& randomC>0 &&grid[randomR][randomC]==ACID && grid[randomR+1][randomC]==SAND && randomC > -1)
    {
    	grid[randomR][randomC]=EMPTY;
    	grid[randomR+1][randomC]=ACID;
    }
    else if (rand.nextInt(2) == 0 &&randomC>0 &&grid[randomR][randomC]==ACID && grid[randomR][randomC-1]==SAND)
    {
    	grid[randomR][randomC-1]=ACID;
    	grid[randomR][randomC]=EMPTY;
    }
    else if (rand.nextInt(2) == 1 && randomC < grid[0].length -1 && randomC<grid.length &&grid[randomR][randomC]==ACID && grid[randomR][randomC+1]==SAND)
    {
    	grid[randomR][randomC+1]=ACID;
    	grid[randomR][randomC]=EMPTY;
    }
    
    //GASS
    
    if (randomR > 0 && randomR+1<grid.length&& randomC>0 &&grid[randomR][randomC]==GASS && grid[randomR-1][randomC]==EMPTY && randomC > -1)
    {
    	grid[randomR][randomC]=EMPTY;
    	grid[randomR-1][randomC]=GASS;
    }
    else if (rand.nextInt(2) == 0 &&randomC>0 &&grid[randomR][randomC]==GASS && grid[randomR][randomC-1]==EMPTY)
    {
    	grid[randomR][randomC-1]=GASS;
    	grid[randomR][randomC]=EMPTY;
    }
    else if (rand.nextInt(2) == 1 && randomC < grid[0].length -1 && randomC<grid.length &&grid[randomR][randomC]==GASS && grid[randomR][randomC+1]==EMPTY)
    {
    	grid[randomR][randomC+1]=GASS;
    	grid[randomR][randomC]=EMPTY;
    }
    
    if (randomR > 0 && randomR+1<grid.length&& randomC>0 &&grid[randomR][randomC]==GASS && grid[randomR-1][randomC]==WATER && randomC > -1)
    {
    	grid[randomR][randomC]=EMPTY;
    }
    else if (rand.nextInt(2) == 0 &&randomC>0 &&grid[randomR][randomC]==GASS && grid[randomR][randomC-1]==WATER)
    {
    	grid[randomR][randomC]=EMPTY;
    }
    else if (rand.nextInt(2) == 1 && randomC < grid[0].length -1 && randomC<grid.length &&grid[randomR][randomC]==GASS && grid[randomR][randomC+1]== WATER)
    {
    	grid[randomR][randomC]=EMPTY;
    }
    //Clear
   
    
   
    
    
    //remember that you need to watch for the edges of the array
    
    
  }
  
  //do not modify this method!
  public void run()
  {
    while (true) // infinite loop
    {
      for (int i = 0; i < display.getSpeed(); i++)
      {
        step();
      }
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  //test if mouse clicked
      {
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
      }
    }
  }
}
