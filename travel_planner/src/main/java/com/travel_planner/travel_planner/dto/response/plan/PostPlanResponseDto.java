package com.travel_planner.travel_planner.dto.response.plan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "계획 추가 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPlanResponseDto {
    @ApiModelProperty(value = "계획 추가 결과 상태", example = "true", required = true)
    private boolean resultState;
}
