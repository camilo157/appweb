package com.aplicaciones.appweb.security;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public enum Rol { 
    ADMIN,
    USER
 }