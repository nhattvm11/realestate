package com.project.realestate.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class ArticleTemp {

    private String id;

    @NotEmpty(message = "Address is required")
    @Length(max = 50, message = "Adress could not be more than 50 charactors")
    private String address;
    @NotEmpty(message = "Address is required")
    @Length(max = 50, message = "Title could not be more than 50 charactors")
    private String title;
    @NotNull(message = "areasize is required")
    @Min(value = 20, message = "Minimum Area size is 20 m2")
    private BigDecimal areasize;
    @NotNull(message = "Bedroom is required")
    private Integer bedroom;
    @NotNull(message = "Bathroom is required")
    private Integer bathroom;
    @NotNull(message = "Living room is required")
    private Integer livingroom;
    @NotNull(message = "Tier is required")
    private Integer tier;
    @NotNull(message = "Price is required")
    @Min(value = 100000)
    private BigDecimal price;
    @NotNull(message = "Description is required")
    @Length(max = 500, message = "Maximum description is 500 charactor")
    private String description;
    private Integer priority;
    private Boolean active;
    private Integer view;
    private Integer contactId;
    private String typeId;
    private String propertyId;
    @NotNull(message = "City is required")
    private String cityId;
    @NotNull(message = "District is required")
    private String districtId;
    private String directionId;
    private List<String> features;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getAreasize() {
        return areasize;
    }

    public void setAreasize(BigDecimal areasize) {
        this.areasize = areasize;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public Integer getLivingroom() {
        return livingroom;
    }

    public void setLivingroom(Integer livingroom) {
        this.livingroom = livingroom;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDirectionId() {
        return directionId;
    }

    public void setDirectionId(String directionId) {
        this.directionId = directionId;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}
