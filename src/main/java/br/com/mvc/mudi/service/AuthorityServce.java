package br.com.mvc.mudi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mvc.mudi.dto.AuthorityDto;
import br.com.mvc.mudi.mapper.AuthorityMapper;
import br.com.mvc.mudi.model.Authority;
import br.com.mvc.mudi.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityServce {

	private final AuthorityRepository authorityRepository;
	private final AuthorityMapper authorityMapper;
	
	public AuthorityDto getAuthorityById(Integer id) {
		return authorityMapper.authorityEntityToDto(authorityRepository.findById(id).orElse(null));
	}
	
	public List<AuthorityDto> getAllAuthorities() {
		return authorityMapper.authorityListEntityToDto(authorityRepository.findAll());
	}
	
	public AuthorityDto createAuthority(Authority authority) {
		return authorityMapper.authorityEntityToDto(authorityRepository.save(authority));
	}
	
	public AuthorityDto updateAuthority(Authority authority) {
		return authorityMapper.authorityEntityToDto(authorityRepository.save(authority));
	}
	
	public void deleteAuthority(Authority authority) {
		authorityRepository.delete(authority);
	}
}
