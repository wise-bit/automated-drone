import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.opencv.;

public class FFmpegFXImageDecoder {
    private FFmpegFXImageDecoder() { }

    public static void streamToImageView(
            final ImageView view,
            final int port,
            final int socketBacklog,
            final String format,
            final double frameRate,
            final int bitrate,
            final String preset,
            final int numBuffers
    ) {
        try (final ServerSocket server = new ServerSocket(port, socketBacklog);
             final Socket clientSocket = server.accept();
             final FrameGrabber grabber = new FFmpegFrameGrabber(
                     clientSocket.getInputStream());
        ) {
            final Java2DFrameConverter converter = new Java2DFrameConverter();
            grabber.setFrameRate(frameRate);
            grabber.setFormat(format);
            grabber.setVideoBitrate(bitrate);
            grabber.setVideoOption("preset", preset);
            grabber.setNumBuffers(numBuffers);
            grabber.start();
            while (!Thread.interrupted()) {
                final Frame frame = grabber.grab();
                if (frame != null) {
                    final BufferedImage bufferedImage = converter.convert(frame);
                    if (bufferedImage != null) {
                        Platform.runLater(() ->
                                view.setImage(SwingFXUtils.toFXImage(bufferedImage, null)));
                    }
                }
            }
        }
        catch (final IOException | IOException e) {
            e.printStackTrace();
        }
    }
}