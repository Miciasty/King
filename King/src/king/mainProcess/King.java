package king.mainProcess;

import king.actions.moveDown;
import king.map.mapGenerate;
import king.actions.moveUp;
import king.actions.moveLeft;
import king.actions.moveRight;
import king.actions.mineUp;
import king.pos.position;
import king.pos.equipment;
import king.actions.build;

import java.io.PrintStream;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.Scanner;
import java.util.logging.Level;


public class King {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {

        int level=1;
        boolean Loop = true;

        while (Loop) {
            mapGenerate map = new mapGenerate();
            moveUp moveUp = new moveUp();
            moveDown moveDown = new moveDown();
            moveLeft moveLeft = new moveLeft();
            moveRight moveRight = new moveRight();
            mineUp mineUp = new mineUp();
            build build = new build();

            Scanner scan = new Scanner(System.in);

            PrintStream out = new PrintStream(System.out, true, UTF_8);

            position pos = new position();
            pos.setPosition(0,0);
            equipment eq = new equipment();
            eq.SetEquipment(0,0,0);

            boolean isActive = true;

            int NextLvl_Diamonds = (int) (Math.random() * (10-1))+1;
            int NextLvl_Golds = (int) (Math.random() * (10-1))+1;

            // Step 0: Screen Clear
            out.print("\033\143"); // -- clean screen

            // Step 1: Map Generate and Player position
            map.setSize(14);                 // -- set map size
            map.setOrbs(80);                // -- set orbs number
            map.setPlayer(pos);            // -- set Player position
            map.getMap(pos,level);        // -- show map

            out.println();
            out.println(ANSI_RED+"To next level: "+ANSI_RESET+NextLvl_Diamonds+ANSI_RED+" Diamonds.");
            out.println(ANSI_RED+"To next level: "+ANSI_RESET+NextLvl_Golds+ANSI_RED+" Golds.");
            out.println();
            out.println();
            out.println(ANSI_GREEN+"1. To move player "+ANSI_RED+"[#]"+ANSI_GREEN+" use 'w','a','s','d'.");
            out.println("2. To mine ore use 'mine', ore have to be above you.");
            out.println("3. To check your inventory use 'showEq'.");
            out.println("4. To build use 'build', and next use 'w','a','s','d' to choose position you want to move."+ANSI_RESET);
            out.println(ANSI_YELLOW+"5. Use 'help' to show this information."+ANSI_GREEN);
            out.println();

            while (isActive)
            {
                String movement = scan.nextLine();
                if (movement.equals("w")) {
                    System.out.print("\033\143"); // -- clean screen
                    moveUp.move(map.map,pos);
                    eq.WhatNeed(NextLvl_Diamonds,NextLvl_Golds);
                    map.getMap(pos,level);
                }
                else if (movement.equals("s")) {
                    System.out.print("\033\143"); // -- clean screen
                    moveDown.move(map.map,pos);
                    eq.WhatNeed(NextLvl_Diamonds,NextLvl_Golds);
                    map.getMap(pos,level);
                }
                else if (movement.equals("a")) {
                    System.out.print("\033\143"); // -- clean screen
                    moveLeft.move(map.map,pos);
                    eq.WhatNeed(NextLvl_Diamonds,NextLvl_Golds);
                    map.getMap(pos,level);
                }
                else if (movement.equals("d")) {
                    System.out.print("\033\143"); // -- clean screen
                    moveRight.move(map.map,pos);
                    eq.WhatNeed(NextLvl_Diamonds,NextLvl_Golds);
                    map.getMap(pos,level);
                }
                else if (movement.equals("mine")) {
                    System.out.print("\033\143"); // -- clean screen
                    mineUp.move(map.map,pos,eq);
                    eq.WhatNeed(NextLvl_Diamonds,NextLvl_Golds);
                    map.getMap(pos,level);
                }
                else if (movement.equals("build")) {
                    build.move(map.map,pos,eq);
                    eq.WhatNeed(NextLvl_Diamonds,NextLvl_Golds);
                    map.getMap(pos,level);
                }
                else if (movement.equals("showEq")) {
                    eq.GetEquipment();
                }
                else if (movement.equals("help")) {
                    System.out.print("\033\143"); // -- clean screen
                    out.println();
                    out.println(ANSI_GREEN+"1. To move player "+ANSI_RED+"[#]"+ANSI_GREEN+" use 'w','a','s','d'.");
                    out.println("2. To mine ore use 'mine', ore have to be above you.");
                    out.println("3. To check your inventory use 'showEq'.");
                    out.println("4. To build use 'build', and next use 'w','a','s','d' to choose position you want to move."+ANSI_RESET);
                    out.println(ANSI_YELLOW+"5. Use 'help' to show this information."+ANSI_GREEN);
                    map.getMap(pos,level);
                }
                else if (movement.equals("exit")) {
                    Loop = false;
                    isActive = false;
                }


                if (eq.Diamond>=NextLvl_Diamonds && eq.Gold>=NextLvl_Golds) {
                    level = level+1;
                    isActive = false;
                }
            }
        }
    }
}
