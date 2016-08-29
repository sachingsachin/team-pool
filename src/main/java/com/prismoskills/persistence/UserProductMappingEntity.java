package com.prismoskills.persistence;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name="User_Product_Mapping")
@AttributeOverride( name="id", column = @Column(name="User_Product_Mapping_Id"))
public class UserProductMappingEntity extends BaseEntity {

    @Column(name="user_id")
    String userId;

    @Column(name="product_id")
    String productId;

    // Constructors
    public UserProductMappingEntity() {
    }

    public UserProductMappingEntity(String userId, String productId) {
        super();
        this.userId = userId;
        this.productId = productId;
    }

    // Getter setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
