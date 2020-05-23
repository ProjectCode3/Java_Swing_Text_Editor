package Server;

import javax.swing.*;
import java.awt.*;

public class Server {
    private int WIDTH, HEIGHT;
    private String _TITLE;
    private boolean _visible;

    public Server(int width, int height, String title, boolean isVisible){
        /**
         * init the frame width, height, title, and visibility
         * :param:: Int, String, Boolean
         * :return:: None
         */
        this.WIDTH = width;
        this.HEIGHT = height;
        this._TITLE = title;
        this._visible = isVisible;
    }

    public int getWidth(){
        /**
         * Return the specified width of the frame
         * :param:: int
         * :return:: Integer
         */
        return WIDTH;
    }

    public int getHeight(){
        /**
         * Return the specified height of the frame
         * :param:: Integer
         * :return:: Integer
         */
        return HEIGHT;
    }

    public String getTitle(){
        /**
         * Return the specified title of the frame
         * :param:: String
         * :param:: String
         */
        return _TITLE;
    }

    public boolean setFrameVisible(){
        /**
         * Return the visibility of the frame
         * :param:: Boolean
         * :return:: Bool
         */
        return _visible;
    }

    public void setMenuBar(JFrame frame, JMenuBar menuBar){
        /**
         * Adds menubar To JFrame
         * :param:: MenuBar
         * :return:: None
         */
        frame.setJMenuBar(menuBar);
    }

    public void addMenuToBar(JMenuBar menubar, JMenu menu){
        /**
         * Add Menu to menubar
         * :param:: Menu, MenuBar
         * :return:: None
         */
        menubar.add(menu);
    }

    public void addItemToMenu(JMenu menu, JMenuItem item){
        /**
         *Add MenuItem To Menu
         * :param:: MenuItem, Menu
         * :return:: None
         */
        menu.add(item);
    }


}
