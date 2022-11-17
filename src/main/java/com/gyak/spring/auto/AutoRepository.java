package com.gyak.spring.auto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

    @Query("SELECT s FROM Auto s WHERE s.rendszam = ?1")
    Optional<Auto> findByRendszam(String rendszam);

    @Query("SELECT s FROM Auto s WHERE s.km = ?1")
    Optional<Auto> findByKm(Integer km);

}
