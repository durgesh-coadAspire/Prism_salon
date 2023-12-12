package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "candidate",types = {Candidate.class})
public interface CandidateProjection {

    Long getId();


}
