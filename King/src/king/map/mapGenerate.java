package king.map;

import java.util.ArrayList;
import king.pos.position;

public class mapGenerate {

    int size,orbs,posX,posY;
    String orb_id = null,orb_name = null;
    public String[][] map;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public void setSize(int x)
    {
        this.size = x;

        this.map = new String[x+2][x+2];

        for (int i=0;i<this.size+2;i++)
        {
            for (int j=0;j<this.size+2;j++)
            {
                if (i==0 || i==this.size-1 || j==0 || j==this.size-1) {
                    map[i][j] = "[+]";
                }
                else {
                    map[i][j] = "[ ]";
                }
            }
        }
    }
    public void setPlayer(position pos)
    {
        this.posX = (int) (Math.random() * this.size);
        this.posY = (int) (Math.random() * this.size);
        for (int I=0;I<this.size;I++)
        {
            for (int J=0;J<this.size;J++)
            {
                if (map[I][J].equals("[+]") ||map[I][J].equals(ANSI_CYAN+"[D]"+ANSI_RESET) || map[I][J].equals(ANSI_GREEN+"[I]"+ANSI_RESET) || map[I][J].equals(ANSI_YELLOW+"[G]"+ANSI_RESET))
                {
                    this.posX = (int) (Math.random() * this.size);
                    this.posY = (int) (Math.random() * this.size);
                }
            }
        }
        pos.setPosition(this.posX,this.posY);
        System.out.println( ANSI_YELLOW+"New player position: "+this.posX + " " + this.posY+ANSI_RESET);
        System.out.println();
        map[this.posX][this.posY] = ANSI_RED+"[#]"+ANSI_RESET;


    }
    public void setOrbs(int x)
    {
        this.orbs = x;

        ArrayList<mapGenerate> orb_list = new ArrayList<>();
        for (int i=0;i<this.orbs;i++)
        {
            boolean isActive = true;
            mapGenerate orb = new mapGenerate();
            int type = (int) (Math.random() * 3);

            if (type == 0) {
                orb.orb_name = "Diamond";
                orb.orb_id = ANSI_CYAN+"[D]"+ANSI_RESET;
            }
            else if (type == 1) {
                orb.orb_name = "Iron";
                orb.orb_id = ANSI_GREEN+"[I]"+ANSI_RESET;
            }
            else if (type == 2) {
                orb.orb_name = "Gold";
                orb.orb_id = ANSI_YELLOW+"[G]"+ANSI_RESET;
            }
            this.posX = (int) (Math.random() * this.size-2)+1;
            this.posY = (int) (Math.random() * this.size-2)+1;


            for (int I=0;I<this.size+2;I++)
            {
                for (int J=0;J<this.size+2;J++)
                {

                    if (map[I][J].equals("[+]") ||map[I][J].equals(ANSI_CYAN+"[D]"+ANSI_RESET) || map[I][J].equals(ANSI_GREEN+"[I]"+ANSI_RESET) || map[I][J].equals(ANSI_YELLOW+"[G]"+ANSI_RESET))
                    {
                        this.posX = (int) (Math.random() * this.size-2) +1;
                       this.posY = (int) (Math.random() * this.size-2) +1;
                    }
                }
            }

            map[posX][posY] = orb.orb_id;

            orb_list.add(orb);
        }
    }
    public void getMap(position pos,int level)
    {

        System.out.println(ANSI_YELLOW+"King version 1.7 "+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"Author: Mateusz Aftanas "+ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_CYAN+"Level: "+level+ANSI_RESET);
        System.out.println();

        for (int i=0;i<this.size;i++)
        {
            for (int j=0;j<this.size;j++)
            {
                System.out.print(map[i][j]);
                if (j==(this.size-1))
                {
                    System.out.print("\n");
                }
            }
        }
        int x = pos.getPosX();
        int y = pos.getPosY();
        map[x][y] = ANSI_RED+"[#]"+ANSI_RESET;
        //System.out.println(x + " " + y);
    }

    public String toString()
    {
        return "Orb " + this.orb_id + "\n" + "Pos: X:" + this.posX + " Y:" + this.posY;
    }
}
