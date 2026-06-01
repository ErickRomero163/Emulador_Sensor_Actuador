/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.model;

import simulador_invernadero.actuadores.ActuadorManager;
import simulador_invernadero.config.Config;
import simulador_invernadero.util.RandomUtils;

/**
 *
 * @author Ariadna
 */
public class Clima {

    // 🔥 Estado actual
    public double temperatura = 27;
    public double humedad = 45;
    public double luz = 65;
    public double co2 = 500;

    // 🔥 Objetivos temporales del clima
    private double objetivoTemperatura = 35;
    private double objetivoHumedad = 30;
    private double objetivoLuz = 95;
    private double objetivoCO2 = 800;

    // 🔥 Contador de ciclos
    private int ciclos = 0;

    public void evolucionar() {

        ciclos++;

        // 🔥 Cada 8 ciclos se generan nuevos objetivos
//        if (ciclos % 8 == 0) {
//
//            objetivoTemperatura = RandomUtils.rango(15, 35);
//
//            objetivoHumedad = RandomUtils.rango(30, 80);
//
//            objetivoLuz = RandomUtils.rango(40, 100);
//
//            objetivoCO2 = RandomUtils.rango(350, 800);
//
//            System.out.println("\n🌦 NUEVOS OBJETIVOS CLIMÁTICOS");
//            System.out.println(
//                "Temp Obj: " + String.format("%.2f", objetivoTemperatura) +
//                " | Humedad Obj: " + String.format("%.2f", objetivoHumedad) +
//                " | Luz Obj: " + String.format("%.2f", objetivoLuz) +
//                " | CO2 Obj: " + String.format("%.2f", objetivoCO2)
//            );
//        }

        // 🔥 Movimiento GRADUAL hacia objetivos

        temperatura = moverGradual(
            temperatura,
            objetivoTemperatura,
            0.6
        );

        humedad = moverGradual(
            humedad,
            objetivoHumedad,
            0.5
        );

        luz = moverGradual(
            luz,
            objetivoLuz,
            1.5
        );

        co2 = moverGradual(
            co2,
            objetivoCO2,
            5
        );

        // 🔥 Límites de seguridad
        temperatura = limitar(
            temperatura,
            Config.TEMP_MIN,
            Config.TEMP_MAX
        );

        humedad = limitar(humedad, 0, 100);

        luz = limitar(luz, 0, 100);

        co2 = limitar(co2, 300, 1000);
    }

    // 🔥 Movimiento suave hacia objetivo
    private double moverGradual(
        double actual,
        double objetivo,
        double velocidad
    ) {

        if (actual < objetivo) {

            actual += RandomUtils.rango(
                0.1,
                velocidad
            );

        } else if (actual > objetivo) {

            actual -= RandomUtils.rango(
                0.1,
                velocidad
            );
        }

        return actual;
    }

    // 🔥 Limitar valores
    private double limitar(
        double valor,
        double min,
        double max
    ) {

        if (valor < min) {
            return min;
        }

        if (valor > max) {
            return max;
        }

        return valor;
    }
    
    public void aplicarActuadores(
        ActuadorManager manager
) {

    if (
        manager.getActuador(
            "VENTILADOR"
        ).isActivo()
    ) {

        temperatura -= 0.4;
    }

    if (
        manager.getActuador(
            "BOMBA"
        ).isActivo()
    ) {

        humedad += 0.8;
    }

    if (
        manager.getActuador(
            "EXTRACTOR"
        ).isActivo()
    ) {

        co2 -= 8;
    }

    if (
        manager.getActuador(
            "LUZ"
        ).isActivo()
    ) {

        luz += 1.2;
    }

    if (
        manager.getActuador(
            "MALLA"
        ).isActivo()
    ) {

        luz -= 2;
    }
}

    public double getTemperatura() {
        return temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public double getLuz() {
        return luz;
    }

    public double getCo2() {
        return co2;
    }

    
    
}