package com.travel_planner.travel_planner.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="PlanDetail")
@Table(name="PlanDetail")
public class PlanDetailEntity {
    @Id
    private int planDetailId;
    private int planId;
    private String content;
    private String title;
    private Date detailDate;
    private int startTime;
    private int endTime;

}
