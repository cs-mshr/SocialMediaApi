package com.facebook.api.controller;

import com.facebook.api.model.User;
import com.facebook.api.service.EmailService;
import com.facebook.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;


//    /----------------Crud- APi-------------\
//    post , get , put, delete

//    @PostMapping
//    public UUID addUser(@RequestBody User user){
//        User new_user = userService.addUser(user);
//        return new_user.getId();
//    }

    @GetMapping("/{id}")
    public User findUser(
            @PathVariable("id") UUID id
    ){
        return userService.findUser(id);
    }

    @GetMapping("/all")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    //To complete User update API on your own;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(
            @PathVariable UUID id,
            @RequestBody User updatedEmployee
    ) {
        User employee = findUser(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        employee = User.builder()
                .id(id)
                .name(updatedEmployee.getName())
                .phone_number(updatedEmployee.getPhone_number())
                .email(updatedEmployee.getEmail())
                .friend_of(updatedEmployee.getFriend_of())
                .profile_image(updatedEmployee.getProfile_image())
                .build();

        userService.addUser(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("profile-photo/{id}")
    public User updateUser(
            @RequestParam("profilePhoto") MultipartFile profilePhoto,
            @RequestParam UUID id
    ) throws IOException {
        String Image = Base64.getEncoder().encodeToString(profilePhoto.getBytes());

        User updatedUser = findUser(id);

        updatedUser.setProfile_image(Image);

        userService.addUser(updatedUser);

        return updatedUser;
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable UUID id
    ){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    /----------------Email Service-------------\

    @Autowired
    private EmailService emailService;
    @PostMapping
    public ResponseEntity<?> addUser(
            @RequestBody User newUser
    ) {

        newUser.setId(UUID.randomUUID());
        userService.addUser(newUser);

        if(newUser.getFriend_of() != null){
            emailService.sendEmailFriend(newUser);
        }

        return new ResponseEntity<>(newUser.getId() , HttpStatus.CREATED);
    }



//    /----------------Get- Mutual Friend-------------\




//    /----------------N-th Mutual Friend-------------\





//    /----------------Paging-Sorting-------------\

//    @GetMapping("/all")
//    public ResponseEntity<List<User>> getAllFriendWithPnS(
//            @RequestParam(name = "page" , defaultValue = "0") int page,
//            @RequestParam(name = "size" , defaultValue = "10") int size,
//            @RequestParam(name = "sort" , defaultValue = "name") String sortField
//    ){
//
//        Sort sort = Sort.by(Sort.Direction.ASC , sortField);
//        Pageable pageable = (Pageable) PageRequest.of(page,size,sort);
//
////        Page<User> userPage = userService.getAllPage(pageable);
//
////        if(userPage.isEmpty()){
////            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////        }
//
////        List<User> users = userPage.getContent();
//
////        return new ResponseEntity<>(users , HttpStatus.OK);
//    }



}
