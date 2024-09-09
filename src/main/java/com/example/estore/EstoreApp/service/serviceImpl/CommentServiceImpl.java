package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.CommentRepository;
import com.example.estore.EstoreApp.entities.Comment;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl {

    private final CommentRepository commentRepository;

    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        boolean exists = commentRepository.existsById(commentId);
        if (!exists) {
            throw new IllegalStateException("comment with id " +commentId+" does not exists");
        }
        commentRepository.deleteById(commentId);
        System.out.println("the comment with id : "+commentId+ " has been deleted succefully");

    }

    @Transactional
    public Comment updateComment(Long commentId, Comment commentreq) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalStateException("comment does not exists"));
        if (comment != null){
            comment.setCreated_at(commentreq.getCreated_at());
            comment.setDescription(commentreq.getDescription());
            comment.setProduct(commentreq.getProduct());

            System.out.println("the comment  has been updated succefully");

        }
        return commentRepository.save(comment);


    }
}
