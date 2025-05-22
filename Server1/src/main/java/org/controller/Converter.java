package org.controller;

import org.model.*;
import proto.ServerClient;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class Converter {
    public static List<Integer> protoMapToList(Map<Integer, Boolean> currentMap) {
        List<Integer> cvidList = new ArrayList<>();

        for (Map.Entry<Integer, Boolean> entry : currentMap.entrySet()) {
            if (entry.getValue()) {
                cvidList.add(entry.getKey());
            }
        }

        return cvidList;
    }

    public static com.google.protobuf.Timestamp timesToProto(Timestamp sqlTimestamp) {
        Instant instant = sqlTimestamp.toInstant();
        return com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    public static com.google.protobuf.Timestamp timesToProto(java.sql.Date date) {
        if (date == null) {
            return null; // Handle null input
        }

        java.util.Date utilDate = new java.util.Date(date.getTime());
        Instant instant = utilDate.toInstant();

        return com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    public static Timestamp protoToTimeStamp(com.google.protobuf.Timestamp timestamp){
        if(timestamp == null)   return null;
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();

        long millis = seconds * 1000 + nanos / 1_000_000;
        return new Timestamp(millis);
    }

    private static Map<Integer, Boolean> convertHashSetToMap(HashSet<Integer> set) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer value : set) {
            map.put(value, true);
        }
        return map;
    }

    public static String hashPassword(String password){
        return password;
    }

    public static ServerClient.UserFullInfo usersToProto(Users users){
        ServerClient.UserFullInfo.Builder builder = ServerClient.UserFullInfo.newBuilder();
        if(users.getUserID() != 0)  builder.setUserID(users.getUserID());
        if(users.getUsername() != null && !users.getUsername().isEmpty())    builder.setUsername(users.getUsername());
        if(users.getPassword_hashed() != null && !users.getPassword_hashed().isEmpty())  builder.setPasswordHashed(users.getPassword_hashed());
        if(users.getFirstName() != null && !users.getFirstName().isEmpty())  builder.setFirstname(users.getFirstName());
        if(users.getLastName()!= null && !users.getLastName().isEmpty())    builder.setLastname(users.getLastName());
        if(users.getEmail() != null && !users.getEmail().isEmpty())  builder.setEmail(users.getEmail());
        return builder.build();
    }

    public static ServerClient.CandidateFullInfo candidatesToProto(Candidates candidates){
        ServerClient.CandidateFullInfo.Builder builder = ServerClient.CandidateFullInfo.newBuilder();
        ServerClient.UserFullInfo.Builder newBuilder = ServerClient.UserFullInfo.newBuilder();

        if(candidates.getUserID() != null)  newBuilder.setUserID(candidates.getUserID());
        if(candidates.getUsername() != null  && !candidates.getUsername().isEmpty())    newBuilder.setUsername(candidates.getUsername());
        if(candidates.getPassword_hashed() != null  && !candidates.getPassword_hashed().isEmpty())    newBuilder.setPasswordHashed(candidates.getPassword_hashed());
        if(candidates.getFirstName() != null  && !candidates.getFirstName().isEmpty())    newBuilder.setFirstname(candidates.getFirstName());
        if(candidates.getLastName() != null  && !candidates.getLastName().isEmpty())    newBuilder.setLastname(candidates.getLastName());
        if(candidates.getEmail() != null  && !candidates.getEmail().isEmpty())    newBuilder.setEmail(candidates.getEmail());
        builder.setUser(newBuilder.build());

        if(candidates.getBirthDate() != null)   builder.setBirthDate(Converter.timesToProto(candidates.getBirthDate()));
        if(candidates.getGender() != null)  builder.setGender(candidates.getGender().toProto());
        if (candidates.getCurrentCVs() != null) {
            builder.putAllCurrentCVs(convertHashSetToMap(candidates.getCurrentCVs()));
        }
        return builder.build();
    }

    public static ServerClient.RecruiterFullInfo recruiterToProto(Recruiters recruiters){
        ServerClient.RecruiterFullInfo.Builder builder = ServerClient.RecruiterFullInfo.newBuilder();
        ServerClient.UserFullInfo.Builder newBuilder = ServerClient.UserFullInfo.newBuilder();

        if(recruiters.getUserID() != null)  newBuilder.setUserID(recruiters.getUserID());
        if(recruiters.getUsername() != null  && !recruiters.getUsername().isEmpty())    newBuilder.setUsername(recruiters.getUsername());
        if(recruiters.getPassword_hashed() != null  && !recruiters.getPassword_hashed().isEmpty())    newBuilder.setPasswordHashed(recruiters.getPassword_hashed());
        if(recruiters.getFirstName() != null  && !recruiters.getFirstName().isEmpty())    newBuilder.setFirstname(recruiters.getFirstName());
        if(recruiters.getLastName() != null  && !recruiters.getLastName().isEmpty())    newBuilder.setLastname(recruiters.getLastName());
        if(recruiters.getEmail() != null  && !recruiters.getEmail().isEmpty())    newBuilder.setEmail(recruiters.getEmail());
        builder.setUser(newBuilder.build());

        builder.setUser(newBuilder.build());
        if(recruiters.getBranchID() != null && recruiters.getBranchID() != 0)   builder.setBranchID(recruiters.getBranchID());
        if(recruiters.getRoleLevel() != null && recruiters.getRoleLevel() != 0)     builder.setRoleLevel(recruiters.getRoleLevel());
        if(recruiters.getDepartmentName() != null && !recruiters.getDepartmentName().isEmpty())  builder.setDepartmentName(recruiters.getDepartmentName());

        if(recruiters.getValidated() != null)
            builder.setValidated(recruiters.getValidated());
        return builder.build();
    }

    public static ServerClient.CompanyFullInfo companiesToProto(Companies companies){
        ServerClient.CompanyFullInfo.Builder builder = ServerClient.CompanyFullInfo.newBuilder();

        if(companies.getCompaniesID() != 0)     builder.setCompaniesID(companies.getCompaniesID());
        if(companies.getCompanyName() != null && !companies.getCompanyName().isEmpty())     builder.setCompanyName(companies.getCompanyName());

        if(companies.getImagePath() != null && !companies.getImagePath().isEmpty())     builder.setImagePath(companies.getImagePath());
        if(companies.getSpecialty() != null && !companies.getSpecialty().isEmpty())     builder.setSpecialty(companies.getSpecialty());
        if(companies.getSize() != null && !companies.getSize().isEmpty())   builder.setSize(companies.getSize());
        if(companies.getIntroduction() != null && !companies.getIntroduction().isEmpty())   builder.setIntroduction(companies.getIntroduction());

        if(companies.getAddress() != null && !companies.getAddress().isEmpty())  builder.setAddress(companies.getAddress());
        if(companies.getWebsite() != null && !companies.getWebsite().isEmpty())  builder.setWebsite(companies.getWebsite());
        if(companies.getEmail() != null && !companies.getEmail().isEmpty())  builder.setEmail(companies.getEmail());

        if (companies.getActiveBranchs() != null) {
            builder.putAllActiveBranchs(
                    convertHashSetToMap((HashSet<Integer>) companies.getActiveBranchs())
            );
        }
        if(companies.getValidated() != null)
            builder.setValidated(companies.getValidated());
        return builder.build();
    }

    public static ServerClient.JobRequestFullInfo jobRequestsToFullProto(JobRequests jobRequest) {
        ServerClient.JobRequestFullInfo.Builder builder = ServerClient.JobRequestFullInfo.newBuilder();

        if(jobRequest.getJobID() != null && jobRequest.getJobID() != 0)    builder.setJobID(jobRequest.getJobID());
        if(jobRequest.getBranchID() != null && jobRequest.getBranchID() != 0)  builder.setBranchID(jobRequest.getBranchID());

        if(jobRequest.getTitle() != null && !jobRequest.getTitle().isEmpty())   builder.setTitle(jobRequest.getTitle());
        if(jobRequest.getWorktime() != null && !jobRequest.getWorktime().isEmpty())     builder.setWorktime(jobRequest.getWorktime());
        if(jobRequest.getJobField() != null && !jobRequest.getJobField().isEmpty())     builder.setJobField(jobRequest.getJobField());
        if(jobRequest.getLocationID() != null && jobRequest.getLocationID() != 0)   builder.setLocationID(jobRequest.getLocationID());
        if(jobRequest.getJobType() != null)    builder.setJobType(ServerClient.JobType.valueOf(jobRequest.getJobType().name()));
        if(jobRequest.getSalaryLeast() != null && jobRequest.getSalaryLeast() != 0)builder.setSalaryLeast(jobRequest.getSalaryLeast());
        if(jobRequest.getSalaryGreatest() != null && jobRequest.getSalaryGreatest() != 0)    builder.setSalaryGreatest(jobRequest.getSalaryGreatest());
        if (jobRequest.getDeadlineDate() != null) {
            Long deadlineLong = jobRequest.getDeadlineDate().getTime();
            builder.setDeadlineDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(deadlineLong / 1000)
                    .setNanos((int) (deadlineLong % 1000) * 1000000)
                    .build());
        }

        if (jobRequest.getJobTitle() != null && !jobRequest.getJobTitle().isEmpty())   builder.setJobTitle(jobRequest.getJobTitle());
        if (jobRequest.getJobLevel() != null)   builder.setJobLevel(ServerClient.JobLevel.valueOf(jobRequest.getJobLevel().name()));
        if (jobRequest.getJobDescription() != null && !jobRequest.getJobDescription().isEmpty())    builder.setJobDescription(jobRequest.getJobDescription());
        if (jobRequest.getJobRequirement() != null && !jobRequest.getJobRequirement().isEmpty())    builder.setJobRequirement(jobRequest.getJobRequirement());
        if (jobRequest.getJobBenefit() != null && !jobRequest.getJobBenefit().isEmpty())    builder.setJobBenefit(jobRequest.getJobBenefit());

        if (jobRequest.getGroupID() != null)    builder.setGroupID(jobRequest.getGroupID());
        if (jobRequest.getCurrentCVs() != null)     builder.putAllCurrentCVs(convertHashSetToMap(jobRequest.getCurrentCVs()));

        return builder.build();
    }

    public static ServerClient.LocationFullInfo locationsToFullProto(Locations locations) {
        ServerClient.LocationFullInfo.Builder builder = ServerClient.LocationFullInfo.newBuilder();
        if (locations.getLocationID() != 0) builder.setLocationID(locations.getLocationID());
        if (locations.getLocationName() != null && !locations.getLocationName().isEmpty()) builder.setLocationName(locations.getLocationName());
        return builder.build();
    }

    public static ServerClient.CertificationFullInfo certificationsToFullProto(Certifications certifications) {
        ServerClient.CertificationFullInfo.Builder builder = ServerClient.CertificationFullInfo.newBuilder();
        if(certifications.getCertificationID()!=0)  builder.setCertificationID(certifications.getCertificationID());
        if (certifications.getCVID() != 0)  builder.setCVID(certifications.getCVID());
        if (certifications.getCertificationName() != null && !certifications.getCertificationName().isEmpty())  builder.setCertificationName(certifications.getCertificationName());
        if (certifications.getProvider() != null && !certifications.getProvider().isEmpty())    builder.setProvider(certifications.getProvider());
        if (certifications.getProvidedDate() != null) {
            Long providedDateLong = certifications.getProvidedDate().getTime();
            builder.setProvidedDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(providedDateLong / 1000)
                    .setNanos((int) (providedDateLong % 1000) * 1000000)
                    .build());
        }
        return builder.build();
    }

    public static ServerClient.EducationFullInfo educationsToFullProto(Educations educations){
        ServerClient.EducationFullInfo.Builder builder = ServerClient.EducationFullInfo.newBuilder();
        if(educations.getCVID() != 0)       builder.setCVID(educations.getCVID());
        if(educations.getEducationID() !=0)     builder.setEducationID(educations.getEducationID());
        if(educations.getDegree() != null && !educations.getDegree().isEmpty())     builder.setDegree(educations.getDegree());
        if(educations.getEduFields() != null && !educations.getEduFields().isEmpty())     builder.setEduFields(educations.getEduFields());
        if(educations.getEduDescription() != null && !educations.getEduDescription().isEmpty())     builder.setEduDescription(educations.getEduDescription());
        if(educations.getStartDate() != null){
            Long startDateLong = educations.getStartDate().getTime();
            builder.setStartDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(startDateLong / 1000)
                    .setNanos((int) (startDateLong % 1000) * 1000000)
                    .build());
        }
        if(educations.getEndDate() != null){
            Long endDateLong = educations.getEndDate().getTime();
            builder.setStartDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(endDateLong / 1000)
                    .setNanos((int) (endDateLong % 1000) * 1000000)
                    .build());
        }
        return builder.build();
    }

    public static ServerClient.PersonalityFullInfo personalitiesToFullProto(Personalities personalities){
        ServerClient.PersonalityFullInfo.Builder builder = ServerClient.PersonalityFullInfo.newBuilder();
        if(personalities.getCVID() != 0 && personalities.getCVID() != null)     builder.setCVID(personalities.getCVID());
        if(personalities.getPersonalityID() != 0 && personalities.getPersonalityID() != null)     builder.setPersonalityID(personalities.getPersonalityID());
        if(personalities.getPersonalityName() != null&& !personalities.getPersonalityName().isEmpty())      builder.setPersonalityName(personalities.getPersonalityName());
        if(personalities.getDetail() != null && !personalities.getDetail().isEmpty())       builder.setDetail(personalities.getDetail());
        return builder.build();
    }

    public static ServerClient.SkillFullInfo skillsToFullProto(Skills skills){
        ServerClient.SkillFullInfo.Builder builder = ServerClient.SkillFullInfo.newBuilder();
        if(skills.getCVID() != null && skills.getCVID() != 0)
            builder.setCVID(skills.getCVID());
        if(skills.getSkillID() != null && skills.getSkillID() !=0)
            builder.setSkillID(skills.getSkillID());
        if(skills.getSkillName() != null && !skills.getSkillName().isEmpty())
            builder.setSkillName(skills.getSkillName());
        if (skills.getProficiency() != null)        builder.setProficiency(ServerClient.Proficiency.valueOf(skills.getProficiency().getDisplayName()));
        return builder.build();
    }

    public static ServerClient.WorkExperienceFullInfo workExpToFullProto(WorkExperiences workExperiences){
        ServerClient.WorkExperienceFullInfo.Builder builder = ServerClient.WorkExperienceFullInfo.newBuilder();
        if(workExperiences.getCVID() != null && workExperiences.getCVID() != 0)
            builder.setCVID(workExperiences.getCVID());
        if(workExperiences.getWorkExperienceID() != null && workExperiences.getWorkExperienceID() !=0)
            builder.setWorkExperienceID(workExperiences.getWorkExperienceID());
        if(workExperiences.getJobTitle() != null && !workExperiences.getJobTitle().isEmpty())
            builder.setJobTitle(workExperiences.getJobTitle());
        if(workExperiences.getJobDescription() != null  && !workExperiences.getJobDescription().isEmpty())
            builder.setJobDescription(workExperiences.getJobDescription());
        if(workExperiences.getCompanyName() != null && !workExperiences.getCompanyName().isEmpty())
            builder.setCompanyName(workExperiences.getCompanyName());

        if(workExperiences.getStartDate() != null){
            Long startDateLong = workExperiences.getStartDate().getTime();
            builder.setStartDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(startDateLong / 1000)
                    .setNanos((int) (startDateLong % 1000) * 1000000)
                    .build());
        }
        if(workExperiences.getEndDate() != null){
            Long endDateLong = workExperiences.getEndDate().getTime();
            builder.setEndDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(endDateLong / 1000)
                    .setNanos((int) (endDateLong % 1000) * 1000000)
                    .build());
        }
        return builder.build();
    }

    public static ServerClient.ProjectFullInfo projectToProto(Projects projects){
        ServerClient.ProjectFullInfo.Builder builder = ServerClient.ProjectFullInfo.newBuilder();

        if(projects.getProjectID() != null && projects.getProjectID() != 0)     builder.setProjectID(projects.getProjectID());
        if(projects.getCVID() != null  && projects.getCVID() != 0)      builder.setCVID(builder.getCVID());
        if(projects.getStartDate() != null){
            Long startDateLong = projects.getStartDate().getTime();
            builder.setStartDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(startDateLong / 1000)
                    .setNanos((int) (startDateLong % 1000) * 1000000)
                    .build());
        }
        if(projects.getEndDate() != null){
            Long endDateLong = projects.getEndDate().getTime();
            builder.setStartDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(endDateLong / 1000)
                    .setNanos((int) (endDateLong % 1000) * 1000000)
                    .build());
        }
        if(projects.getProjectName() != null && !projects.getProjectName().isEmpty())     builder.setProjectName(projects.getProjectName());
        if(projects.getPJRole() != null && !projects.getPJRole().isEmpty())     builder.setPJRole(projects.getPJRole());
        if(projects.getTechnology() != null && !projects.getTechnology().isEmpty())     builder.setTechnology(projects.getTechnology());
        if(projects.getPJDescription() != null && !projects.getPJDescription().isEmpty())     builder.setPJDescription(projects.getPJDescription());
        return builder.build();
    }

    public static ServerClient.AppliesInfo applyToProto(Applies applies){
        ServerClient.AppliesInfo.Builder builder = ServerClient.AppliesInfo.newBuilder();

        if(applies.getJobID() != null && applies.getJobID() != 0)   builder.setJobID(applies.getJobID());
        if(applies.getJobID() != null && applies.getJobID() != 0)   builder.setJobID(applies.getJobID());
        if(applies.getStatus() != null)     builder.setStatus(ServerClient.Status.valueOf(applies.getStatus().getDisplayName()));
        return builder.build();
    }

    public static ServerClient.CVFullInfo CVToFullProto(CVs CV){
        ServerClient.CVFullInfo.Builder builder = ServerClient.CVFullInfo.newBuilder();

        if(CV.getCVID() != null && CV.getCVID() !=0)    builder.setCVID(CV.getCVID());
        if(CV.getCandidatesID() != null && CV.getCandidatesID() !=0)    builder.setCandidateID(CV.getCandidatesID());

        if(CV.getCVname() != null  && !CV.getCVname().isEmpty())    builder.setCVname(CV.getCVname());
        if(CV.getImagePath() != null  && !CV.getImagePath().isEmpty())      builder.setImagePath(CV.getImagePath());
        if(CV.getJobPositions() != null  && !CV.getJobPositions().isEmpty())    builder.setJobPositions(CV.getJobPositions());
        if(CV.getIntroduce() != null  && !CV.getIntroduce().isEmpty())    builder.setIntroduce(CV.getIntroduce());

        if(CV.getEmail() != null  && !CV.getEmail().isEmpty())      builder.setEmail(CV.getEmail());
        if(CV.getPhoneNumber() != null  && !CV.getPhoneNumber().isEmpty())  builder.setPhoneNumber(CV.getPhoneNumber());
        if(CV.getSocialMedia() != null  && !CV.getSocialMedia().isEmpty())  builder.setSocialMedia(CV.getSocialMedia());


        if (CV.getCurrentProjects() != null)    builder.putAllCurrentProjects(convertHashSetToMap(CV.getCurrentProjects()));
        if (CV.getCurrentPersonalities() != null)   builder.putAllCurrentPersonalities(convertHashSetToMap(CV.getCurrentPersonalities()));
        if (CV.getCurrentSkills() != null)  builder.putAllCurrentSkills(convertHashSetToMap(CV.getCurrentSkills()));
        if (CV.getCurrentWorkExperiences() != null)     builder.putAllCurrentWorkExperiences(convertHashSetToMap(CV.getCurrentWorkExperiences()));
        if (CV.getCurrentEducations() != null)      builder.putAllCurrentEducations(convertHashSetToMap(CV.getCurrentEducations()));
        if (CV.getCurrentCertifications() != null)  builder.putAllCurrentCertifications(convertHashSetToMap(CV.getCurrentCertifications()));
        if (CV.getCurrentAwards() != null)  builder.putAllCurrentAwards(convertHashSetToMap(CV.getCurrentAwards()));
        return builder.build();
    }

    public static ServerClient.BranchFullInfo branchToFullProto(Branchs branchs){
        ServerClient.BranchFullInfo.Builder builder = ServerClient.BranchFullInfo.newBuilder();

        if(branchs.getBranchID() != null && branchs.getBranchID() !=0)  builder.setBranchID(branchs.getBranchID());
        if(branchs.getCompanyID() != null && branchs.getCompanyID() != 0)   builder.setCompanyID(branchs.getCompanyID());
        if(branchs.getBranchName() != null && !branchs.getBranchName().isEmpty())   builder.setBranchName(branchs.getBranchName());
        if(branchs.getAddress() != null && !branchs.getAddress().isEmpty())   builder.setAddress(branchs.getAddress());
        if(branchs.getContact() != null && !branchs.getContact().isEmpty())   builder.setContact(branchs.getContact());
        if(branchs.getImagePath() != null && !branchs.getImagePath().isEmpty())   builder.setImagePath(branchs.getImagePath());

        if(branchs.getActiveRecruiters() != null)   builder.putAllCurrentRecruiter(Converter.convertHashSetToMap(branchs.getActiveRecruiters()));
        if(branchs.getActiveJobs() != null)     builder.putAllCurrentJobRequest(Converter.convertHashSetToMap(branchs.getActiveJobs()));
        return builder.build();
    }

    public static ServerClient.AwardFullInfo awardToFullProto(Awards awards){
        ServerClient.AwardFullInfo.Builder builder = ServerClient.AwardFullInfo.newBuilder();

        if(awards.getAwardID() != null && awards.getAwardID() != 0 )    builder.setAwardID(awards.getAwardID());
        if(awards.getAwardName() != null && !awards.getAwardName().isEmpty())   builder.setAwardName(awards.getAwardName());
        if(awards.getCVID() != null && awards.getCVID() != 0)   builder.setCVID(awards.getCVID());
        if(awards.getProvideDate() != null)     builder.setProvideDate(Converter.timesToProto(awards.getProvideDate()));
        return builder.build();
    }
}