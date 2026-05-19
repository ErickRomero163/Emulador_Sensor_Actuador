/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.actuadores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ariadna
 */

public class ActuadorManager {


    private final Map<String, Actuador> actuadores =
            new HashMap<>();

    public ActuadorManager() {

        registrar(
                new ActuadorVentilador()
        );

        registrar(
                new ActuadorBomba()
        );

        registrar(
                new ActuadorExtractor()
        );

        registrar(
                new ActuadorLuz()
        );

        registrar(
                new ActuadorMalla()
        );
    }

    private void registrar(
            Actuador actuador
    ) {

        actuadores.put(
                actuador.getNombre(),
                actuador
        );
    }

    public Actuador getActuador(
            String nombre
    ) {

        return actuadores.get(nombre);
    }
}
