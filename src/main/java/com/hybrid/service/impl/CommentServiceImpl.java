package com.hybrid.service.impl;

import com.hybrid.entity.CommentEntity;
import com.hybrid.entity.PostEntity;
import com.hybrid.repository.CommentRepository;
import com.hybrid.repository.PostRepository;
import com.hybrid.repository.UserRepository;
import com.hybrid.request.CommentRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public CommentRequest findAllByPost(Integer id) {
        return null;
    }


    @Transactional
    public BaseResponse createCmt(@RequestBody CommentRequest commentRequest, @PathVariable Integer id){
        PostEntity post = postRepository.findOneById(id);
        System.out.println(post.getMiniText());
        BaseResponse baseResponse = new BaseResponse();
        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setContent(commentRequest.getContent());
        commentEntity.setLikeNumber(commentRequest.getLikeNumber());
        commentEntity.setPost(post);
        commentEntity.setCommentParentId(post.getListComment());
        commentEntity.setUser(post.getUser());
        commentRepository.save(commentEntity);
        baseResponse.setReponseCode(200);
        baseResponse.setMessage("Comment created");
        return baseResponse;
    }
}
