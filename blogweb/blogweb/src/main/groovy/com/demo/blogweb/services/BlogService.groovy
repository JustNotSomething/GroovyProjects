package com.demo.blogweb.services

import com.demo.blogweb.models.Blog
import com.demo.blogweb.repositories.BlogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class BlogService {

    private final BlogRepository blogRepository

    @Autowired
    BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository
    }

    List<Blog> index() {
        blogRepository.findAll()
    }

    @Transactional
    void save(Blog blog) {
        blog.dislikes = 0
        blog.likes = 0
        blogRepository.save(blog)
    }

    Blog find(int id) {
        blogRepository.findById(id).orElse(null)
    }

    @Transactional
    void delete(Blog blog) {
        blogRepository.delete(blog)
    }

    @Transactional
    void update(Blog blogToUpdate) {

        blogRepository.save(blogToUpdate)
    }
}
