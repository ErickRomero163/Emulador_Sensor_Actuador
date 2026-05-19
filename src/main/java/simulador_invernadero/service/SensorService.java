/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.service;

import java.util.ArrayList;
import java.util.List;
import simulador_invernadero.dto.LecturaDTO;
import simulador_invernadero.model.Clima;
import simulador_invernadero.sensores.SensorCO2;
import simulador_invernadero.sensores.SensorHumedad;
import simulador_invernadero.sensores.SensorLuminosidad;
import simulador_invernadero.sensores.SensorTemperatura;

/**
 *
 * @author Ariadna
 */
public class SensorService {
    private final SensorTemperatura sensorTemperatura;
    private final SensorLuminosidad sensorLuminosidad;
    private final SensorHumedad sensorHumedad;

    private final SensorCO2 sensorCO2;

    public SensorService(Clima clima) {

        sensorTemperatura = new SensorTemperatura(clima);        
        sensorLuminosidad = new SensorLuminosidad(clima);
        sensorHumedad= new SensorHumedad(clima);
        sensorCO2 = new SensorCO2(clima);
    }

    public List<LecturaDTO> leerSensores() {

        List<LecturaDTO> lecturas = new ArrayList<>();

        lecturas.add(
                new LecturaDTO(1L, sensorTemperatura.leer())
        );

        lecturas.add(
                new LecturaDTO(2L, sensorLuminosidad.leer())
        );

        lecturas.add(
                new LecturaDTO(3L, sensorCO2.leer())
        );
        
        lecturas.add(
                new LecturaDTO(4L, sensorHumedad.leer())
        );

        return lecturas;
    }
}
