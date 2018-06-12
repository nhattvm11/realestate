package com.project.realestate.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Article {
    private String id;
    private String address;
    private String title;
    private BigDecimal areasize;
    private Integer bedroom;
    private Integer bathroom;
    private Integer livingroom;
    private Integer tier;
    private BigDecimal price;
    private String description;
    private Integer priority;
    private Boolean active;
    private Integer view;
    private Contact contactByContactId;
    private Date dateUp;
    private Date dateExpire;
    private Date lastUpdate;
    private Type typeByTypeId;
    private PropertyType propertyTypeByPropertyId;
    private City cityByCityId;
    private District districtByDistrictId;
    private Direction directionByDirectionId;
    private User userByUserId;
    private Collection<ArticleFeature> articleFeaturesById;
    private Collection<Picture> picturesById;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @ManyToOne
    @JoinColumn(name = "contactId", referencedColumnName = "id", nullable = false)
    public Contact getContactByContactId() {
        return contactByContactId;
    }

    public void setContactByContactId(Contact contactByContactId) {
        this.contactByContactId = contactByContactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != null ? !id.equals(article.id) : article.id != null) return false;
        if (address != null ? !address.equals(article.address) : article.address != null) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (areasize != null ? !areasize.equals(article.areasize) : article.areasize != null) return false;
        if (bedroom != null ? !bedroom.equals(article.bedroom) : article.bedroom != null) return false;
        if (bathroom != null ? !bathroom.equals(article.bathroom) : article.bathroom != null) return false;
        if (livingroom != null ? !livingroom.equals(article.livingroom) : article.livingroom != null) return false;
        if (tier != null ? !tier.equals(article.tier) : article.tier != null) return false;
        if (price != null ? !price.equals(article.price) : article.price != null) return false;
        if (description != null ? !description.equals(article.description) : article.description != null) return false;
        if (priority != null ? !priority.equals(article.priority) : article.priority != null) return false;
        if (active != null ? !active.equals(article.active) : article.active != null) return false;
        if (view != null ? !view.equals(article.view) : article.view != null) return false;
        if (contactByContactId != null ? !contactByContactId.equals(article.contactByContactId) : article.contactByContactId != null) return false;
        if (dateUp != null ? !dateUp.equals(article.dateUp) : article.dateUp != null) return false;
        if (dateExpire != null ? !dateExpire.equals(article.dateExpire) : article.dateExpire != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(article.lastUpdate) : article.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (areasize != null ? areasize.hashCode() : 0);
        result = 31 * result + (bedroom != null ? bedroom.hashCode() : 0);
        result = 31 * result + (bathroom != null ? bathroom.hashCode() : 0);
        result = 31 * result + (livingroom != null ? livingroom.hashCode() : 0);
        result = 31 * result + (tier != null ? tier.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (view != null ? view.hashCode() : 0);
        result = 31 * result + (contactByContactId != null ? contactByContactId.hashCode() : 0);
        result = 31 * result + (dateUp != null ? dateUp.hashCode() : 0);
        result = 31 * result + (dateExpire != null ? dateExpire.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "typeId", referencedColumnName = "id", nullable = false)
    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyId", referencedColumnName = "id", nullable = false)
    public PropertyType getPropertyTypeByPropertyId() {
        return propertyTypeByPropertyId;
    }

    public void setPropertyTypeByPropertyId(PropertyType propertyTypeByPropertyId) {
        this.propertyTypeByPropertyId = propertyTypeByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "cityId", referencedColumnName = "id", nullable = false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "districtId", referencedColumnName = "id", nullable = false)
    public District getDistrictByDistrictId() {
        return districtByDistrictId;
    }

    public void setDistrictByDistrictId(District districtByDistrictId) {
        this.districtByDistrictId = districtByDistrictId;
    }

    @ManyToOne
    @JoinColumn(name = "directionId", referencedColumnName = "id")
    public Direction getDirectionByDirectionId() {
        return directionByDirectionId;
    }

    public void setDirectionByDirectionId(Direction directionByDirectionId) {
        this.directionByDirectionId = directionByDirectionId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "articleByArticleId")
    public Collection<ArticleFeature> getArticleFeaturesById() {
        return articleFeaturesById;
    }

    public void setArticleFeaturesById(Collection<ArticleFeature> articleFeaturesById) {
        this.articleFeaturesById = articleFeaturesById;
    }

    @OneToMany(mappedBy = "articleByArticleId")
    public Collection<Picture> getPicturesById() {
        return picturesById;
    }

    public void setPicturesById(Collection<Picture> picturesById) {
        this.picturesById = picturesById;
    }
}
