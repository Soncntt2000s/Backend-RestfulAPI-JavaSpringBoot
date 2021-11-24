package com.hybrid.api;

import com.hybrid.entity.CommentEntity;
import com.hybrid.request.CommentRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CommentAPI {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping("/{id}/comment")
    public BaseResponse create(@RequestBody CommentRequest commentRequest, @PathVariable Integer id){
        return  commentService.createCmt(commentRequest, id);
    }
}
