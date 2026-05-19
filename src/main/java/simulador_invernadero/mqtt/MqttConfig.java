/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_invernadero.mqtt;

/**
 *
 * @author erick
 */
public class MqttConfig {
//    public static final String BROKER = "tcp://localhost:1883";
//
//    public static final String CLIENT_ID = "EMULADOR_1";
//
//    public static final String TOPIC_SENSORES = "invernadero/1/sensores";
//
//    public static final int QOS = 1;
//
//    private MqttConfig() {}
        public static final String BROKER =
            "tcp://localhost:1883";

    public static final String CLIENT_ID =
            "emulador-1";

    public static final String TOPIC_SENSORES =
            "invernadero/1/sensores";

    public static final String TOPIC_COMANDOS =
            "invernadero/1/comandos";

    public static final int QOS = 1;

    private MqttConfig() {}
}
