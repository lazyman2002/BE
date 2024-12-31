package org.controller;

import org.model.*;
import proto.ServerClient;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class Converter {
    public static List<Integer> protoMapToList(Map<Integer, Boolean> currentMap) {
        List<Integer> cvidList = new ArrayList<>();
//        Map<Integer, Boolean> currentCVsMap = jobRequest.getCurrentCVsMap();

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

    public static ServerClient.UserMetaInfo userFullToMeta(ServerClient.UserFullInfo userFullInfo){
        ServerClient.UserMetaInfo.Builder builder = ServerClient.UserMetaInfo.newBuilder();
        if(userFullInfo.getUserID() !=0)    builder.setUserID(userFullInfo.getUserID());
        if(userFullInfo.getUsername() != null && !userFullInfo.getUsername().isEmpty())    builder.setUsername(userFullInfo.getUsername());
        if(userFullInfo.getPassword() != null && !userFullInfo.getPassword().isEmpty())    builder.setPassword(userFullInfo.getPassword());
        return builder.build();
    }

    public static ServerClient.UserFullInfo usersToProto(Users users){
        ServerClient.UserFullInfo.Builder builder = ServerClient.UserFullInfo.newBuilder();
        if(users.getUserID() != 0)  builder.setUserID(users.getUserID());
        if(users.getUsername() != null && !users.getUsername().isEmpty())    builder.setUsername(users.getUsername());
        if(users.getPassword_hashed() != null && !users.getPassword_hashed().isEmpty())  builder.setPassword(users.getPassword_hashed());
        if(users.getFirstName() != null && !users.getFirstName().isEmpty())  builder.setFirstname(users.getFirstName());
        if(users.getLastName()!= null && !users.getLastName().isEmpty())    builder.setLastname(users.getLastName());
        if(users.getEmail() != null && !users.getEmail().isEmpty())  builder.setEmail(users.getEmail());
        if(users.getGoogleToken() != null && !users.getGoogleToken().isEmpty())  builder.setGoogleToken(users.getGoogleToken());
        if(users.getGoogleTokenExpiration() != null && users.getGoogleTokenExpiration().getTime() > 0)  builder.setGoogleTokenExpiration(Converter.timesToProto(users.getGoogleTokenExpiration()));
        return builder.build();
    }

    public static ServerClient.CandidateFullInfo candidatesToProto(Candidates candidates){
        ServerClient.CandidateFullInfo.Builder candidate = ServerClient.CandidateFullInfo.newBuilder();
        ServerClient.UserFullInfo.Builder user = ServerClient.UserFullInfo.newBuilder();

        if(candidates.getUserID() != null)  user.setUserID(candidates.getUserID());
        if(candidates.getUsername() != null && !candidates.getUsername().isEmpty())  user.setUsername(candidates.getUsername());
        if(candidates.getPassword_hashed() != null && !candidates.getPassword_hashed().isEmpty()) user.setPassword(candidates.getPassword_hashed());
        if(candidates.getFirstName() != null && !candidates.getFirstName().isEmpty()) user.setFirstname(candidates.getFirstName());
        if(candidates.getLastName() != null && !candidates.getLastName().isEmpty()) user.setLastname(candidates.getLastName());
        if(candidates.getEmail() != null && !candidates.getEmail().isEmpty()) user.setEmail(candidates.getEmail());
        if(candidates.getGoogleToken() != null)     if(!candidates.getGoogleToken().isEmpty()) user.setGoogleToken(candidates.getGoogleToken());
        if(candidates.getGoogleTokenExpiration() != null)       if(candidates.getGoogleTokenExpiration().getTime() > 0) user.setGoogleTokenExpiration(Converter.timesToProto(candidates.getGoogleTokenExpiration()));
        user.setIsCandidate(true);

        candidate.setUser(user.build());
        if(candidates.getBirthDate() != null)   candidate.setBirthDate(Converter.timesToProto(candidates.getBirthDate()));
        if(candidates.getGender() != null)  candidate.setGender(candidates.getGender().toProto());

        if (candidates.getCurrentCVs() != null) {
            candidate.putAllCurrentCVs(convertHashSetToMap(candidates.getCurrentCVs()));
        }

        return candidate.build();
    }

    public static ServerClient.RecruiterFullInfo recruiterToProto(Recruiters recruiters){
        ServerClient.RecruiterFullInfo.Builder recruiter = ServerClient.RecruiterFullInfo.newBuilder();
        ServerClient.UserFullInfo.Builder user = ServerClient.UserFullInfo.newBuilder();

        if(recruiters.getUserID() != 0)  user.setUserID(recruiters.getUserID());
        if(recruiters.getUsername() != null && !recruiters.getUsername().isEmpty())  user.setUsername(recruiters.getUsername());
        if(recruiters.getPassword_hashed() != null && !recruiters.getPassword_hashed().isEmpty()) user.setPassword(recruiters.getPassword_hashed());
        if(recruiters.getFirstName() != null && !recruiters.getFirstName().isEmpty()) user.setFirstname(recruiters.getFirstName());
        if(recruiters.getLastName() != null && !recruiters.getLastName().isEmpty()) user.setLastname(recruiters.getLastName());
        if(recruiters.getEmail() != null && !recruiters.getEmail().isEmpty()) user.setEmail(recruiters.getEmail());
        if(recruiters.getGoogleToken() != null)     if(!recruiters.getGoogleToken().isEmpty()) user.setGoogleToken(recruiters.getGoogleToken());
        if(recruiters.getGoogleTokenExpiration() != null)       if(recruiters.getGoogleTokenExpiration().getTime() > 0) user.setGoogleTokenExpiration(Converter.timesToProto(recruiters.getGoogleTokenExpiration()));
        user.setIsCandidate(false);

        recruiter.setUser(user.build());
        if(recruiters.getCompanyID() != 0)  recruiter.setCompanyID(recruiters.getCompanyID());
        if(recruiters.getRoleID() != 0) recruiter.setRoleID(recruiters.getRoleID());
        if(recruiters.getDepartmentName() != null && !recruiters.getDepartmentName().isEmpty())  recruiter.setDepartmentName(recruiters.getDepartmentName());
        return recruiter.build();
    }

    public static ServerClient.CompanyFullInfo companiesToProto(Companies companies){
        ServerClient.CompanyFullInfo.Builder builder = ServerClient.CompanyFullInfo.newBuilder();

        if(companies.getCompaniesID() != 0)  builder.setCompaniesID(companies.getCompaniesID());
        if(companies.getCompanyName() != null && !companies.getCompanyName().isEmpty())  builder.setCompanyName(companies.getCompanyName());
        if(companies.getCompanyAvatarURL() != null && !companies.getCompanyAvatarURL().isEmpty())    builder.setCompanyAvatarURL(companies.getCompanyAvatarURL());
        if(companies.getWebsite() != null && !companies.getWebsite().isEmpty())  builder.setWebsite(companies.getWebsite());
        if(companies.getEmail() != null && !companies.getEmail().isEmpty())  builder.setEmail(companies.getEmail());
        if (companies.getActiveLocations() != null) {
            builder.putAllActiveLocations(
                    convertHashSetToMap((HashSet<Integer>) companies.getActiveLocations())
            );
        }
        if (companies.getActiveRecruiters() != null) {
            builder.putAllActiveRecruiters(
                    convertHashSetToMap((HashSet<Integer>) companies.getActiveRecruiters())
            );
        }
        return builder.build();
    }

    public static ServerClient.RoleFullInfo rolesToProto(Roles roles){
        ServerClient.RoleFullInfo.Builder builder = ServerClient.RoleFullInfo.newBuilder();
        if(roles.getRoleID() != 0)  builder.setRoleID(roles.getRoleID());
        if(roles.getRoleLevel() != 0)  builder.setRoleLevel(roles.getRoleLevel());
        if(roles.getCompanyID() != 0)   builder.setCompanyID(roles.getCompanyID());
        if(roles.getRoleName() != null && !roles.getRoleName().isEmpty()) builder.setRoleName(roles.getRoleName());
        return builder.build();
    }

    public static ServerClient.JobRequestFullInfo jobRequestsToFullProto(JobRequests jobRequest) {
        ServerClient.JobRequestFullInfo.Builder builder = ServerClient.JobRequestFullInfo.newBuilder();

        if (jobRequest.getJobID() != 0) {
            builder.setJobID(jobRequest.getJobID());
        }
        if (jobRequest.getLocationID() != 0) {
            builder.setLocationID(jobRequest.getLocationID());
        }
        if (jobRequest.getJobType() != null) {
            builder.setJobType(ServerClient.JobType.valueOf(jobRequest.getJobType().name()));
        }
        if (jobRequest.getSalaryLeast() != 0) {
            builder.setSalaryLeast(jobRequest.getSalaryLeast());
        }
        if (jobRequest.getSalaryGreatest() != 0) {
            builder.setSalaryGreatest(
                    jobRequest.getSalaryGreatest());
        }
        if (jobRequest.getCurrency() != null && !jobRequest.getCurrency().isEmpty()) {
            builder.setCurrency(jobRequest.getCurrency());
        }
        if (jobRequest.getJobTitle() != null) {
            builder.setJobTitle(jobRequest.getJobTitle());
        }
        if (jobRequest.getJobLevel() != null) {
            builder.setJobLevel(ServerClient.JobLevel.valueOf(jobRequest.getJobLevel().name()));
        }
        if (jobRequest.getJobDescription() != null) {
            builder.setJobDescription(jobRequest.getJobDescription());
        }
        if (jobRequest.getDeadlineDate() != null) {
            Timestamp deadlineTimestamp = new Timestamp(jobRequest.getDeadlineDate().getTime());
            builder.setDeadlineDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(deadlineTimestamp.getTime() / 1000)
                    .setNanos((int) (deadlineTimestamp.getTime() % 1000) * 1000000)
                    .build());
        }

        if (jobRequest.getCurrentCVs() != null) {
            builder.putAllCurrentCVs(convertHashSetToMap(jobRequest.getCurrentCVs()));
        }

        return builder.build();
    }

    public static ServerClient.LocationFullInfo locationsToFullProto(Locations locations) {
        ServerClient.LocationFullInfo.Builder builder = ServerClient.LocationFullInfo.newBuilder();
        if (locations.getLocationID() != 0) builder.setLocationID(locations.getLocationID());
        if (locations.getCompanyID() != 0) builder.setCompanyID(locations.getCompanyID());
        if (locations.getCity() != null) builder.setCity(locations.getCity());
        if (locations.getState() != null) builder.setState(locations.getState());
        if (locations.getCountry() != null) builder.setCountry(locations.getCountry());
        if (locations.getAddress() != null) builder.setAddress(locations.getAddress());
        if (locations.getContactNumber() != null) builder.setContactNumber(locations.getContactNumber());
        if(locations.getCurrentJobRequest()!= null){
            builder.putAllCurrentJobRequest(locations.getCurrentJobRequest());
        }
        if (locations.getImagePath() != null && !locations.getImagePath().isEmpty()) builder.setImagePath(locations.getImagePath());

        return builder.build();
    }

    public static ServerClient.CertificationFullInfo certificationsToFullProto(Certifications certifications) {
        ServerClient.CertificationFullInfo.Builder builder = ServerClient.CertificationFullInfo.newBuilder();
        if(certifications.getCertificationID()!=0)
            builder.setCertificationID(certifications.getCertificationID());
        if (certifications.getCVID() != 0)
            builder.setCVID(certifications.getCVID());
        if (certifications.getCertificationName() != null && !certifications.getCertificationName().isEmpty())
            builder.setCertificationName(certifications.getCertificationName());
        if (certifications.getProvider() != null && !certifications.getProvider().isEmpty())
            builder.setProvider(certifications.getProvider());
        if (certifications.getProvidedDate() != null) {
            Timestamp deadlineTimestamp = new Timestamp(certifications.getProvidedDate().getTime());
            builder.setProvidedDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(deadlineTimestamp.getTime() / 1000)
                    .setNanos((int) (deadlineTimestamp.getTime() % 1000) * 1000000)
                    .build());
        }
        return builder.build();
    }

    public static ServerClient.EducationFullInfo educationsToFullProto(Educations educations){
        ServerClient.EducationFullInfo.Builder builder = ServerClient.EducationFullInfo.newBuilder();
        if(educations.getCVID() != 0)   builder.setCVID(educations.getCVID());
        if(educations.getEducationID() !=0) builder.setEducationID(educations.getEducationID());
        if(educations.getDegree() != null && !educations.getDegree().isEmpty())
            builder.setDegree(educations.getDegree());
        if(educations.getFieldOfStudy() != null && !educations.getFieldOfStudy().isEmpty())
            builder.setField(educations.getFieldOfStudy());
        if(educations.getInstitution() != null && !educations.getInstitution().isEmpty())
            builder.setInstitution(educations.getInstitution());
        if(educations.getStartDate()!= null){
            Timestamp startDate = new Timestamp(educations.getStartDate().getTime());
            builder.setStartDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(startDate.getTime() / 1000)
                    .setNanos((int) (startDate.getTime() % 1000) * 1000000)
                    .build());
        }
        if(educations.getEndDate()!= null){
            Timestamp endDate = new Timestamp(educations.getEndDate().getTime());
            builder.setEndDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(endDate.getTime() / 1000)
                    .setNanos((int) (endDate.getTime() % 1000) * 1000000)
                    .build());
        }
        return builder.build();
    }

    public static ServerClient.PersonalityFullInfo personalitiesToFullProto(Personalities personalities){
        ServerClient.PersonalityFullInfo.Builder builder = ServerClient.PersonalityFullInfo.newBuilder();
        if(personalities.getCVID() != 0 && personalities.getCVID() != null)
            builder.setCVID(personalities.getCVID());
        if(personalities.getPersonalityTitle() != null&& !personalities.getPersonalityTitle().isEmpty())
            builder.setPersonalityTitle(personalities.getPersonalityTitle());
        if(personalities.getDetail() != null && !personalities.getDetail().isEmpty())
            builder.setDescription(personalities.getDetail());
        if(personalities.getPersonalityID() != 0 && personalities.getPersonalityID() != null)
            builder.setPersonalityID(personalities.getPersonalityID());
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
        if (skills.getProficiency() != null) {
            switch (skills.getProficiency()) {
                case BEGINNER:
                    builder.setProficiency(ServerClient.Proficiency.BEGINNER);
                    break;
                case INTERMEDIATE:
                    builder.setProficiency(ServerClient.Proficiency.INTERMEDIATE);
                    break;
                case EXPERT:
                    builder.setProficiency(ServerClient.Proficiency.EXPERT);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown proficiency: " + skills.getProficiency());
            }
        }
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

        if(workExperiences.getStartDate()!= null){
            Timestamp startDate = new Timestamp(workExperiences.getStartDate().getTime());
            builder.setStartDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(startDate.getTime() / 1000)
                    .setNanos((int) (startDate.getTime() % 1000) * 1000000)
                    .build());
        }
        if(workExperiences.getEndDate()!= null){
            Timestamp endDate = new Timestamp(workExperiences.getEndDate().getTime());
            builder.setEndDate(com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(endDate.getTime() / 1000)
                    .setNanos((int) (endDate.getTime() % 1000) * 1000000)
                    .build());
        }

        return builder.build();
    }

    public static ServerClient.CVFullInfo CVToFullProto(CVs CV){
        ServerClient.CVFullInfo.Builder builder = ServerClient.CVFullInfo.newBuilder();
        if(CV.getCVID() != null && CV.getCVID() !=0)
            builder.setCVID(CV.getCVID());
        if(CV.getCandidatesID() != null && CV.getCandidatesID() !=0)
            builder.setCandidateID(CV.getCandidatesID());
        if(CV.getEmail() != null  && !CV.getEmail().isEmpty())
            builder.setEmail(CV.getEmail());
        if(CV.getPhoneNumber() != null  && !CV.getPhoneNumber().isEmpty())
            builder.setPhoneNumber(CV.getPhoneNumber());
        if(CV.getJobTitle() != null  && !CV.getJobTitle().isEmpty())
            builder.setJobTitle(CV.getJobTitle());
        if(CV.getImagePath() != null  && !CV.getImagePath().isEmpty())
            builder.setImagePath(CV.getImagePath());
        if(CV.getCVname() != null && !CV.getCVname().isEmpty())
            builder.setCVname(CV.getCVname());

        if (CV.getCurrentSkills() != null) {
            builder.putAllCurrentSkills(convertHashSetToMap(CV.getCurrentSkills()));
        }
        if (CV.getCurrentPersonalities() != null) {
            builder.putAllCurrentPersonalities(convertHashSetToMap(CV.getCurrentPersonalities()));
        }
        if (CV.getCurrentWorkExperiences() != null) {
            builder.putAllCurrentWorkExperiences(convertHashSetToMap(CV.getCurrentWorkExperiences()));
        }
        if (CV.getCurrentEducations() != null) {
            builder.putAllCurrentEducations(convertHashSetToMap(CV.getCurrentEducations()));
        }
        if (CV.getCurrentCertifications() != null) {
            builder.putAllCurrentCertifications(convertHashSetToMap(CV.getCurrentCertifications()));
        }
        return builder.build();
    }
}