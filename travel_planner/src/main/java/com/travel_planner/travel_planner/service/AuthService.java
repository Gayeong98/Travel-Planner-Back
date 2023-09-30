package com.travel_planner.travel_planner.service;

import com.travel_planner.travel_planner.dto.request.auth.PostSignInDto;
import com.travel_planner.travel_planner.dto.request.auth.PostSignUpDto;
import com.travel_planner.travel_planner.dto.response.ResponseDto;
import com.travel_planner.travel_planner.dto.response.auth.PostSignInResponseDto;
import com.travel_planner.travel_planner.dto.response.auth.PostSignUpResponseDto;

public interface AuthService {
    //^ 회원가입
    public ResponseDto<PostSignUpResponseDto> postSignUp(PostSignUpDto dto);

    //^ 로그인
    public ResponseDto<PostSignInResponseDto> postSignIn(PostSignInDto dto);
}
