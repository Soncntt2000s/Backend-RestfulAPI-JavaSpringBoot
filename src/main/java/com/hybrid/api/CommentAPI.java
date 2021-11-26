package com.hybrid.api;

import com.hybrid.entity.CommentEntity;
import com.hybrid.request.CommentRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.CommentResponse;
import com.hybrid.service.ICommentService;
import com.hybrid.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CommentAPI {

    @Autowired
    private ICommentService iCommentService;

    @PostMapping("/{id}/comment")
    public BaseResponse create(@RequestBody CommentRequest commentRequest, @PathVariable Integer id){
        return  iCommentService.createCmt(commentRequest, id);
    }

    @PutMapping("/{id}/comment/{id1}")
    public BaseResponse update(@RequestBody CommentRequest commentRequest, @PathVariable Integer id1){
        return  iCommentService.updateCmt(commentRequest, id1);
    }

    @DeleteMapping("/{id1}/comment/{id1}")
    public BaseResponse delete( @PathVariable Integer id1){
        iCommentService.deleteCmt(id1);
        return new BaseResponse(
                200,
                "Comment deleted"
        );
    }
}
