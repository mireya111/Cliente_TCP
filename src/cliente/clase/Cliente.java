package cliente.clase;

import java.io.*;
import java.net.Socket;

public class Cliente {
    private static final int puerto = 5000;
    //private static final String IP =
    private static final String IP = "192.168.67.73";
    public static String enviarNombre(String nombre, String tipo) throws Exception {
        // Crear un socket cliente
        Socket cliente = new Socket(IP, puerto);
        // Enviar el nombre y el tipo de jornada al servidor
        InputStream in = cliente.getInputStream();
        OutputStream out = cliente.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF(nombre);
        dos.writeUTF(tipo);
        // Leer la respuesta del servidor
        DataInputStream dis = new DataInputStream(in);
        String respuesta = dis.readUTF();
        cliente.close();
        dos.close();
        dis.close();
        return respuesta;
    }
}