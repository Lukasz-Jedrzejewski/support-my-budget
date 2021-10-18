package com.legion.supportmybudget.test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Tess {

    private final StringCleaner cleaner;

    public Tess(StringCleaner extractorInterface) {
        this.cleaner = extractorInterface;
    }

    public String doOcr(MultipartFile file) throws IOException {
        nu.pattern.OpenCV.loadLocally();

        String fileName = file.getOriginalFilename();
        Path path = Paths.get(fileName);
        byte[] strToBytes = file.getBytes();

        Files.write(path, strToBytes);
        Imgcodecs imageCodecs = new Imgcodecs();
        Mat img = Imgcodecs.imread(fileName);

        Mat resized = new Mat();
        Mat contrast = new Mat();
        Mat grey = new Mat();
        Mat binary = new Mat();
        Imgproc.resize(img, resized, new Size(900, 900));
        Imgproc.cvtColor(resized, grey, Imgproc.COLOR_RGB2GRAY, 3);
        grey.convertTo(contrast, -1, 0.6, 0);
        Imgproc.threshold(contrast,binary,127,255,Imgproc.THRESH_OTSU);

        MatOfInt params = new MatOfInt(Imgcodecs.CV_IMWRITE_PNG_COMPRESSION);
        File ocrImage = new File("ocrImage.png");
        Imgcodecs.imwrite(String.valueOf(ocrImage),binary,params);

        ITesseract instance = new Tesseract();

        instance.setDatapath("C:\\Users\\Ronin\\Downloads\\ocr");
        instance.setLanguage("pol");

        String result = "";

        try {
            result = instance.doOCR(ocrImage);
        } catch (
                TesseractException e) {
            System.err.println(e.getMessage());
        }
        return cleaner.extract(result);
    }

}
