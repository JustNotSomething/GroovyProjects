package com.demo.blogweb.controllers

import com.demo.blogweb.models.Blog
import com.demo.blogweb.services.BlogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/blogs")
@CrossOrigin(origins = "http://localhost:3000")
class BlogController {

    private final BlogService blogService

    @Autowired
    BlogController(BlogService blogService) {
        this.blogService = blogService
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Blog>> getAllBlogs() {
        def blogs = blogService.index()
        new ResponseEntity<>(blogs, HttpStatus.OK)
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Blog> getBlog(@PathVariable("id") Integer id) {
        def blog = blogService.find(id)
        if(!blog)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return new ResponseEntity<>(blog, HttpStatus.OK)

    }

    @PostMapping("/create")
    ResponseEntity createBlog(@RequestBody Blog blog) {
        blogService.save(blog)
        new ResponseEntity(HttpStatus.OK)
    }

    @PatchMapping("/update")
    ResponseEntity updateBlog(@RequestBody Blog blogToUpdate) {
        blogToUpdate.creationDate = new Date();
        blogService.update(blogToUpdate)
        new ResponseEntity(HttpStatus.OK)
    }

    @PostMapping("/delete/{id}")
    ResponseEntity deleteBlog(@PathVariable("id") Integer id) {
        def blogToDelete = blogService.find(id);
        blogService.delete(blogToDelete)
        new ResponseEntity(HttpStatus.OK)
    }

    @PostMapping("/like/{id}")
    ResponseEntity likeBlog(@PathVariable("id") Integer id) {
        def blog = blogService.find(id)
        blog.likes = blog.likes + 1
        blogService.update(blog)
        new ResponseEntity(HttpStatus.OK)
    }

    @PostMapping("/dislike/{id}")
    ResponseEntity dislikeBlog(@PathVariable("id") Integer id) {
        def blog = blogService.find(id)
        blog.dislikes = blog.dislikes + 1
        blogService.update(blog)
        new ResponseEntity(HttpStatus.OK)
    }
}
