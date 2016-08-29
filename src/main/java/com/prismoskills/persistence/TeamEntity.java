package com.prismoskills.persistence;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name="Teams")
@AttributeOverride( name="id", column = @Column(name="team_id"))
public class TeamEntity extends BaseEntity {

    @Column(name="name")
    String name;

    @Column(name="started")
    Date started;

    @Column(name="brief_description")
    String briefDescription;

    @Column(name="team_homepage")
    String teamHomepage;

    // Constructors
    public TeamEntity() {
    }

    public TeamEntity(String name, Date started, String briefDescription, String teamHomepage) {
        super();
        this.name = name;
        this.started = started;
        this.briefDescription = briefDescription;
        this.teamHomepage = teamHomepage;
    }

    // Getter setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getTeamHomepage() {
        return teamHomepage;
    }

    public void setTeamHomepage(String teamHomepage) {
        this.teamHomepage = teamHomepage;
    }
}
