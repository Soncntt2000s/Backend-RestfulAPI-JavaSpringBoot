package com.hybrid.service.impl;

import com.hybrid.entity.BannersEntity;
import com.hybrid.repository.BannersRepository;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class BannerServiceImpl implements BannerService {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Autowired
    private BannersRepository bannersRepository;

    @Autowired
    private BannerService bannerService;


    @Transactional
    public BaseResponse create(@RequestParam String title,
                               @RequestParam String content,
                               @RequestParam MultipartFile image) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
            return new BaseResponse(
                    401,
                    "Error create banner !"
            );
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }
        BannersEntity banners = new BannersEntity();
            banners.setTitle(title);
            banners.setContent(content);
            banners.setImage(imagePath.resolve(image.getOriginalFilename()).toString());
         bannersRepository.save(banners);
         return new BaseResponse(
                 200,
                 "Create banner successfully !"
         );
    }

    @Transactional
    public List<BannersEntity> getBanner() {
        List<BannersEntity> banners = bannersRepository.findAll();
        return banners;
    }

    @Transactional
    public Optional<BannersEntity> getBannerById(@PathVariable Integer id){
        Optional<BannersEntity> banners = bannersRepository.findById(id);
        return banners;
    }

    @Transactional
    public BaseResponse update(@RequestParam String title,
                               @RequestParam String content,
                               @RequestParam String updatedAt,
                               @RequestParam MultipartFile image , @PathVariable Integer id)throws IOException{
        BaseResponse baseResponse = new BaseResponse();
        if(!bannersRepository.existsById(id)){
                baseResponse.setReponseCode(401);
                baseResponse.setMessage("Error update!");
        }else {
            Path staticPath = Paths.get("static");
            Path imagePath = Paths.get("images");
            Path file = CURRENT_FOLDER.resolve(staticPath)
                    .resolve(imagePath).resolve(image.getOriginalFilename());
            BannersEntity bannersEntity = bannersRepository.getById(id);
            bannersEntity.setTitle(title);
            bannersEntity.setContent(content);
            bannersEntity.setImage(imagePath.resolve(image.getOriginalFilename()).toString());
            bannersEntity.setUpdatedAt(Timestamp.valueOf(updatedAt));
            bannersRepository.save(bannersEntity);
            baseResponse.setReponseCode(200);
            baseResponse.setMessage("Update Successfully!");
        }
        return baseResponse;
    }

    @Transactional
    public BaseResponse deleteById(@PathVariable Integer id){
        BaseResponse baseResponse = new BaseResponse();
        try {
            bannersRepository.deleteById(id);
            baseResponse.setReponseCode(200);
            baseResponse.setMessage("Delete Banner Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
        return baseResponse;
    }
}
