package com.hybrid.request;

import com.hybrid.entity.CommentEntity;
import com.hybrid.entity.PostEntity;
import com.hybrid.entity.UserEntity;
import lombok.Data;

import javax.xml.soap.Text;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Data
public class CommentRequest {

        private String content;
        private int likeNumber;
        private int commentParentId;
        private int post;
        private int user;
        private Timestamp createdAt;
        private Timestamp updatedAt;

        public CommentRequest(String content, int likeNumber, int commentParentId,
                              int post, int user, Timestamp updatedAt) {
                this.content = content;
                this.likeNumber = likeNumber;
                this.commentParentId = commentParentId;
                this.post = post;
                this.user = user;
                this.updatedAt = updatedAt;
        }

        public CommentRequest() {
        }
}
