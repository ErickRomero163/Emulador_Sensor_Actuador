/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.actuadores;

import simulador_invernadero.model.Clima;

/**
 *
 * @author Ariadna
 */
public abstract class ActuadorBase implements Actuador {

   protected boolean activo;

    @Override
    public void activar() {

        activo = true;

        System.out.println(
                getNombre()
                + " ACTIVADO"
        );
    }

    @Override
    public void desactivar() {

        activo = false;

        System.out.println(
                getNombre()
                + " DESACTIVADO"
        );
    }

    @Override
    public boolean isActivo() {
        return activo;
    }
}