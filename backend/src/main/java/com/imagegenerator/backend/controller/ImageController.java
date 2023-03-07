package com.imagegenerator.backend.controller;

import com.imagegenerator.backend.entity.ImageEntity;
import com.imagegenerator.backend.repository.ImageRepository;
import com.imagegenerator.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile image) {
        try {
            ImageEntity entity = new ImageEntity();
            entity.setImage(image.getBytes());
            imageRepository.save(entity);
            return ResponseEntity.ok().build();

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("id") Long id) throws Exception {
        ImageEntity imageEntity = imageService.getImage(id);
        return imageEntity.getImage();
    }
}
