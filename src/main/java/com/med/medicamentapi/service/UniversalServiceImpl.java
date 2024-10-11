package com.med.medicamentapi.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Service
public abstract class UniversalServiceImpl<T, UUID> implements UniversalService<T, UUID> {
    private final JpaRepository<T, UUID> uniRepository;

    protected UniversalServiceImpl(JpaRepository<T, UUID> repository) {
        this.uniRepository = repository;
    }

    public T findsUnitById(UUID id) {
        return uniRepository.findById(id).orElse(null);
    }

    public T addUnit(T unit) {
        return uniRepository.save(unit);
    }

    public T updateUnit(T unit, UUID id) {
        if (uniRepository.existsById(id)){
            uniRepository.save(unit);
            return unit;
        }
        return null;
    }

    public void deleteUnit(UUID id) {
        if (uniRepository.existsById(id)){
            uniRepository.deleteById(id);
        }
    }

    public List<T> findAllUnits() {
        return uniRepository.findAll(Sort.by("id"));
    }
}
