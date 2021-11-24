package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.entity.Banners;
import com.projectJava.Hylife.User.request.BannerRequest;
import org.springframework.boot.Banner;

import java.util.List;
import java.util.Optional;

public interface BannerService<id> {

    Banners createBanner (BannerRequest bannerRequest );

    Banners updateBanner(BannerRequest bannerRequest,Integer id);

    List<Banner> getListBanner();

    Banners getBannerById(Integer id);

    Banners deleteBannerById(Integer id);
}
