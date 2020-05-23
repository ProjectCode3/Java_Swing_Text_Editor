package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;

import Server.Server;



public class Client {
    public static Server server;

    public static int returnVal;

    public static JFrame frame = new JFrame();
    public static JTextArea text;
    public static JLabel lblCaption;
    public static JPanel panel;
    public static JFileChooser fc;
    public static JFileChooser sc;

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

    public static JMenuItem theme;
    public static JMenuItem font_theme;

    public static JMenuItem about_notepad;
    public static JMenuItem version;
    public static JMenuItem author;

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

        theme = new JMenuItem("Window Theme");
        server.addItemToMenu(window, theme);
        font_theme = new JMenuItem("Font Theme");
        server.addItemToMenu(window, font_theme);

        about_notepad = new JMenuItem("About");
        server.addItemToMenu(about, about_notepad);
        version = new JMenuItem("Version");
        server.addItemToMenu(about, version);
        author = new JMenuItem("Author");
        server.addItemToMenu(about, author);

        lblCaption = new JLabel("No Caption");
        panel = new JPanel();
        panel.add(lblCaption);

        text = new JTextArea(10, 40);


        //Open file function
        open.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /**
                         * Open File dialog to find file
                         * :param:: String file contents
                         * :return:: File contents
                         */
                        fc = new JFileChooser();
                        fc.showOpenDialog(null);
                        File f = fc.getSelectedFile();
                        String fileName = f.getAbsolutePath();
                        try{
                            FileReader fReader = new FileReader(fileName);
                            BufferedReader bReader = new BufferedReader(fReader);
                            text.read(bReader, null);
                            bReader.close();
                            text.requestFocus();
                            lblCaption.setText("Current Path: " + fileName);
                        }catch (Exception e1){
                            JOptionPane.showMessageDialog(frame, "[Exception] " + e1);
                        }

                    }
                }
        );

        //Clears the TextArea
        newfile.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /**
                         * Get Info from user whether to clear the text area or not or cancelled the process
                         * :param:: Integer
                         * :param:: None
                         */
                        returnVal = Integer.valueOf(JOptionPane.showConfirmDialog(frame, "Are You Sure You Want To Clear The Text, All Unsaved Progress Will Be Lost"));

                        switch (returnVal){
                            case 0:
                                text.setText(null);
                                lblCaption.setText("No Current file Selected");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(frame ,"Current File Still Active");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(frame, "Clearing Cancelled");
                                break;
                        }
                    }
                }
        );

        //Saves File As Type
        save_as.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /**
                         * Saves The File if It doesn't Exist
                         * :param:: String : FileName
                         * :return:: File Name
                         */
                        returnVal = sc.showSaveDialog(null);
                        if (returnVal == JFileChooser.APPROVE_OPTION){
                            File _file = sc.getSelectedFile();
                            String fileName = _file.getAbsolutePath();
                            try{
                                FileWriter fwriter = new FileWriter(fileName);
                                BufferedWriter bWriter = new BufferedWriter(fwriter);
                                bWriter.append(text.getText());
                                bWriter.close();
                            } catch (IOException ie){
                                JOptionPane.showMessageDialog(frame, "[Exception] " + e);
                            }
                        }
                    }
                }
        );

        //save if Contents of File has been Appended
        save.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /**
                         * Save Appended Content from text to file
                         * :param:: String File Contents
                         * :return:: String File Contents
                         */
                        File _newFile = fc.getSelectedFile();
                        String $fileName = _newFile.getAbsolutePath();
                        try{
                            File newfile = new File($fileName);
                            String path = newfile.getAbsolutePath();
                            String str = text.getText();
                            BufferedWriter out = new BufferedWriter(new FileWriter(path));
                            out.write(str);
                            out.close();
                        }catch (IOException u) {
                            JOptionPane.showMessageDialog(null, "[Exception] " + u);
                        }
                    }
                }
        );

        exit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /**
                         * Get Input from user whether to exit application
                         * :param:: Int
                         * :return:: Int
                          */
                        returnVal = Integer.valueOf(JOptionPane.showConfirmDialog(null, "AAre You Sure You Want To Exit, All Unsaved Progress Will Be Lost"));

                        switch(returnVal){
                            case 0:
                                System.exit(0);
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(frame, "Application Still Active");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(frame, "Cancelled Quiting Process");
                                break;
                        }

                    }
                }
        );

        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        frame.getContentPane().add(text, BorderLayout.CENTER);
        frame.setJMenuBar(menubar);
        frame.setVisible(server.setFrameVisible());
    }
}
