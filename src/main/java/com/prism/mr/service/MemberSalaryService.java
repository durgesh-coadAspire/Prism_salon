package com.prism.mr.service;

import com.prism.mr.dto.MemberSalaryDto;
import com.prism.mr.mapper.MemberSalaryMapper;
import com.prism.mr.repository.MemberSalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSalaryService {
    private final MemberSalaryRepository memberSalaryRepository;
    private final MemberSalaryMapper memberSalaryMapper;
    public MemberSalaryDto addOrUpdateMemberSalary(MemberSalaryDto memberSalaryDto){
        return memberSalaryMapper.toDto(memberSalaryRepository.save(memberSalaryMapper.toEntity(memberSalaryDto)));
    }
}
