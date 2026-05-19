/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.sensores;

import simulador_invernadero.model.Clima;

/**
 *
 * @author Ariadna
 */
public class SensorCO2 implements Sensor {

    private Clima clima;

    public SensorCO2(Clima clima) {
        this.clima = clima;
    }

    @Override
    public double leer() {
        return clima.co2;
    }
}
