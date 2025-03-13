package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CodeSnippet;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CodeSnippetRepository;

@Service
public class CodeSnippetService {
	
	@Autowired
	private CodeSnippetRepository codeSnippetRepository;

	public CodeSnippet createSnippet(CodeSnippet codeSnippet)
	{
		return codeSnippetRepository.save(codeSnippet);
	}
	
	public List<CodeSnippet> getAllCodeSnippet() 
	{
		return codeSnippetRepository.findAll();
	}
	
	public CodeSnippet getCodeSnippetById(Long id)
	{
		return codeSnippetRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Snippet not found with this id"));
	}
	
	public List<CodeSnippet> findByLanguage(String language)
	{
		return codeSnippetRepository.findByLanguageIgnoreCase(language);
	}
	
	public CodeSnippet updateCodeSnippet(Long id,CodeSnippet codeSnippet)
	{
		CodeSnippet snippet=getCodeSnippetById(id);
		snippet.setTitle(codeSnippet.getTitle());
		snippet.setCode(codeSnippet.getCode());
		snippet.setDescription(codeSnippet.getDescription());
		snippet.setLanguage(codeSnippet.getLanguage());
		
		return codeSnippetRepository.save(snippet);
	}
	
	  public List<CodeSnippet> searchCodeSnippets(String keyword) {
	        return codeSnippetRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
	    }
	
	public void deleteCodeSnippet(Long id)
	{
		 if (!codeSnippetRepository.existsById(id)) {
	            throw new ResourceNotFoundException("Snippet not found with this id");
	        }
		codeSnippetRepository.deleteById(id);
	}
}
