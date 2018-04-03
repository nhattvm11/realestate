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
    private int userId;
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
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (typeId != article.typeId) return false;
        if (propertyId != article.propertyId) return false;
        if (cityId != article.cityId) return false;
        if (districtId != article.districtId) return false;
        if (contactId != article.contactId) return false;
        if (userId != article.userId) return false;
        if (address != null ? !address.equals(article.address) : article.address != null) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (areasize != null ? !areasize.equals(article.areasize) : article.areasize != null) return false;
        if (bedroom != null ? !bedroom.equals(article.bedroom) : article.bedroom != null) return false;
        if (bathroom != null ? !bathroom.equals(article.bathroom) : article.bathroom != null) return false;
        if (livingroom != null ? !livingroom.equals(article.livingroom) : article.livingroom != null) return false;
        if (tier != null ? !tier.equals(article.tier) : article.tier != null) return false;
        if (directionId != null ? !directionId.equals(article.directionId) : article.directionId != null) return false;
        if (price != null ? !price.equals(article.price) : article.price != null) return false;
        if (description != null ? !description.equals(article.description) : article.description != null) return false;
        if (priority != null ? !priority.equals(article.priority) : article.priority != null) return false;
        if (active != null ? !active.equals(article.active) : article.active != null) return false;
        if (view != null ? !view.equals(article.view) : article.view != null) return false;
        if (dateUp != null ? !dateUp.equals(article.dateUp) : article.dateUp != null) return false;
        if (dateExpire != null ? !dateExpire.equals(article.dateExpire) : article.dateExpire != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(article.lastUpdate) : article.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + typeId;
        result = 31 * result + propertyId;
        result = 31 * result + cityId;
        result = 31 * result + districtId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (areasize != null ? areasize.hashCode() : 0);
        result = 31 * result + (bedroom != null ? bedroom.hashCode() : 0);
        result = 31 * result + (bathroom != null ? bathroom.hashCode() : 0);
        result = 31 * result + (livingroom != null ? livingroom.hashCode() : 0);
        result = 31 * result + (tier != null ? tier.hashCode() : 0);
        result = 31 * result + (directionId != null ? directionId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (view != null ? view.hashCode() : 0);
        result = 31 * result + contactId;
        result = 31 * result + userId;
        result = 31 * result + (dateUp != null ? dateUp.hashCode() : 0);
        result = 31 * result + (dateExpire != null ? dateExpire.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
