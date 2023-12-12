package com.prism.mr.mapper;

import com.prism.mr.dto.CandidateDto;
import com.prism.mr.model.Candidate;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    Candidate toEntity(CandidateDto candidateDto);
    CandidateDto toDto(Candidate candidate);
}
