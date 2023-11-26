package com.turkcell.carservice.business.concrets;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

@Configuration
public class UploaderManager {

    private final Cloudinary cloudinary;
    private final String cloudName = "dsbdk6pvk";
    private final String apiKey = "611975325136714";
    private final String apiSecret = "pVo09Bl8pzNvHw-T9Ua6uVnSjGk";

    public UploaderManager() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    public String uploadBase64Image(String base64Data) throws IOException {
        Map<?, ?> uploadResult = cloudinary.uploader().upload(base64Data, ObjectUtils.emptyMap());
        return (String) uploadResult.get("url");
    }
}