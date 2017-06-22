package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by alexa on 18.06.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageReader) throws IllegalAccessException {
        if (imageReader == ImageTypes.BMP) {
            return new BmpReader();
        } else if (imageReader == ImageTypes.JPG) {
            return new JpgReader();
        } else if (imageReader == ImageTypes.PNG) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
