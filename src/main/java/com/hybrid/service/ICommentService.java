package com.hybrid.service;

import com.hybrid.request.CommentRequest;

public interface ICommentService {

    CommentRequest findAllByPost(Integer id);
}
