/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.dto;

/**
 *
 * @author Ariadna
 */
public class LecturaDTO {
private Long idInvSensor;
    private Double valor;

    public LecturaDTO() {}

    public LecturaDTO(Long idInvSensor, Double valor) {
        this.idInvSensor = idInvSensor;
        this.valor = valor;
    }

    public Long getIdInvSensor() {
        return idInvSensor;
    }

    public void setIdInvSensor(Long idInvSensor) {
        this.idInvSensor = idInvSensor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" +
                "\"idInvSensor\":" + idInvSensor + "," +
                "\"valor\":" + valor +
                "}";
    }

}
