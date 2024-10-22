package com.meongnyang.shop.controller.admin;

import com.meongnyang.shop.dto.request.admin.ReqModifyMembershipLevelDto;
import com.meongnyang.shop.dto.request.admin.ReqSearchDto;
import com.meongnyang.shop.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserInfoController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsersAll() {
        return ResponseEntity.ok().body(adminUserService.getUsers());
    }

    @GetMapping("/users/search")
    public ResponseEntity<?> getUsersByOption(@RequestBody ReqSearchDto dto) {
        return ResponseEntity.ok().body(adminUserService.getUsersByOption(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserDetail(@PathVariable Long userId) {
        return ResponseEntity.ok().body(adminUserService.getUserDetail(userId));
    }

    @PutMapping("/user/{userId}/membership")
    public ResponseEntity<?> modifyUserByMembership(@RequestBody ReqModifyMembershipLevelDto dto) {
        return ResponseEntity.ok().body(null);
    }

}