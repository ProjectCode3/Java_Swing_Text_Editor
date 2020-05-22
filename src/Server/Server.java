package Server;

public class Server {
    private int WIDTH, HEIGHT;
    private String _TITLE;
    private boolean _visible;

    public Server(int width, int height, String title, boolean isVisible){
        this.WIDTH = width;
        this.HEIGHT = height;
        this._TITLE = title;
        this._visible = isVisible;
    }

    public int getWidth(){
        return WIDTH;
    }

    public int getHeight(){
        return HEIGHT;
    }

    public String getTitle(){
        return _TITLE;
    }

    public boolean setFrameVisible(){
        return _visible;
    }
}
