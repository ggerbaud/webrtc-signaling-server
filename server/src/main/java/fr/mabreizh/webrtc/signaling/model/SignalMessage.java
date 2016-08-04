package fr.mabreizh.webrtc.signaling.model;

/**
 * @author Guillaume Gerbaud
 */
public class SignalMessage {

    private String type;
    private String dest;
    private Object data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
