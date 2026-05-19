/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero;

/**
 *
 * @author Ariadna
 */

import simulador_invernadero.actuadores.ActuadorManager;
import simulador_invernadero.communication.CommandHandler;
import simulador_invernadero.communication.CommandListener;
import simulador_invernadero.model.Clima;
import simulador_invernadero.mqtt.MqttPublisher;
import simulador_invernadero.mqtt.MqttSubscriber;
import simulador_invernadero.qeue.CommandQueue;
import simulador_invernadero.service.SensorService;
import simulador_invernadero.service.SimulacionService;

public class Main {

     public static void main(String[] args) {

        try {

            Clima clima = new Clima();

            SensorService sensorService =
                    new SensorService(clima);

            MqttPublisher publisher =
                    new MqttPublisher();

            CommandQueue queue =
                    new CommandQueue();

            CommandListener listener =
                    new CommandListener(queue);

            new MqttSubscriber(listener);

            ActuadorManager manager =
                    new ActuadorManager();

            CommandHandler handler =
                    new CommandHandler(manager);

            SimulacionService simulacion =
                    new SimulacionService(
                            clima,
                            sensorService,
                            publisher,
                            queue,
                            handler,
                            manager
                    );

            simulacion.iniciar();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    }

