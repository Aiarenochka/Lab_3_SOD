package main;

import main.controller.Controller;

public class Main {
    private final Controller controller = new Controller();
    public static void main(String[] args){
        new Main().run();
    }

    private void run() {
        controller.controller();
    }
}