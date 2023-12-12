package com.prism.mr.service;

import com.prism.mr.dto.CandidateDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.mapper.CandidateMapper;
import com.prism.mr.model.Candidate;
import com.prism.mr.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    /*@Value("${file.upload.directory}") // Set your file upload path*/
    private String uploadDirectory;

    public Candidate addOrUpdateCandidate(CandidateDto candidateDto) {
        Candidate candidate = new Candidate();
        candidate.setCandidateId(candidateDto.getCandidateId());
        candidate.setFirstName(candidateDto.getFirstName());
        candidate.setLastName(candidateDto.getLastName());
        candidate.setDob(candidateDto.getDob());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setEducation(candidateDto.getEducation());
        candidate.setRemark(candidateDto.getRemark());
        candidate.setInterviewer(candidateDto.getInterviewer());
        candidate.setDateApply(candidateDto.getDateApply());
        candidate.setStatus(candidateDto.getStatus());
        candidate.setPositionApplied(candidateDto.getPositionApplied());
        candidate.setWorkExperience(candidateDto.getWorkExperience());
        candidate.setAddress(candidateDto.getAddress());
        candidate.setMobile(candidateDto.getMobile());

        // Store the image path in the database
        /*String imagePath = storeFile(candidateDto.getUploadedFile(),candidateDto);
        candidate.setFilePath(imagePath);*/

        return candidateRepository.save(candidate);
       }

    public String storeFile(MultipartFile uploadedFile,CandidateDto candidateDto) {
        List<String> allowedFormats = Arrays.asList("application/pdf", "image/jpeg", "image/png", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "text/plain");
        if (uploadedFile == null || uploadedFile.isEmpty()) {
            // Handle empty file scenario
            throw new IllegalArgumentException("File is empty or null");
        }
        if (!allowedFormats.contains(uploadedFile.getContentType())) {
            throw new IllegalArgumentException("Invalid file format. Allowed formats are PDF, images, DOCX, and text files");
        }

        try {
            Path uploadPath = Paths.get(uploadDirectory);
            Path filePath = uploadPath.resolve("File_"+candidateDto.getCandidateId());

            // Check if the file exists and delete it if present
            if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
                Files.delete(filePath);
            }

            // Create the upload directory if it doesn't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Files.copy(uploadedFile.getInputStream(), filePath);
            return uploadDirectory + "/" + "File_"+candidateDto.getCandidateId();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store the file. Please try again!");
        }
    }

    public String validateCandidateId(Long Id, String Code) {
        Optional<Candidate> candidate;
        if(Id==null )
        {
            candidate=candidateRepository.findByCandidateId(Code);
        }
        else {
            candidate=candidateRepository.findById(Id);
            if(candidate.isPresent())
            {
                if(candidateRepository.findById(Id).get().getCandidateId().equalsIgnoreCase(Code))
                {
                    candidate=candidateRepository.findByCandidateIdAndIdIn(Code,List.of(Id));
                }
                else {
                    candidate=candidateRepository.findByCandidateIdAndIdNotIn(Code,List.of(Id));
                }
            }
            else {
                candidate=candidateRepository.findByCandidateIdAndIdNotIn(Code,List.of(Id));
            }
        }
        if(candidate.isPresent())
        {
            throw new ResourceNotFoundException("Duplicate Candidate ID Found !!");
        }

        else {
            return "VALID CANDIDATE CODE";
        }
    }
}
