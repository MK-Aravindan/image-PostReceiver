package com.imagegenerator.backend.service;

import com.imagegenerator.backend.entity.ImageEntity;
import com.imagegenerator.backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageEntity getImage(Long id) throws Exception {

        Optional<ImageEntity> image =  imageRepository.findById(id);
        if (image.isPresent()) {
            return image.get();
        }
        else
        {
            throw new Exception("Image not found with id: " + id);
        }
    }
}
