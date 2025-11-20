package com.shidiq.anggota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shidiq.anggota.model.Anggota;
import com.shidiq.anggota.service.AnggotaService;
import java.util.List;

@RestController
@RequestMapping("/api/anggota")
public class AnggotaController {

     @Autowired
    private AnggotaService anggotaService; // camelCase

    @GetMapping
    public List<Anggota> getAllAnggota() {
        return anggotaService.getAllAnggota();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anggota> getAnggotaById(@PathVariable Long id) {
        Anggota anggota = anggotaService.getAnggotaById(id);
        return anggota != null ? ResponseEntity.ok(anggota) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Anggota createAnggota(@RequestBody Anggota anggota) {
        return anggotaService.createAnggota(anggota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnggota(@PathVariable Long id) {
        anggotaService.deleteAnggota(id);
        return ResponseEntity.ok().build();
    
    }
}