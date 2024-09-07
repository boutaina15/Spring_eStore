package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.Comment;
import com.example.estore.EstoreApp.service.serviceImpl.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceImpl commentServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<Comment> getComments() {
        return commentServiceImpl.getComments();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentServiceImpl.addComment(comment)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentServiceImpl.deleteComment(commentId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable("commentId") Long commentId, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentServiceImpl.updateComment(commentId, comment)) ;
    }
}
