package com.med.medicamentapi.service;

//import com.med.medicamentapi.model.T;

import java.util.List;

//public interface UniversalService<T, UUID> {
public interface UniversalService<T, UUID> {
    List<T> findAllUnits();

    T findsUnitById(UUID id);

    T addUnit(T bulb);

    T updateUnit(T bulb, UUID id);

    void deleteUnit(UUID id);
}
