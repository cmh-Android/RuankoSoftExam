package com.itee.exam.app.entity;

/**
 * Created by YangGuoShan on 16/6/15 17:10.
 * Describe:
 */
public class ChooseCountryBean {
    private String country;
    private String code;
    private String sort;

    public String getSectionsTitle() {
        return sectionsTitle;
    }

    public void setSectionsTitle(String sectionsTitle) {
        this.sectionsTitle = sectionsTitle;
    }

    private String sectionsTitle;

    public String getRuankoId() {
        return ruankoId;
    }

    public void setRuankoId(String ruankoId) {
        this.ruankoId = ruankoId;
    }

    private String ruankoId;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
