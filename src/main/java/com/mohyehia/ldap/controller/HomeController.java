package com.mohyehia.ldap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {
    private static Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {

        log.info("Getting UsernamePasswordAuthenticationToken from SecurityContextHolder");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LdapUserDetailsImpl principal = (LdapUserDetailsImpl) authentication.getPrincipal();
        log.info("authentication: " + authentication);
        log.info("principal: " + principal);

        return "Spring Security + Spring LDAP Authentication Configuration Example";
    }

    @GetMapping("/managers")
    public List<String> retrieveManagers(){
        return Arrays.asList("Manager 01", "Manager 02", "Manager 03");
    }

    @GetMapping("/developers")
    public List<String> retrieveDevelopers(){
        return Arrays.asList("Developer 01", "Developer 02", "Developer 03");
    }
}
