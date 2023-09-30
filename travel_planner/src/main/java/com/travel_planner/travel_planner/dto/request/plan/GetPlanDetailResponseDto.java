package com.travel_planner.travel_planner.dto.request.plan;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "계획별 일정 가져오기 Request Body")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlanDetailResponseDto {
    @ApiModelProperty(value = "일정 고유번호", example = "1", required = true)
    private int planDetailId;

    @ApiModelProperty(value = "계획 고유번호", example = "1", required = true)
    private int planId;

    @ApiModelProperty(value = "일정 내용", example = "어쩌구저쩌구", required = false)
    private String content;

    @ApiModelProperty(value = "일정 제목", example = "광안리해수욕장", required = true)
    private String title;

    @ApiModelProperty(value = "일정 날짜", example = "2023-09-30", required = true)
    private Date detailDate;

    @ApiModelProperty(value = "일정 시작 시간", example = "10", required = true)
    private int startTime;

    @ApiModelProperty(value = "일정 마감 시간", example = "13", required = true)
    private int endTime;
}
