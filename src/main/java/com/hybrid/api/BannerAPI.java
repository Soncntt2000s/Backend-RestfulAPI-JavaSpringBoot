package com.hybrid.api;

import com.hybrid.entity.BannersEntity;
import com.hybrid.repository.BannersRepository;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.impl.BannerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BannerAPI {

    @Autowired
    private BannerServiceImpl bannerService;

    @Autowired
    private BannersRepository bannersRepository;

    @PostMapping(value = "/banner",consumes = {"multipart/form-data"})
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse createBanner(@RequestParam String title,
                                     @RequestParam String content,
                                     @RequestParam MultipartFile image) throws IOException{
        return bannerService.create(title,content,image);
    }

    @GetMapping(value = "/banner")
    public List<BannersEntity> getBanner(){
        return bannerService.getBanner();
    }

    @PutMapping(value = "/banner/{id}",consumes = {"multipart/form-data"})
    public BaseResponse updateBanner(@RequestParam String title,
                               @RequestParam String content,
                               @RequestParam String updatedAt,
                               @RequestParam MultipartFile image,
                                     @PathVariable Integer id)throws IOException{
            return bannerService.update(title,content,updatedAt,image,id);
    }

    @GetMapping(value = "/banner/{id}")
    public Optional<BannersEntity> getBannerById(@PathVariable Integer id){
        return bannerService.getBannerById(id);
    }

    @DeleteMapping("/banner/{id}")
    public BaseResponse delete(@PathVariable Integer id){
        BaseResponse baseResponse = new BaseResponse();
        if(bannersRepository.existsById(id)) {
            bannerService.deleteById(id);
            baseResponse.setReponseCode(200);
            baseResponse.setMessage("Delete banner successfully");
        }else{
            baseResponse.setReponseCode(401);
            baseResponse.setMessage("delete banner error !");
        }
        return baseResponse;
    }
}
