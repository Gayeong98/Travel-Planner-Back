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
@Entity(name="Plan")
@Table(name="Plan")
public class PlanEntity {
    @Id
    private int planId;
    private String title;
    private String userId;
    private Date startDate;
    private Date endDate;
    private String info;
    private String planImg;

}
