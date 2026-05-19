/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.actuadores;

/**
 *
 * @author Ariadna
 */
public interface Actuador {
void activar();

    void desactivar();

    boolean isActivo();

    String getNombre();
}