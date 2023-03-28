package com.cft.taskshop.service;


import java.util.List;

public interface CommodityService<EntityCommodity> {

     EntityCommodity create(EntityCommodity commodity);
     EntityCommodity update(EntityCommodity commodity, Integer id);
     List<EntityCommodity> getAll();
     EntityCommodity get(int id);
     void deleteById(int id);

}
