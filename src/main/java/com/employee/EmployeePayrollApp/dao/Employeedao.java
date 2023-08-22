package com.employee.EmployeePayrollApp.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;
import java.util.List;


@Data
@ToString


public class Employeedao {

    public static String name;
    public static String gender;
//    @JsonFormat(pattern = "dd MMM yyyy")
    public static Date startDate;
    public static String note;
    public static String profilePic;
    public static List<String> department;

}
