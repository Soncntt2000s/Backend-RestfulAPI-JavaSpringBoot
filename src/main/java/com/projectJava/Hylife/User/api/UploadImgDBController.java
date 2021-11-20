package com.projectJava.Hylife.User.api;

import com.projectJava.Hylife.User.entity.FileImageDB;
import com.projectJava.Hylife.User.entity.UserProfile;
import com.projectJava.Hylife.User.repository.ImageFileDBRepository;
import com.projectJava.Hylife.User.response.FileImageResponce;
import com.projectJava.Hylife.User.response.MessageResponse;
import com.projectJava.Hylife.User.service.FileImageDBService;
import com.projectJava.Hylife.User.service.FileImageDBServiceImpl;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UploadImgDBController {

    @Autowired
    private FileImageDBServiceImpl fileImageDBService;


    @PostMapping(value = "/upload_img")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        return fileImageDBService.uploadImage(file);
    }

    @GetMapping("/files")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<FileImageResponce>> getListFiles(){
        return fileImageDBService.getListFilesImage();
    }

    @GetMapping("/files/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<byte[]> getFile(@PathVariable String  id) {
        return fileImageDBService.getFileById(id);
    }

}
