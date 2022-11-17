package com.gyak.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AutoService {

    private final AutoRepository autoRepository;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public List<Auto> getAuto() {
        return autoRepository.findAll();
    }

    public void addNewAuto(Auto auto) {
        Optional<Auto> autoByRendszam = autoRepository.findByRendszam(auto.getRendszam());
        if (autoByRendszam.isPresent()){
            throw new IllegalStateException("Rendszám már egyezik");
        }
        autoRepository.save(auto);
    }

    public void deleteAuto(int autoId) {
        boolean exists = autoRepository.existsById(autoId);
        if (!exists){
            throw new IllegalStateException("auto ezzel az"+autoId+" azonosítóval nem létezik");
        }
        autoRepository.deleteById(autoId);
    }

    @Transactional
    public void updateAuto(int autoId,String rendszam,int km){
        Auto auto = autoRepository.findById(autoId)
                .orElseThrow(() -> new IllegalStateException("Autó ezzel az "+autoId+" azonosítóval nem létezik"));
        if (rendszam != null && rendszam.length() > 0 && !Objects.equals(auto.getRendszam(), rendszam)) {
            auto.setRendszam(rendszam);
        }
        if (!Objects.equals(auto.getKm(), km)) {
            Optional<Auto> autoOptional = autoRepository.findByKm(km);
            if (autoOptional.isPresent()){
                throw new IllegalStateException("Nem változtatta meg a számot");
            }
            auto.setKm(km);
        }

    }


}
