package com.demo.blogweb.repositories

import com.demo.blogweb.models.Blog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface BlogRepository extends JpaRepository<Blog, Integer> {


}

