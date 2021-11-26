package com.hybrid.service.impl;

import com.hybrid.converter.CommentConverter;
import com.hybrid.entity.CommentEntity;
import com.hybrid.entity.PostEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.entity.UserProfileEntity;
import com.hybrid.repository.CommentRepository;
import com.hybrid.repository.PostRepository;
import com.hybrid.repository.UserProfileRepository;
import com.hybrid.repository.UserRepository;
import com.hybrid.request.CommentRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.CommentResponse;
import com.hybrid.service.ICommentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentConverter commentConverter;


    @Override
    @Transactional
    public BaseResponse createCmt(@RequestBody CommentRequest commentRequest, @PathVariable Integer id){
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BaseResponse baseResponse = new BaseResponse();
        try {
            PostEntity post = postRepository.findOneById(id);
            UserEntity user = userRepository.findOneByEmail(userDetail.getEmail());
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setContent(commentRequest.getContent());
            commentEntity.setLikeNumber(commentRequest.getLikeNumber());
            commentEntity.setUser(user);
            commentEntity.setPost(post);
            commentEntity.setCreatedAt(commentRequest.getCreatedAt());
            commentRepository.save(commentEntity);
           baseResponse.setReponseCode(200);
           baseResponse.setMessage("Comment create");
        }catch (Exception e){
            e.printStackTrace();
        }
        return baseResponse;
    }

    @Override
    @Transactional
    public BaseResponse updateCmt(@RequestBody CommentRequest commentRequest, @PathVariable Integer id){
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BaseResponse baseResponse = new BaseResponse();
        Optional<CommentEntity> comment = commentRepository.findById(id);
        if(!commentRepository.existsById(comment.get().getId())){
            baseResponse.setReponseCode(401);
            baseResponse.setMessage("Update Fail ! This Comment does not exist");
        }
        else {
            if(comment.get().getUser().getId() == userDetail.getId()) {
                comment.get().setContent(commentRequest.getContent());
                comment.get().setLikeNumber(commentRequest.getLikeNumber());
                comment.get().setUpdatedAt(commentRequest.getUpdatedAt());
                comment.get().setPost(comment.get().getPost());
                comment.get().setUser(comment.get().getUser());
                baseResponse.setReponseCode(200);
                baseResponse.setMessage("Comment updated!");
            }else{
                baseResponse.setReponseCode(400);
                baseResponse.setMessage("You don't have permission to act on this comment");
            }
        }
        return baseResponse;
    }

    @Override
    @Transactional
    public void deleteCmt(Integer id){
        commentRepository.deleteById(id);
    }

}
