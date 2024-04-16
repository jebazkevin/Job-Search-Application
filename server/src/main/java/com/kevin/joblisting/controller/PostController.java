package com.kevin.joblisting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.kevin.joblisting.PostRepository;
import com.kevin.joblisting.models.Post;
//import com.kevin.joblisting.repository.PostRepository;
import com.kevin.joblisting.repository.PostRepository;
import com.kevin.joblisting.repository.SearchRepositoryImpli;

//import jakarta.servlet.http.HttpServletResponse;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepositoryImpli srepo;
	
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
	@GetMapping("/allPosts")
	@CrossOrigin
    public List<Post> getAllPost(){
    	
		return repo.findAll();
    }
	
	@GetMapping("/post/{text}")
	@CrossOrigin
	public List<Post> search(@PathVariable String text){
		 return srepo.findByText(text);
	}
	
	@PostMapping("/post")
	@CrossOrigin
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);
	}
	
	
}
