package com.hybrid.service;

import com.hybrid.entity.CommentEntity;
import com.hybrid.request.CommentRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.CommentResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICommentService {

    BaseResponse createCmt(@RequestBody CommentRequest commentRequest,@PathVariable Integer id);

    BaseResponse updateCmt(@RequestBody CommentRequest commentRequest, @PathVariable Integer id);

    void deleteCmt(Integer id);
}
