package king.pos;

import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class equipment {

    PrintStream out = new PrintStream(System.out, true, UTF_8);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public int Iron, Gold, Diamond;

    public void WhatNeed(int x, int y)
    {
        PrintStream out = new PrintStream(System.out, true, UTF_8);

        out.println();
        out.println(ANSI_RED+"To next level: "+ANSI_RESET+x+ANSI_RED+" Diamonds.");
        out.println(ANSI_RED+"To next level: "+ANSI_RESET+y+ANSI_RED+" Golds."+ANSI_GREEN);
        out.println();
    }
    public void SetEquipment(int a, int b, int c)
    {
        Iron = a;
        Gold = b;
        Diamond = c;
    }
    public void GetEquipment()
    {
        out.println();
        out.println(ANSI_PURPLE+"Iron Ingots: "+ANSI_RESET+ this.Iron);
        out.println(ANSI_PURPLE+"Gold Ingots: "+ANSI_RESET+ this.Gold);
        out.println(ANSI_PURPLE+"Diamonds: "+ANSI_RESET+ this.Diamond);
    }
    public int AddEquipment(String type) {
        if (type.equals(ANSI_GREEN+"[I]"+ANSI_RESET)) {
            this.Iron+=1;
            out.println(ANSI_PURPLE + "You got 1 new iron ingot!" + ANSI_RESET);
            return this.Iron;
        }
        else if (type.equals(ANSI_YELLOW+"[G]"+ANSI_RESET)) {
            this.Gold+=1;
            out.println(ANSI_PURPLE + "You got 1 new gold ingot!" + ANSI_RESET);
            return this.Gold;
        }
        else if (type.equals(ANSI_CYAN+"[D]"+ANSI_RESET)) {
            this.Diamond+=1;
            out.println(ANSI_PURPLE + "You got 1 new diamond!" + ANSI_RESET);
            return this.Diamond;
        }
        else {
            return 0;
        }
    }
}
