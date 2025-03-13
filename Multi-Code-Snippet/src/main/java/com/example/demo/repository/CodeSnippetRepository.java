package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CodeSnippet;

public interface CodeSnippetRepository extends JpaRepository<CodeSnippet , Long>{
	
	 // Custom query to find code snippet by language
    List<CodeSnippet> findByLanguageIgnoreCase(String language);
    
    List<CodeSnippet> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
    

   

}
