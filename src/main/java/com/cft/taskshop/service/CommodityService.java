package com.cft.taskshop.service;


import java.util.List;

public interface CommodityService<EntityCommodity> {

    public EntityCommodity create(EntityCommodity commodity);
    public EntityCommodity update(EntityCommodity commodity, Integer id);
    public List<EntityCommodity> getAll();
    public EntityCommodity get(int id);

}
