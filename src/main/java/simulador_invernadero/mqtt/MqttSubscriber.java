/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import simulador_invernadero.communication.CommandListener;

/**
 *
 * @author erick
 */
public class MqttSubscriber {
       private final MqttClient client;

    public MqttSubscriber(
            CommandListener listener
    ) throws Exception {

        client = new MqttClient(
                MqttConfig.BROKER,
                "subscriber-" +
                MqttConfig.CLIENT_ID
        );

        MqttConnectOptions options =
                new MqttConnectOptions();

        options.setAutomaticReconnect(true);

        options.setCleanSession(true);

        client.connect(options);

        client.subscribe(
                MqttConfig.TOPIC_COMANDOS,
                (topic, message) -> {

                    String payload =
                            new String(
                                    message.getPayload()
                            );

                    listener.onMessage(payload);
                }
        );

        System.out.println(
                "[MQTT] Escuchando comandos..."
        );
    }
}
