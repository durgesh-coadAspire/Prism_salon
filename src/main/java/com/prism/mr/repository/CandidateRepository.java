package com.prism.mr.repository;

import com.prism.mr.model.Candidate;
import com.prism.mr.model.Members;
import com.prism.mr.model.QCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "candidate",collectionResourceRel= "candidate")
public interface CandidateRepository extends JpaRepository<Candidate,Long>, QuerydslPredicateExecutor<QCandidate> {
    Optional<Candidate> findByCandidateId(String candidateId);
    Optional<Candidate> findByCandidateIdAndIdNotIn(String candidateId, List<Long> Id);
    Optional<Candidate> findByCandidateIdAndIdIn(String candidateId, List<Long> Id);
}
