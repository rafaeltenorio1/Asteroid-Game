package main;

import main.asteroid.Asteroid;
import main.engine.*;


public class Main{

    public static void main(String[] args){
        Engine engine = new Engine();

        engine.start(new Asteroid());

    }


}