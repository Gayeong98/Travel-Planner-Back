package com.travel_planner.travel_planner.dto.response.auth;

import com.travel_planner.travel_planner.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="로그인 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSignInResponseDto {
    @ApiModelProperty(value="사용자 아이디", example="user1234", required=true)
    private String userId;
    @ApiModelProperty(value="사용자 이름", example="홍길동", required=true)
    private String userName;
    @ApiModelProperty(value="사용자 휴대전화번호", example="010-1234-9876", required=true)
    private String telNumber;
    @ApiModelProperty(value="사용자 이메일", example="qwer@qwer.com", required=true)
    private String userEmail;
    @ApiModelProperty(value="JWT", example="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", required=true)
    private String token;
    @ApiModelProperty(value="토큰 만료 기간", example="3600000", required=true)
    private int expirtedTime;

    public PostSignInResponseDto(UserEntity userEntity, String token) {
        this.userId = userEntity.getUserId();
        this.userName = userEntity.getUserName();
        this.telNumber = userEntity.getTelNumber();
        this.userEmail = userEntity.getUserEmail();
        this.token = token;
        this.expirtedTime = 3600000;
    }
    
}
