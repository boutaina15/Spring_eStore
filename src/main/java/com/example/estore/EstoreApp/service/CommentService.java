package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.Comment;

import java.util.List;

public interface CommentService {


    List<Comment> getComments();

    void deleteComment(Long commentId);

    Comment updateComment(Long commentId, Comment commentreq);

    Comment addComment(Comment comment);

}
