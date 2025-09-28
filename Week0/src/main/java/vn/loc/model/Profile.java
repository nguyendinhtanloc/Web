package vn.loc.model;

import java.util.List;

public class Profile {
    private String fullName;
    private String headline;
    private String bio;
    private String email;
    private List<SocialLink> socials;
    private List<Project> projects;

    // Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getHeadline() { return headline; }
    public void setHeadline(String headline) { this.headline = headline; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<SocialLink> getSocials() { return socials; }
    public void setSocials(List<SocialLink> socials) { this.socials = socials; }
    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }
}