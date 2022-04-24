package net.scit.RealEstate.service;

import java.util.List;

import net.scit.RealEstate.vo.RealEstate;

public interface RealEstateService {
    int register(int registerMenu);

    RealEstate getRealEstate(String address);

    List<RealEstate> getRealEstatesByType(String type);

    void printAll();

    int delete(String address);
}
