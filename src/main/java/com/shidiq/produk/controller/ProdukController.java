package com.shidiq.produk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shidiq.produk.model.Produk;
import com.shidiq.produk.service.ProdukService;

import java.util.List;

@RestController
@RequestMapping("/api/produk")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping
    public List<Produk> getAllProduk() {
        return produkService.getAllProduk();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> getProdukById(@PathVariable Long id) {
        Produk produk = produkService.getProdukById(id);
        return produk != null ? ResponseEntity.ok(produk) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Produk createProduk(@RequestBody Produk produk) {
        return produkService.createProduk(produk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduk(@PathVariable Long id) {
        produkService.deleteProduk(id);
        return ResponseEntity.ok().build();
    }
}
