package com.joshkersting.pioneer.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="contractors")
public class Contractor extends AbstractEntity
{
    private String name;
    private String email, address, websiteUrl;
    private long phone;
    private List<Project> projects;

    public Contractor()
    {
    }

    public Contractor(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    @NotNull
    @Column(name="name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @NotNull
    @Column(name="email")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Column(name="address")
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Column(name="website_url")
    public String getWebsiteUrl()
    {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl)
    {
        this.websiteUrl = websiteUrl;
    }

    @Column(name="phone")
    public long getPhone()
    {
        return phone;
    }

    public void setPhone(long phone)
    {
        this.phone = phone;
    }

    @OneToMany(mappedBy="contractor", fetch = FetchType.LAZY)
    @JsonIdentityReference
    public List<Project> getProjects()
    {
        return projects;
    }

    public void setProjects(List<Project> projects)
    {
        this.projects = projects;
    }

    @Override
    public String toString()
    {
        return "Contractor{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + ", websiteUrl='" + websiteUrl + '\'' + ", phone=" + phone + ", projects=" + projects + '}';
    }
}
