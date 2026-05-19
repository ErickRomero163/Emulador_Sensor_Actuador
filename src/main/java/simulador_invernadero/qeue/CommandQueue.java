package simulador_invernadero.qeue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import simulador_invernadero.dto.ComandoDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author erick
 */
public class CommandQueue {
    private final BlockingQueue<ComandoDTO> queue =
            new LinkedBlockingQueue<>();

    public void agregar(
            ComandoDTO comando
    ) {

        try {

            queue.put(comando);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public ComandoDTO obtener() {

        try {

            return queue.take();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        return null;
    }

    public boolean tieneComandos() {
        return !queue.isEmpty();
    }
}
