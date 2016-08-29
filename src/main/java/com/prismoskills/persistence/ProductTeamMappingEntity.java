package com.prismoskills.persistence;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name="Product_Team_Mapping")
@AttributeOverride( name="id", column = @Column(name="Product_Team_Mapping_Id"))
public class ProductTeamMappingEntity extends BaseEntity {

    @Column(name="product_id")
    String productId;

    @Column(name="team_id")
    String teamId;

    // Constructors
    public ProductTeamMappingEntity() {
    }

    public ProductTeamMappingEntity(String productId, String teamId) {
        super();
        this.productId = productId;
        this.teamId = teamId;
    }

    // Getter setters
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
