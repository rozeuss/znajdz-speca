package com.example.model.Job;

import com.example.model.Client.Client;
import com.example.model.Company.Company;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public")
    @SequenceGenerator(name = "public", sequenceName = "job_seq", initialValue = 1, allocationSize = 1)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private Boolean visible;

    @ManyToOne
    @JoinColumn(name = "companyId",
                referencedColumnName = "ID")
    private Company company;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clientId",
                referencedColumnName = "ID")
    private Client client;

    @Size(max = 1024)
    private String description;

    private Date beginDate;
    private Date endDate;
    private Date addedAt;
    private String localization;

    public Job() {
    }

    public Job(String title, Date beginDate, Date endDate, Date addedAt, Boolean visible, String localization, Client client) {
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.addedAt = addedAt;
        this.visible = visible;
        this.localization = localization;
        this.client = client;
    }

    public Job(String title, Date beginDate, Date endDate, Date addedAt, Boolean visible, String localization, Company company, Client client, String descript) {
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.addedAt = addedAt;
        this.visible = visible;
        this.localization = localization;
        this.company = company;
        this.client = client;
        this.description = descript;
    }

    public Job(JobRequest request) {
        this.title = request.getTitle();
        this.beginDate = request.getBeginDateC();
        this.endDate = request.getEndDateC();
        this.localization = request.getLocalization();
        this.description = request.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", addedAt=" + addedAt +
                ", visible=" + visible +
                ", company=" + company +
                ", client=" + client +
                ", description='" + description + '\'' +
                '}';
    }
}
