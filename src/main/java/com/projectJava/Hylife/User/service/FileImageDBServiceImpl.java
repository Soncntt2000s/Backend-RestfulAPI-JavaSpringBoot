package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.entity.FileImageDB;
import com.projectJava.Hylife.User.entity.UserProfile;
import com.projectJava.Hylife.User.repository.ImageFileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FileImageDBServiceImpl implements FileImageDBService{

    @Autowired
    private ImageFileDBRepository fileDBRepository;

    @Override
    public FileImageDB store(MultipartFile file) throws IOException {

        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileImageDB image = new FileImageDB(filename,file.getContentType(),file.getBytes());
        return fileDBRepository.save(image);
    }

    @Override
    public Stream<FileImageDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
