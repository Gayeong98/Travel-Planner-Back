package com.travel_planner.travel_planner.dto.request.plan;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "계획 가져오기 Request Body")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlanResponseDto {
    @ApiModelProperty(value = "계획 번호", example = "1", required = true)
    private int planId;

    @ApiModelProperty(value = "계획 이름", example = "제주도 여행", required = true)
    private String title;

    @ApiModelProperty(value = "계획 시작일", example = "2023-09-30", required = true)
    private Date startDate;

    @ApiModelProperty(value = "계획 마감일", example = "2023-09-30", required = true)
    private Date endDate;

    @ApiModelProperty(value = "계획 간단 설명", example = "09/30~10/20 제주도 가족여행", required = false)
    private String info;

    @ApiModelProperty(value = "계획 대표 이미지", example = "plan.img", required = false)
    private String planImg;
}
