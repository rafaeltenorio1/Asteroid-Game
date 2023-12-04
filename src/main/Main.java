package main;

import main.asteroid.Asteroid;
import main.engine.*;

import java.io.IOException;


public class  Main{

    public static void main(String[] args) throws IOException {
        Engine engine = new Engine();

        engine.start(new Asteroid());

    }


}