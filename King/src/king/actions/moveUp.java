package king.actions;
import king.pos.position;

public class moveUp {
    int posX, posY;
    int lastX, lastY;
    boolean answer;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void move(String[][] mapa, position pos)
    {
        if (isSomethingUp(mapa, pos)==false) {
            this.posX = pos.getPosX() - 1;
            this.posY = pos.getPosY();
            this.lastX = pos.getPosX();
            this.lastY = pos.getPosY();


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

        if (mapa[posX][posY].equals("[ ]")) {
            this.answer=false;
        } else {
            this.answer=true;
        }
        return answer;
    }
    //public boolean isOreUp()
    //{
    //    this.posX = pos.getPosX();
    //    this.posY = pos.getPosY();

    //    if (map.map[posX-1][posY].equals("[I]") || map.map[posX-1][posY].equals("[G]") || map.map[posX-1][posY].equals("[D]")) {
    //        this.answer=true;
    //    } else {
    //        this.answer=false;
    //    }
    //    return answer;
    //}
}
