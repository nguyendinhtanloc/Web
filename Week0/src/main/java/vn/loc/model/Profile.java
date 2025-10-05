package vn.loc.model;

import java.util.List;

public class Profile {
    private String fullName;
    private String headline;
    private String bio; 
    private String aboutMe; 
    private String email;
    private Education education;
    private List<String> skills;
    private List<SocialLink> socials;
    private List<Project> projects;

    // Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getHeadline() { return headline; }
    public void setHeadline(String headline) { this.headline = headline; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getAboutMe() { return aboutMe; }
    public void setAboutMe(String aboutMe) { this.aboutMe = aboutMe; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Education getEducation() { return education; }
    public void setEducation(Education education) { this.education = education; }
    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }
    public List<SocialLink> getSocials() { return socials; }
    public void setSocials(List<SocialLink> socials) { this.socials = socials; }
    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }
}