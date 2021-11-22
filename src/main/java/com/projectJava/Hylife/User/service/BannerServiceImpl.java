package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.entity.Banners;
import com.projectJava.Hylife.User.repository.BannerRepository;
import com.projectJava.Hylife.User.request.BannerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService{

    @Autowired
    BannerRepository bannerRepository;


    @Override
    public Banners createBanner(@Validated @RequestBody BannerRequest bannerRequest) {
        Banners banners = new Banners(
            bannerRequest.getTitle(),
            bannerRequest.getContent(),
            bannerRequest.getImgImage(),
            bannerRequest.getCreatedAt()
        );
        return bannerRepository.save(banners);
    }

    @Override
    public Banners updateBanner(@Validated @RequestBody BannerRequest bannerRequest,Integer id) {

        Banners banners = bannerRepository.findOneById(id);
        banners.setTitle(bannerRequest.getTitle());
        banners.setContent(bannerRequest.getContent());
        banners.setUrlImg(bannerRequest.getImgImage());
        banners.setCreatedAt(bannerRequest.getCreatedAt());
        banners.setUpdatedAt(bannerRequest.getUpdatedAt());
        return bannerRepository.save(banners);
    }

    @Override
    public List<Banners> getListBanner() {
        List<Banners> bannersList = bannerRepository.findAll();
        return bannersList;
    }

    @Override
    public Banners getBannerById(@PathVariable Integer id) {
        Banners banners = bannerRepository.getById(id);
        return banners;
    }

    @Override
    public Banners deleteBannerById(@PathVariable Integer id) {
        try {
            bannerRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
