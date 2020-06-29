public class Robot {
    private int x;
    private int y;
    private char payload;

    static int rBound = 26;
    static int lBound = 0;
    static int tBound = 0;
    static int bBound = 26;

    public Robot()
    {
        x = 0;
        y = 0;
        payload = '.';

    }

    public Robot(int x1, int y1, char ch)
    {
        x = x1;
        y = y1;
        payload = ch;
    }

    void setX(int x1)
    {
        x = x1;
    }

    int getX()
    {
        return x;
    }

    void setY(int y1)
    {
        y = y1;
    }

    int getY()
    {
        return y;
    }

    void setPayload(char ch1)
    {
        payload = ch1;
    }

    int getPayload()
    {
        return payload;
    }

    public void print()
    {
        System.out.println("Location - ("+x+", "+y+")\nLoad- "+payload);
    }

    boolean pickup(int lx, int ly, char grid[][])
    {
        if( lx != x && ly != y)
        {
            System.out.println("Not a location ("+lx+","+ly+")");
            return false;
        }

        if(grid[lx][ly]=='.')
        {
            System.out.println("No load at this location");
            return false;
        }

        if(payload == '.')
        {
            payload = grid[lx][ly];
            grid[lx][ly] = '.';
            return true;
        }

        return false;
    }

    boolean dropoff(int lx, int ly, char grid[][])
    {
        if(lx!=x && ly!=y)
        {
            System.out.println("Not at location ("+lx+","+ly+")");
            return false;
        }

        if(grid[lx][ly]!='.')
        {
            System.out.println(" Load at this location");
            return false;
        }

        if(payload!='.')
        {
            grid[lx][ly] = payload;
            payload = '.';
            return true;
        }

        return false;
    }

    void moveRight()
    {
        y = y+1;
        if(y == 26)
        {
            System.out.println("Right boundary reached");
        }
    }

    void moveLeft()
    {
        y = y-1;
        if(y==0)
        {
            System.out.println("Left boundary reached");
        }
    }

    void moveUp()
    {
        x = x-1;
        if(x == 0)
        {
            System.out.println("Top boundary reached");
        }
    }
    
    void moveDown()
    {
        x = x+1;
        if(x == 26)
        {
            System.out.println("Bottom boundary reached");
        }
    }

    boolean MoveTo(int lx, int ly)
    {
        if(0 <= lx && lx < 26 && 0 <= ly && ly < 26)
        {
            while(lx<x)
            {
                moveUp();
            }

            while(lx>x)
            {
                moveDown();
            }

            while(ly<y)
            {
                moveLeft();
            }

            while(ly>y)
            {
                moveRight();
            }

            return true;
        }

        System.out.println("invalid Location");
        return false;
    }

    public static void Print2D(char grid[][])
    {
        int i;
        int j;

        for(i = tBound ; i < bBound; i++)
        {
            for (j = lBound; j < rBound; j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main (String args[])
    {
        char grid[][] = new char [26][26];
        int i;
        int j;

        for (i = tBound; i < bBound; i++)
            for (j = lBound; j < rBound; j++)
                grid[i][j] = '.';
        
        
        grid[10][8] = 'B';
        grid[22][4] = 'C';

        Print2D(grid);

        Robot R1 = new Robot();
        System.out.println("\nRobot R1 Starting Location");
        R1.print();

        Robot R2 = new Robot();
        System.out.println("\nRobot R2 Starting Location");
        R2.print();

        R1.MoveTo(23, 24);

        System.out.println("\nRobot R1 First Move");
        R1.print();

        R2.MoveTo(15, 3);

        System.out.println("\nRobot R2 First Move");
        R2.print();

        R1.MoveTo(10, 8);
        R1.pickup(10, 8, grid);
        System.out.println("\nRobot R1 Move To and Pick Up");
        Print2D(grid);
        

        R1.MoveTo(20, 20);
        R1.dropoff(20, 20, grid);
        System.out.println("\nRobot R1 Move To and Drop Off");
        R1.print();
        Print2D(grid);
        
        
        R2.MoveTo(22, 4);
        R2.pickup(22, 4, grid);
        System.out.println("\nRobot R2 Move To and Pick Up\n");
        Print2D(grid);

        System.out.println("\nRobot R2 Move To and Drop Off\n");
        R2.MoveTo(0, 0);
        R2.dropoff(0, 0, grid);
        R2.print();
        Print2D(grid);
    }
}

