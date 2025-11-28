package com.example.spring_data_jpa_practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class RootController {

        @GetMapping("/")
        public ResponseEntity<String> home() {
            return ResponseEntity.ok("Service running. Use /api/* endpoints.");
        }
    }