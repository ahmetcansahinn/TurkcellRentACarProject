package com.turkcell.carservice.controllers;

import com.turkcell.carservice.business.concrets.UploaderManager;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {

    private final UploaderManager cloudinaryUploader;

    public ImageController(UploaderManager cloudinaryUploader) {
        this.cloudinaryUploader = cloudinaryUploader;
    }

    public String uploadImage(String base64Data) throws IOException {
        return cloudinaryUploader.uploadBase64Image(base64Data);
    }
}
