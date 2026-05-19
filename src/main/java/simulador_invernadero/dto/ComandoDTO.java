/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.dto;

/**
 *
 * @author Ariadna
 */
public class ComandoDTO {

    private String actuador;

    private String accion;

    public ComandoDTO() {}

    public ComandoDTO(
            String actuador,
            String accion
    ) {
        this.actuador = actuador;
        this.accion = accion;
    }

    public String getActuador() {
        return actuador;
    }

    public String getAccion() {
        return accion;
    }

    public void setActuador(String actuador) {
        this.actuador = actuador;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
