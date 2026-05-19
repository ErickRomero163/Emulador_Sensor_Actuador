/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.communication;

import simulador_invernadero.actuadores.Actuador;
import simulador_invernadero.actuadores.ActuadorManager;
import simulador_invernadero.dto.ComandoDTO;

/**
 *
 * @author Ariadna
 */
public class CommandHandler {

    private final ActuadorManager manager;

    public CommandHandler(
            ActuadorManager manager
    ) {
        this.manager = manager;
    }

    public void procesar(
            ComandoDTO comando
    ) {

        Actuador actuador =
                manager.getActuador(
                        comando.getActuador()
                );

        if (actuador == null) {

            System.out.println(
                    "Actuador no encontrado"
            );

            return;
        }

        if (
                comando.getAccion()
                        .equalsIgnoreCase("ON")
        ) {

            actuador.activar();

        } else {

            actuador.desactivar();
        }
    }
}