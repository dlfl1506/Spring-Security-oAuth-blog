package com.cos.blog.domain.post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PostRepository extends JpaRepository<Post, Integer>{

	
	@Query(value = "SELECT * FROM post where title Like %?1% OR content like %?1%",nativeQuery = true)
	Page<Post> 검색(Pageable pageable,String value);

}
