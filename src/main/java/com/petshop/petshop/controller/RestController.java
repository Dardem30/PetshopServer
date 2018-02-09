package com.petshop.petshop.controller;

import com.petshop.petshop.model.Pet;
import com.petshop.petshop.model.security.model.Authority;
import com.petshop.petshop.model.security.model.User;
import com.petshop.petshop.security.service.DefaultUserService;
import com.petshop.petshop.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@RequestMapping(value = "/api",produces = {APPLICATION_JSON_UTF8_VALUE})
@CrossOrigin
public class RestController {
    @Autowired
    PetService petService;
    @Autowired
    private DefaultUserService defaultUserService;

    @GetMapping("")
    public ResponseEntity list (){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user=defaultUserService.getUserByUsername(username);
        String authority="";
        for(Authority authority1: user.getAuthorities()){
            authority=authority1.getAuthority();
        }
        if(authority.equals("Admin")){
            return ResponseEntity.ok().body(petService.petList());
        }else{
            return ResponseEntity.ok().body(defaultUserService.listPetsOfUser(user));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getPetById(@PathVariable int id){
        return  ResponseEntity.status(HttpStatus.OK).body(petService.getPetbyId(id));
    }


    @PostMapping("")
    public ResponseEntity createPet(@RequestBody Pet pet){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user=defaultUserService.getUserByUsername(username);
        pet.setUserId(user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.savePet(pet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePet (@PathVariable int id){
        if(petService.getPetbyId(id)!=null) {
            Pet pet = petService.deletePet(id);
            return ResponseEntity.status(HttpStatus.OK).body(pet);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePet (@PathVariable int id, @RequestBody Pet pet){
        Pet updatePet = petService.getPetbyId(id);
        if(updatePet == null) {
            return ResponseEntity.notFound().build();
        }
        updatePet.setAge(pet.getAge());
        updatePet.setName(pet.getName());
        petService.updatePet(updatePet);
        return ResponseEntity.ok(updatePet);
    }


}
