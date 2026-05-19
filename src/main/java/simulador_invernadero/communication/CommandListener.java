package simulador_invernadero.communication;

import simulador_invernadero.dto.ComandoDTO;
import simulador_invernadero.qeue.CommandQueue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommandListener {

    private final CommandQueue queue;

    private final ObjectMapper mapper =
            new ObjectMapper();

    public CommandListener(
            CommandQueue queue
    ) {
        this.queue = queue;
    }

    public void onMessage(
            String payload
    ) {

        try {

            JsonNode json =
                    mapper.readTree(payload);

            String actuador =
                    json.get("actuador")
                            .asText();

            String accion =
                    json.get("accion")
                            .asText();

            ComandoDTO comando =
                    new ComandoDTO(
                            actuador,
                            accion
                    );

            queue.agregar(comando);

            System.out.println(
                    "[MQTT] Comando recibido -> "
                            + payload
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}