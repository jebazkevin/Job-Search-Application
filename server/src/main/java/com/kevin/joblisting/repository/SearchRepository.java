package com.kevin.joblisting.repository;

import java.util.List;

import com.kevin.joblisting.models.Post;

public interface SearchRepository {
	List<Post> findByText(String text);
}
