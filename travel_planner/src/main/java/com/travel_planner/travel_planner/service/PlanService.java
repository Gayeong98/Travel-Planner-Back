package com.travel_planner.travel_planner.service;

import java.util.List;

import com.travel_planner.travel_planner.dto.request.plan.GetPlanDetailResponseDto;
import com.travel_planner.travel_planner.dto.request.plan.GetPlanResponseDto;
import com.travel_planner.travel_planner.dto.request.plan.PostPlanDetailDto;
import com.travel_planner.travel_planner.dto.request.plan.PostPlanDto;
import com.travel_planner.travel_planner.dto.response.ResponseDto;
import com.travel_planner.travel_planner.dto.response.plan.PostPlanDetailResponseDto;
import com.travel_planner.travel_planner.dto.response.plan.PostPlanResponseDto;

public interface PlanService {
    public ResponseDto<List<GetPlanResponseDto>> getPlanList(String userId);
    public ResponseDto<List<GetPlanDetailResponseDto>> getPlanDetailList(int planId);
    public ResponseDto<PostPlanResponseDto> postPlan(String userId, PostPlanDto dto);
    public ResponseDto<PostPlanDetailResponseDto> postPlanDetail(PostPlanDetailDto dto);
}
