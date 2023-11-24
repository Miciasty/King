package king.actions;

import king.pos.position;
import king.pos.equipment;

import java.io.PrintStream;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class build {
    int posX, posY;
    int lastX, lastY;
    boolean answer;
    String ore;
    Scanner scan = new Scanner(System.in);
    PrintStream out = new PrintStream(System.out, true, UTF_8);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public void move(String[][] mapa, position pos, equipment eq)
    {
        if (eq.Iron>0) {

            String movement = scan.nextLine();

            if (movement.equals("w")) {
                if (isSomething(mapa, pos,movement)==false) {
                    this.posX = pos.getPosX() - 1;
                    this.posY = pos.getPosY();
                    this.lastX = pos.getPosX();
                    this.lastY = pos.getPosY();
                }
            }
            else if (movement.equals("a")) {
                if (isSomething(mapa, pos,movement)==false) {
                    this.posX = pos.getPosX();
                    this.posY = pos.getPosY() - 1;
                    this.lastX = pos.getPosX();
                    this.lastY = pos.getPosY();
                }
            }
            else if (movement.equals("s")) {
                if (isSomething(mapa, pos,movement)==false) {
                    this.posX = pos.getPosX() + 1;
                    this.posY = pos.getPosY() ;
                    this.lastX = pos.getPosX();
                    this.lastY = pos.getPosY();
                }
            }
            else if (movement.equals("d")) {
                if (isSomething(mapa, pos,movement)==false) {
                    this.posX = pos.getPosX();
                    this.posY = pos.getPosY() + 1;
                    this.lastX = pos.getPosX();
                    this.lastY = pos.getPosY();
                }
            }

            eq.Iron -= 1;
            pos.setPosition(this.posX,this.posY);
            mapa[this.lastX][this.lastY] = ANSI_PURPLE+"[x]"+ANSI_RESET;
            mapa[this.posX][this.posY] = ANSI_RED+"[#]"+ANSI_RESET;
            System.out.print("\033\143"); // -- clean screen
        }
        else {
            out.println();
            out.println(ANSI_RED+"You do not have enough iron."+ANSI_RESET);
            out.println();
        }

    }
    public boolean isSomething(String[][] mapa, position pos, String movement)
    {
        if (movement.equals("w")) {
            int x = this.posX = pos.getPosX() - 1;
            int y = this.posY = pos.getPosY();
            System.out.println(x + " " + y);
            //posX=-1;

            if (mapa[posX][posY].equals("[ ]")) {
                this.answer=false;
            } else {
                this.answer=true;
            }
        }
        else if (movement.equals("a")) {
            int x = this.posX = pos.getPosX();
            int y = this.posY = pos.getPosY() - 1;
            System.out.println(x + " " + y);
            //posY=-1;

            if (mapa[posX][posY].equals("[ ]")) {
                this.answer=false;
            } else {
                this.answer=true;
            }
        }
        else if (movement.equals("s")) {
            int x = this.posX = pos.getPosX() + 1;
            int y = this.posY = pos.getPosY();
            System.out.println(x + " " + y);
            //posY=-1;

            if (mapa[posX][posY].equals("[ ]")) {
                this.answer=false;
            } else {
                this.answer=true;
            }
        }
        else if (movement.equals("d")) {
            int x = this.posX = pos.getPosX();
            int y = this.posY = pos.getPosY() + 1;
            System.out.println(x + " " + y);
            //posY=-1;

            if (mapa[posX][posY].equals("[ ]")) {
                this.answer=false;
            } else {
                this.answer=true;
            }
        }

        return answer;
    }
}
