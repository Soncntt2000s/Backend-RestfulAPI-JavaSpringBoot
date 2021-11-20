package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.entity.FileImageDB;
import com.projectJava.Hylife.User.entity.UserProfile;
import com.projectJava.Hylife.User.repository.ImageFileDBRepository;
import com.projectJava.Hylife.User.response.FileImageResponce;
import com.projectJava.Hylife.User.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileImageDBServiceImpl implements FileImageDBService{

    @Autowired
    private ImageFileDBRepository fileDBRepository;

    @Autowired
    private FileImageDBService fileImageDBService;

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

    @Transactional
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
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

    @Transactional
    public ResponseEntity<List<FileImageResponce>> getListFilesImage() {
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

    @Transactional
    public ResponseEntity<byte[]> getFileById(@PathVariable String  id) {
        Optional<FileImageDB> optionalFileDB = fileDBRepository.findById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + optionalFileDB.get().getName() + "\"")
                .body(optionalFileDB.get().getData());
    }
}
