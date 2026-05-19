/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.util;

import java.util.Random;

/**
 *
 * @author Ariadna
 */
public class RandomUtils {

    private static final Random random = new Random();

    public static double rango(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
}
