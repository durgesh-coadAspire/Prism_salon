package com.prism.mr.service;

import com.prism.mr.dto.MemberUpdatePasswordDto;
import com.prism.mr.dto.MembersDto;
import com.prism.mr.dto.MembersPageDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.mapper.MembersMapper;
import com.prism.mr.model.Members;
import com.prism.mr.model.QMembers;
import com.prism.mr.repository.MembersRepository;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MembersRepository membersRepository;
    private final MembersMapper membersMapper;
    private final PasswordEncoder passwordEncoder;


    public MembersDto addOrUpdateMember(MembersDto membersDto) {
        Members members = new Members();
        if (Objects.nonNull(membersDto.getId())) {
            members = membersRepository.findById(membersDto.getId()).orElse(new Members());
        }
        BeanUtils.copyProperties(membersDto, members, "password");
        if (Objects.isNull(members.getId())) {
            members.setPassword(passwordEncoder.encode(membersDto.getPassword()));
        }
        return membersMapper.toDto(membersRepository.save(members));
    }

    public Members findByUserId(String userId) {
        return membersRepository.findById(Long.valueOf(userId)).orElseThrow(() -> new ResourceNotFoundException("Invalid User"));
    }

    public String validateEmployeeId(Long Id, String Code) {
        Optional<Members> members;
        if (Id == null) {
            members = membersRepository.findByEmployeeId(Code);
        } else {
            members = membersRepository.findById(Id);
            if (members.isPresent()) {
                if (membersRepository.findById(Id).get().getEmployeeId().equalsIgnoreCase(Code)) {
                    members = membersRepository.findByEmployeeIdAndIdIn(Code, List.of(Id));
                } else {
                    members = membersRepository.findByEmployeeIdAndIdNotIn(Code, List.of(Id));
                }
            } else {
                members = membersRepository.findByEmployeeIdAndIdNotIn(Code, List.of(Id));
            }
        }
        if (members.isPresent()) {
            throw new ResourceNotFoundException("Duplicate Employee ID Found !!");
        } else {
            return "VALID EMPLOYEE CODE";
        }
    }

    public String updatePassword(MemberUpdatePasswordDto memberUpdatePasswordDto) {

        Optional<Members> member = membersRepository.findById(memberUpdatePasswordDto.getId());
        if (member.isPresent()) {
            Members members = member.get();
            String newPassword = memberUpdatePasswordDto.getPassword();
            members.setPassword(passwordEncoder.encode(newPassword));
            membersRepository.save(members);
            return "Password Changed Successfully !!";
        } else {
            throw new ResourceNotFoundException("Invalid Employee ID !!");
        }

    }

    public MembersPageDto getAllMember(Predicate predicate, Pageable pageable, boolean getInHierarchy, Long currentMemberId) {
        if (getInHierarchy) {
            if (predicate == null) {
                predicate = QMembers.members.id.ne(0L);
            }
            predicate = QMembers.members.id.in(findAllMemberInHierarchy(currentMemberId, new HashSet<>())).and(predicate);
        }
        Page<Members> membersPage = membersRepository.findAll(predicate, pageable);
        MembersPageDto response = new MembersPageDto();
        response.setTotal(membersPage.getTotalElements());
        response.setMembersDtoList(membersPage.getContent().stream().map(membersMapper::toDto).collect(Collectors.toList()));
        return response;
    }

    public Set<Long> findAllMemberInHierarchy(Long currentMemberId, Set<Long> allMemberIds) {
        List<Members> membersList = membersRepository.findAllByReportingManager(currentMemberId);
        for (Members member : membersList) {
            allMemberIds.add(member.getId());
            findAllMemberInHierarchy(member.getId(), allMemberIds);
        }
        return allMemberIds;
    }

}
