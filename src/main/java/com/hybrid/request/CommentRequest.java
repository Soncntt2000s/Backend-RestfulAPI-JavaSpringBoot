package com.hybrid.request;

import com.hybrid.entity.CommentEntity;
import com.hybrid.entity.PostEntity;
import com.hybrid.entity.UserEntity;
import lombok.Data;

import javax.xml.soap.Text;
import java.util.List;

@Data
public class CommentRequest {

        private String content;
        private int likeNumber;
        private int commentParentId;
        private int post;
        private int user;

        public CommentRequest(String content, int likeNumber, int commentParentId,
                              int post, int user) {
                this.content = content;
                this.likeNumber = likeNumber;
                this.commentParentId = commentParentId;
                this.post = post;
                this.user = user;
        }

        public CommentRequest() {
        }
}
