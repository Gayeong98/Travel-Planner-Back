package com.travel_planner.travel_planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel_planner.travel_planner.common.constant.ApiPattern;
import com.travel_planner.travel_planner.dto.request.plan.GetPlanDetailResponseDto;
import com.travel_planner.travel_planner.dto.request.plan.GetPlanResponseDto;
import com.travel_planner.travel_planner.dto.request.plan.PostPlanDetailDto;
import com.travel_planner.travel_planner.dto.request.plan.PostPlanDto;
import com.travel_planner.travel_planner.dto.response.ResponseDto;
import com.travel_planner.travel_planner.dto.response.plan.PostPlanDetailResponseDto;
import com.travel_planner.travel_planner.dto.response.plan.PostPlanResponseDto;
import com.travel_planner.travel_planner.service.PlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiPattern.PLAN)
@Api(description = "계획 생성 및 관리 모듈")
public class PlanController {

    @Autowired private PlanService planService;

    private final String GET_PLAN_LIST = "/plan";
    private final String GET_PLAN_DETAIL_LIST = "/{planId}";

    private final String POST_PLAN = "";
    private final String POST_PLAN_DETAIL = "";

    @ApiOperation(value = "여행 계획 리스트 조회", notes = "Reqeust Header Authorization에 Bearer JWT를 포함하여 요청을 하면, 성공시 여행 계획 리스트를 최신순으로 반환, 실패시 실패 메세지를 반환")
    @GetMapping(GET_PLAN_LIST)
    public ResponseDto<List<GetPlanResponseDto>> getPlanList(@AuthenticationPrincipal String userId){
        ResponseDto<List<GetPlanResponseDto>> response = planService.getPlanList(userId);
        return response;
    }

    @ApiOperation(value = "계획별 일정 리스트 조회", notes = "Path Variable에 계획 번호를 포함하여 요청하면, 성공 시 일정 전체 리스트를 반환, 실패 시 실패 메세지를 반환")
    @GetMapping(GET_PLAN_DETAIL_LIST)
    public ResponseDto<List<GetPlanDetailResponseDto>> getPlanDetailList(int planId) {
        ResponseDto<List<GetPlanDetailResponseDto>> response = planService.getPlanDetailList(planId);
        return response;
    }

    @ApiOperation(value="계획 생성", notes="Request Header Athorization에 Bearer JWT를 포함하고, Request Body에 title, startDate, endDate, info, planImg를 포함하여 전송하면 성공 시 성공 메세지 반환, 실패시 실패 메세지를 반환")
    @PostMapping(POST_PLAN)
    public ResponseDto<PostPlanResponseDto> postPlan(
        @ApiParam(hidden = true)
        @AuthenticationPrincipal String userId,
        @Valid @RequestBody PostPlanDto requestBody) {
            ResponseDto<PostPlanResponseDto> response = planService.postPlan(userId, requestBody);
            return response;
        }

    @ApiOperation(value = "날짜 별 일정 생성", notes = "Request Body에 planId, content, title, detailDate, startTime, endTime을 포함하여 전송하면 성공 시 성공 메세지 반환, 실패 시 실패 메세지를 반환")
    @PostMapping(POST_PLAN_DETAIL)
    public ResponseDto<PostPlanDetailResponseDto> postPlanDetail(@Valid @RequestBody PostPlanDetailDto requestBody) {
        ResponseDto<PostPlanDetailResponseDto> response = planService.postPlanDetail(requestBody);
        return response;
    }
}
