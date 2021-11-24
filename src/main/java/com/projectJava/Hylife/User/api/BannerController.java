package com.projectJava.Hylife.User.api;


import com.projectJava.Hylife.User.entity.Banners;
import com.projectJava.Hylife.User.request.BannerRequest;
import com.projectJava.Hylife.User.response.BannerResponce;
import com.projectJava.Hylife.User.response.MessageResponse;
import com.projectJava.Hylife.User.service.BannerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BannerController {

    @Autowired
    BannerServiceImpl bannerService;


    @PostMapping("/admin/banner/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createBannerofAdmin(@Validated @RequestBody BannerRequest bannerRequest) {
        bannerService.createBanner(bannerRequest);
        return ResponseEntity.ok(new MessageResponse(
                "Create Banner Successfully!",
                200L )
        );
    }

    @PostMapping("/admin/banner/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateBannerofAdmin(@Validated @RequestBody BannerRequest bannerRequest ,@PathVariable Integer id) {
        bannerService.updateBanner(bannerRequest,id);
        return ResponseEntity.ok(new MessageResponse(
                "Update Banner Successfully!",
                200L)
        );
    }


    @GetMapping("/admin/banner/getListBanner")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Banners> getListBanners() {
//        MessageResponse messageResponse = new MessageResponse("Get Banner Successfully !",200L);
        return bannerService.getListBanner();
    }

    @GetMapping("/admin/banner/getBanner/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Banners getBannersById(@PathVariable Integer id) {
        return bannerService.getBannerById(id);
    }

    @DeleteMapping("/admin/banner/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Banners deleteBannersById(@PathVariable Integer id) {
        return bannerService.deleteBannerById(id);
    }
}
