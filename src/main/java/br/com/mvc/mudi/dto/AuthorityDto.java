package br.com.mvc.mudi.dto;

import lombok.Builder;

@Builder
public record AuthorityDto(
		Integer id,
		String authority) {}