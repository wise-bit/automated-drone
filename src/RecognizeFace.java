// "C:\Users\satra\IdeaProjects\reconattendance\lib\build\bin\opencv-344.jar"

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

import Utils.Utils;

public class RecognizeFace {

    public String classifier = "data/haarcascade_frontalface_alt.xml";

    // SETTINGS

    public String path = "";
    public String imageExt = "jpg";

    public int length = 0;
    public int width = 0;

    public RecognizeFace(String imgPath) {

        this.path = imgPath;

        try {

            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            System.out.println("Library loaded..");
            Mat frame= Imgcodecs.imread(imagePath("input"), 1);

            if (!frame.empty()) {

                detectAndDisplay(frame); // face detection
                File outputfile = new File(imagePath("output"));
                ImageIO.write(Utils.matToBufferedImage(frame), imageExt, outputfile);
                System.out.println("Done!!");

            }

            System.out.println("Original image: " + imagePath("input"));

        } catch (IOException e) {

            System.out.println("Exception IO");
            e.printStackTrace();

        }
    }

    public int area() {
        return this.length * this.width;
    }

    public String imagePath (String name) {
        return this.path + "/" + name + "." + imageExt;
    }

    public void detectAndDisplay(Mat frame) throws IOException {

        MatOfRect faces = new MatOfRect();
        Mat grayFrame = new Mat();

        int absoluteFaceSize=0;

        CascadeClassifier faceCascade=new CascadeClassifier();

        faceCascade.load(classifier);

        Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY); // convert the frame in gray scale

        Imgproc.equalizeHist(grayFrame, grayFrame); // equalize the frame histogram to improve the result

        // compute minimum face size (1% of the frame height, in our case)

        int height = grayFrame.rows();

        if (Math.round(height * 0.2f) > 0) {
            absoluteFaceSize = Math.round(height * 0.01f);
        }

        faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE,
                new Size(absoluteFaceSize, absoluteFaceSize), new Size(height,height)); // detect faces

        Rect[] facesArray = faces.toArray(); // each rectangle in faces is a face: draw them!

        System.out.println("Number of faces detected = "+facesArray.length);

        for (int i = 0; i < facesArray.length; i++) {
            Imgproc.rectangle(frame, facesArray[i].tl(), facesArray[i].br(), new Scalar(0, 255, 0), 2);
        }

    }

}