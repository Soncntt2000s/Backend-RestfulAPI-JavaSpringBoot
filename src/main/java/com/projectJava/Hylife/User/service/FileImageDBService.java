package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.entity.FileImageDB;
import com.projectJava.Hylife.User.entity.UserProfile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileImageDBService {

    FileImageDB store(MultipartFile file) throws IOException;

    Stream<FileImageDB> getAllFiles();
}
