package xyz.morecraft.dev.xross.torrenter.main;

import xyz.morecraft.dev.xross.torrenter.engine.FileEntry;

public class Main {

    public static void main(String[] args) {

        FileEntry fe1, fe2, fe3, fe4;

        fe1 = new FileEntry("a", "a");
        fe2 = new FileEntry("a", "a");


        System.out.println(fe1.equals(fe2));

    }

}
