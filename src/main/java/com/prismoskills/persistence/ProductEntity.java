package com.prismoskills.persistence;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name="Products")
@AttributeOverride( name="id", column = @Column(name="product_id"))
public class ProductEntity extends BaseEntity {

    @Column(name="name")
    String name;

    @Column(name="started")
    Date started;

    @Column(name="brief_description")
    String briefDescription;

    @Column(name="product_email")
    String productEmail;

    @Column(name="slack_channel")
    String slackChannel;

    @Column(name="jira_link")
    String jiraLink;

    @Column(name="detailed_docs_url")
    String detailedDocsUrl;

    @Column(name="github_repos")
    String githubRepos;

    @Column(name="quick_start_example_links")
    String quickStartExampleLinks;

    // Constructors
    public ProductEntity() {
    }

    public ProductEntity(String name, Date started, String briefDescription,
            String productEmail, String slackChannel,
            String jiraLink, String detailedDocsUrl,
            String githubRepos, String quickStartExampleLinks) {
        super();
        this.name = name;
        this.started = started;
        this.briefDescription = briefDescription;
        this.productEmail = productEmail;
        this.slackChannel = slackChannel;
        this.jiraLink = jiraLink;
        this.detailedDocsUrl = detailedDocsUrl;
        this.githubRepos = githubRepos;
        this.quickStartExampleLinks = quickStartExampleLinks;
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

    public String getProductEmail() {
        return productEmail;
    }

    public void setProductEmail(String productEmail) {
        this.productEmail = productEmail;
    }

    public String getSlackChannel() {
        return slackChannel;
    }

    public void setSlackChannel(String slackChannel) {
        this.slackChannel = slackChannel;
    }

    public String getJiraLink() {
        return jiraLink;
    }

    public void setJiraLink(String jiraLink) {
        this.jiraLink = jiraLink;
    }

    public String getDetailedDocsUrl() {
        return detailedDocsUrl;
    }

    public void setDetailedDocsUrl(String detailedDocsUrl) {
        this.detailedDocsUrl = detailedDocsUrl;
    }

    public String getGithubRepos() {
        return githubRepos;
    }

    public void setGithubRepos(String githubRepos) {
        this.githubRepos = githubRepos;
    }

    public String getQuickStartExampleLinks() {
        return quickStartExampleLinks;
    }

    public void setQuickStartExampleLinks(String quickStartExampleLinks) {
        this.quickStartExampleLinks = quickStartExampleLinks;
    }
}
