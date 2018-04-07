package com.project.realestate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Article {
    private int id;
    private int typeId;
    private int propertyId;
    private int cityId;
    private int districtId;
    private String address;
    private String title;
    private BigDecimal areasize;
    private Integer bedroom;
    private Integer bathroom;
    private Integer livingroom;
    private Integer tier;
    private Integer directionId;
    private BigDecimal price;
    private String description;
    private Integer priority;
    private Boolean active;
    private Integer view;
    private int contactId;
    private String userId;
    private Date dateUp;
    private Date dateExpire;
    private Date lastUpdate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "typeId")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "propertyId")
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Basic
    @Column(name = "cityId")
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "districtId")
    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "areasize")
    public BigDecimal getAreasize() {
        return areasize;
    }

    public void setAreasize(BigDecimal areasize) {
        this.areasize = areasize;
    }

    @Basic
    @Column(name = "bedroom")
    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    @Basic
    @Column(name = "bathroom")
    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    @Basic
    @Column(name = "livingroom")
    public Integer getLivingroom() {
        return livingroom;
    }

    public void setLivingroom(Integer livingroom) {
        this.livingroom = livingroom;
    }

    @Basic
    @Column(name = "tier")
    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    @Basic
    @Column(name = "directionId")
    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "view")
    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    @Basic
    @Column(name = "contactId")
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "dateUp")
    public Date getDateUp() {
        return dateUp;
    }

    public void setDateUp(Date dateUp) {
        this.dateUp = dateUp;
    }

    @Basic
    @Column(name = "dateExpire")
    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    @Basic
    @Column(name = "lastUpdate")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}
