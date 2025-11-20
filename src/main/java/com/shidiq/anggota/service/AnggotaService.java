package com.shidiq.anggota.service;

import org.springframework.stereotype.Service;
import com.shidiq.anggota.model.Anggota;
import com.shidiq.anggota.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class AnggotaService {

   @Autowired
    private AnggotaRepository anggotaRepository; // camelCase

    public List<Anggota> getAllAnggota() {
        return anggotaRepository.findAll(); // instance, bukan static
    }

    public Anggota getAnggotaById(Long id) {
        return anggotaRepository.findById(id).orElse(null);
    }

    public Anggota createAnggota(Anggota anggota) {
        return anggotaRepository.save(anggota);
    }

    public void deleteAnggota(Long id) {
        anggotaRepository.deleteById(id);
    }
}