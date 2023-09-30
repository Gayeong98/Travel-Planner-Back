package com.travel_planner.travel_planner.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.travel_planner.travel_planner.common.constant.ResponseMessage;
import com.travel_planner.travel_planner.dto.request.auth.PostSignInDto;
import com.travel_planner.travel_planner.dto.request.auth.PostSignUpDto;
import com.travel_planner.travel_planner.dto.response.ResponseDto;
import com.travel_planner.travel_planner.dto.response.auth.PostSignInResponseDto;
import com.travel_planner.travel_planner.dto.response.auth.PostSignUpResponseDto;
import com.travel_planner.travel_planner.entity.UserEntity;
import com.travel_planner.travel_planner.provider.TokenProvider;
import com.travel_planner.travel_planner.repository.UserRepository;
import com.travel_planner.travel_planner.service.AuthService;

@Service
public class AuthServiceImplements implements AuthService {

    @Autowired private TokenProvider tokenProvider;
    @Autowired private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseDto<PostSignUpResponseDto> postSignUp(PostSignUpDto dto) {

        PostSignUpResponseDto data = null;

        String userId = dto.getUserId();
        String password = dto.getPassword();
        String userEmail = dto.getUserEmail();
        String telNumber = dto.getTelNumber();

        try {
            boolean hasUserId = userRepository.existsByUserId(userId);
            if (hasUserId) return ResponseDto.setFailed(ResponseMessage.EXIST_USER_ID);

            boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
            if (hasTelNumber) return ResponseDto.setFailed(ResponseMessage.EXIST_USER_TEL_NUMBER);

            boolean hasUserEmail = userRepository.existsByUserEmail(userEmail);
            if (hasUserEmail) return ResponseDto.setFailed(ResponseMessage.EXIST_USER_EMAIL);


            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            data = new PostSignUpResponseDto(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<PostSignInResponseDto> postSignIn(PostSignInDto dto) {
        
        PostSignInResponseDto data = null;

        String userId = dto.getUserId();
        String password = dto.getPassword();

        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByUserId(userId);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

            boolean isEqualPassword = passwordEncoder.matches(password, userEntity.getPassword());
            if (!isEqualPassword) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        try {
            String token = tokenProvider.create(userId);
            data = new PostSignInResponseDto(userEntity, token);
        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
