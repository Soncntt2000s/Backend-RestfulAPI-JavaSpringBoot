package com.projectJava.Hylife.User.api;

import com.projectJava.Hylife.User.entity.FileImageDB;
import com.projectJava.Hylife.User.entity.UserProfile;
import com.projectJava.Hylife.User.repository.ImageFileDBRepository;
import com.projectJava.Hylife.User.response.FileImageResponce;
import com.projectJava.Hylife.User.response.MessageResponse;
import com.projectJava.Hylife.User.service.FileImageDBService;
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
    private ImageFileDBRepository imageFileDBRepository;

    @Autowired
    private FileImageDBService fileImageDBService;

    @PostMapping(value = "/upload_img")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try
        {
            fileImageDBService.store(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message,200));
        }
        catch (Exception e)
        {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message,401));
        }
    }

    @GetMapping("/files")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<FileImageResponce>> getListFiles() {
        List<FileImageResponce> files = fileImageDBService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/user/files/")
                    .path(dbFile.getId().toString())
                    .toUriString();

            return new FileImageResponce(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/id=?{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<byte[]> getFile(@PathVariable String  id) {
        Optional<FileImageDB> optionalFileDB = imageFileDBRepository.findById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + optionalFileDB.get().getName() + "\"")
                .body(optionalFileDB.get().getData());
    }

}
