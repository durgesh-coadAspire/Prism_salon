package com.prism.mr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MembersPageDto {
    private long total;
    private List<MembersDto> membersDtoList;

}
