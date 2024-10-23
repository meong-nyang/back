package com.meongnyang.shop.service.user;

import com.meongnyang.shop.dto.request.ReqGetUserOrderDto;
import com.meongnyang.shop.dto.request.ReqUpdatePetDto;
import com.meongnyang.shop.dto.request.ReqUpdateUserDto;
import com.meongnyang.shop.dto.response.RespGetUserOrdersDto;
import com.meongnyang.shop.dto.response.RespPetInfoDto;
import com.meongnyang.shop.dto.response.RespUserInfoDto;
import com.meongnyang.shop.entity.Order;
import com.meongnyang.shop.entity.Pet;
import com.meongnyang.shop.entity.User;

import com.meongnyang.shop.exception.InvalidUserException;

import com.meongnyang.shop.repository.OrderMapper;

import com.meongnyang.shop.repository.PetMapper;
import com.meongnyang.shop.repository.UserMapper;
import com.meongnyang.shop.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private OrderMapper orderMapper;

    // 회원정보 조회
    public RespUserInfoDto getUserInfo(Long id) {
        User user = userMapper.findById(id);

        Set<String> roles = user.getUserRoles().stream().map(
                userRole -> userRole.getRole().getRoleName()
        ).collect(Collectors.toSet());

        return RespUserInfoDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .membershipLevelId(user.getMembershipLevelId())
                .roles(roles)
                .build();
    }

    // 회원정보 수정
    public void updateUser(ReqUpdateUserDto dto) {
        userMapper.updateUserById(dto.toEntity());
    }

    // 반려동물정보 조회
    public RespPetInfoDto getPetInfo(Long id) {
        Pet pet = petMapper.findPetByUserid(id);

        return RespPetInfoDto.builder()
                .petId(pet.getId())
                .petName(pet.getPetName())
                .petAge(pet.getPetAge())
                .petType(pet.getPetType())
                .build();
    }

    public void updatePet(ReqUpdatePetDto dto) {
        petMapper.updatePetById(dto.toEntity());
    }


    public void deleteUser(Long id) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principalUser.getUserRoles().stream()
                .anyMatch(role -> role.getRole().getRoleName().equals("ROLE_ADMIN"))) {
            throw new InvalidUserException("사용자 정보를 삭제할 수 없습니다.");
        }
        if (id != principalUser.getId()) {
            throw new InvalidUserException("사용자 정보를 삭제할 수 없습니다.");
        }
        userMapper.deleteUserById(id);
    }

    public List<RespGetUserOrdersDto> getUserOrders(ReqGetUserOrderDto dto) {
        List<Order> list = orderMapper.getUserOrders(dto.getUserId());
        return list.stream().map(Order::toRespGetUserOrdersDto).collect(Collectors.toList());
    }
}