import org.opencv.videoio.VideoCapture;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class CameraInput {

    private InetAddress ip = null;
    private int port;
    private DatagramSocket s;
    private Socket socket;

    public CameraInput() throws Exception {

        connectCamera();
        // All code goes below this //



        // ------------------------ //
        closeCamera();

    }

    final public void connectCamera() throws Exception {

        this.port = 11111;
        ip = InetAddress.getByName("192.168.10.1");
        s = new DatagramSocket(port);
        s.connect(ip, port);

    }

    final public void closeCamera() {
        if(null != s)
            s.close();
    }

}
