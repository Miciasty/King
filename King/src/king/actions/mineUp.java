package king.actions;

import king.pos.position;
import king.pos.equipment;

public class mineUp {
    int posX, posY;
    int lastX, lastY;
    boolean answer;
    String ore;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public void move(String[][] mapa, position pos, equipment eq)
    {
        if (isSomethingUp(mapa, pos)==true) {
            this.posX = pos.getPosX() - 1;
            this.posY = pos.getPosY();
            this.lastX = pos.getPosX();
            this.lastY = pos.getPosY();

            eq.AddEquipment(ore);

            pos.setPosition(this.posX,this.posY);
            mapa[this.lastX][this.lastY] = "[ ]";
            mapa[this.posX][this.posY] = ANSI_RED+"[#]"+ANSI_RESET;
        }
    }
    public boolean isSomethingUp(String[][] mapa, position pos)
    {
        int x = this.posX = pos.getPosX() - 1;
        int y = this.posY = pos.getPosY();
        System.out.println(x + " " + y);
        //posX=-1;

        if (mapa[posX][posY].equals(ANSI_CYAN+"[D]"+ANSI_RESET) || mapa[posX][posY].equals(ANSI_GREEN+"[I]"+ANSI_RESET) || mapa[posX][posY].equals(ANSI_YELLOW+"[G]"+ANSI_RESET)) {
            ore = mapa[posX][posY];
            this.answer=true;
        } else {
            this.answer=false;
        }
        return answer;
    }
}
