package Client;

import javax.swing.*;

import Server.Server;

public class Client {
    public static Server server;
    public static JFrame frame = new JFrame();

    public static void main(String[] args){
        server = new Server(1280, 720, "NotePad", true);

        frame.setSize(server.getWidth(), server.getHeight());
        frame.setTitle(server.getTitle());
        frame.setVisible(server.setFrameVisible());
    }
}
