package com.oxygen.mbgtools.ao;


/**
 * 数据库查询AO
 * @author oxygen
 * @date 2020/7/7
 **/
public class InventoryQuantityAO {

    private Integer inventoryQuantity;

    private Integer availableQuantity;

    private Integer freezeQuantity;

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getFreezeQuantity() {
        return freezeQuantity;
    }

    public void setFreezeQuantity(Integer freezeQuantity) {
        this.freezeQuantity = freezeQuantity;
    }
}
