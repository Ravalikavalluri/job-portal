package com.dao.util;

public class JobApplicationDto {

    private int applicationID;
    private String emailID;
    private String companyname;
    private String jobTitle;
    private String JobDesc;
    private float JobPay;
    private int jobID;
    private int companyID;


    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDesc() {
        return JobDesc;
    }

    public void setJobDesc(String jobDesc) {
        JobDesc = jobDesc;
    }

    public float getJobpay() {
        return JobPay;
    }

    public void setJobpay(float jobpay) {
        JobPay = jobpay;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getCompanyID() { return companyID; }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }



}

