/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.mqtt;

/**
 *
 * @author erick
 */
import org.eclipse.paho.client.mqttv3.*;
import simulador_invernadero.dto.LecturaDTO;

public class MqttPublisher {
    private final MqttClient client;

    public MqttPublisher() throws MqttException {

        client = new MqttClient(
                MqttConfig.BROKER,
                MqttConfig.CLIENT_ID
        );

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);

        client.connect(options);

        System.out.println("[MQTT] Conectado al broker");
    }

    public void publish(LecturaDTO lectura) {

        try {

            String payload = lectura.toString();

            MqttMessage message = new MqttMessage(
                    payload.getBytes()
            );

            message.setQos(MqttConfig.QOS);

            client.publish(
                    MqttConfig.TOPIC_SENSORES,
                    message
            );

            System.out.println("[MQTT] Publicado -> " + payload);

        } catch (Exception e) {
            System.out.println("[MQTT] Error publicando");
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
