package Client;

import javax.swing.*;

import Server.Server;

public class Client {
    public static Server server;

    public static JFrame frame = new JFrame();

    public static JMenuBar menubar;

    public static JMenu file;
    public static JMenu view;
    public static JMenu zoomIn;
    public static JMenu zoomOut;
    public static JMenu window;
    public static JMenu about;

    public static JMenuItem open;
    public static JMenuItem newfile;
    public static JMenuItem save_as;
    public static JMenuItem save;
    public static JMenuItem exit;

    public static JMenuItem zoom_in;
    public static JMenuItem zoom_out;

    public static void main(String[] args){
        //init the frame (constructor class
        server = new Server(1280, 720, "NotePad", true);
        //set the frame size(width, height)
        frame.setSize(server.getWidth(), server.getHeight());
        //set the frame title(String)
        frame.setTitle(server.getTitle());

        menubar = new JMenuBar();

        file = new JMenu("File");
        server.addMenuToBar(menubar, file);
        view = new JMenu("View");
        server.addMenuToBar(menubar, view);
        window = new JMenu("Window");
        server.addMenuToBar(menubar, window);
        about = new JMenu("About");
        server.addMenuToBar(menubar, about);

        open = new JMenuItem("Open");
        server.addItemToMenu(file, open);
        newfile = new JMenuItem("New File");
        server.addItemToMenu(file, newfile);
        file.addSeparator();
        save_as = new JMenuItem("Save As");
        server.addItemToMenu(file, save_as);
        save = new JMenuItem("Save");
        server.addItemToMenu(file, save);
        file.addSeparator();
        exit = new JMenuItem("Exit");
        server.addItemToMenu(file, exit);

        zoomIn = new JMenu("Zoom In");
        zoomOut = new JMenu("Zoom Out");
        view.add(zoomIn);
        view.add(zoomOut);
        zoom_in = new JMenuItem("Zoom In");
        server.addItemToMenu(zoomIn, zoom_in);
        zoom_out = new JMenuItem("Zoom Out");
        server.addItemToMenu(zoomOut, zoom_out);


        frame.setJMenuBar(menubar);
        frame.setVisible(server.setFrameVisible());
    }
}
