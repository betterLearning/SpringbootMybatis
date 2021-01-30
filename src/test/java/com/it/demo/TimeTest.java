package com.it.demo;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class TimeTest {
    // LocalDate;LocalTime;LocalDateTime
    @Test
    public void test() {

        // 获取当前时间:2020-03-08
        System.out.println(LocalDate.now());
        // 获取当前时间:15:20:40.158
        System.out.println(LocalTime.now());
        // 获取当前时间:2020-03-08T15:20:40.158
        System.out.println(LocalDateTime.now());

        // DateTimeFormatter---ISO系类转化
        // BASIC_ISO_DATE :20200308
        System.out.println("BASIC_ISO_DATE :" + DateTimeFormatter.BASIC_ISO_DATE.format(LocalDateTime.now()));
        // ISO_DATE :2020-03-08
        System.out.println("ISO_DATE :" + DateTimeFormatter.ISO_DATE.format(LocalDateTime.now()));
        // ISO_DATE_TIME :2020-03-08T16:33:27.489
        System.out.println("ISO_DATE_TIME :" + DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));
        // ISO_LOCAL_DATE :2020-03-08
        System.out.println("ISO_LOCAL_DATE :" + DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDateTime.now()));
        // ISO_LOCAL_DATE_TIME :2020-03-08T16:33:27.49
        System.out.println("ISO_LOCAL_DATE_TIME :" + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        // ISO_LOCAL_TIME :16:33:27.49
        System.out.println("ISO_LOCAL_TIME :" + DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now()));
        // ISO_ORDINAL_DATE :2020-068
        System.out.println("ISO_ORDINAL_DATE :" + DateTimeFormatter.ISO_ORDINAL_DATE.format(LocalDateTime.now()));
        // ISO_TIME :16:33:27.49
        System.out.println("ISO_TIME :" + DateTimeFormatter.ISO_TIME.format(LocalDateTime.now()));
        // ISO_WEEK_DATE :2020-W10-7
        System.out.println("ISO_WEEK_DATE :" + DateTimeFormatter.ISO_WEEK_DATE.format(LocalDateTime.now()));

        // DateTimeFormatter格式转化
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // ISO_DATE;ISO_LOCAL_DATE
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 转化日期:2020-03-08
        System.out.println(dtf1.format(LocalDate.now()));
        // 转化日期:2020-03-08
        System.out.println(dtf1.format(LocalDateTime.now()));
        // 转化日期:15:20:40
        System.out.println(dtf2.format(LocalTime.now()));
        // 转化日期:15:20:40
        System.out.println(dtf2.format(LocalDateTime.now()));
        // 转化日期:2020-03-08 15:20:40
        System.out.println(dtf3.format(LocalDateTime.now()));

        LocalDateTime ldt1 = LocalDateTime.of(2020, 12, 12, 0, 0, 0);
        // LocalDateTime-->LocalDate
        LocalDate localDate1 = ldt1.toLocalDate();
        // LocalDateTime-->LocalTime
        LocalTime localTime1 = ldt1.toLocalTime();

        // java.util.Date --> LocalDateTime
        LocalDateTime ldt2 = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        // LocalDateTime -->java.util.Date
        LocalDate localDate2 = LocalDate.now();
        LocalTime localTime2 = LocalTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate2, localTime2);
        Instant instant = localDateTime2.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(Date.from(instant));

        // LocalDate常用
        // 计算时间差--天数差
        LocalDate localDate3 = LocalDate.of(2008, 1, 1);
        LocalDate localDate4 = LocalDate.of(2018, 12, 12);
        // 天数差:3998
        System.out.println("天数差 :" + (localDate4.toEpochDay()-localDate3.toEpochDay()));


        // 计算当年是否是闰年:isLeapYear()
        System.out.println("isLeapYear :" + LocalDate.now().isLeapYear());

        // 计算生日
        Period betweenDate = Period.between(LocalDate.now(), LocalDate.of(2000, 12, 31));
        int age = betweenDate.getYears();
        System.out.println(age);

        // 利用时间矫正器TemporalAdjuster
        LocalDate localDate5 = LocalDate.now();
        // LocalDate.with(TemporalAdjuster adjuster):利用TemporalAdjuster的工具类TemporalAdjusters
        LocalDate firstDayOfMonth = localDate5.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfMonth :"+ firstDayOfMonth);
        TemporalAdjusters.firstDayOfYear();
        TemporalAdjusters.lastDayOfMonth();
        TemporalAdjusters.lastDayOfYear();
        TemporalAdjusters.firstDayOfNextMonth();
        TemporalAdjusters.firstDayOfNextYear();
        // 计算某一天的下一个工作日 :@FunctionalInterface--TemporalAdjuster
        LocalDate nextWorkDay = localDate5.with((time)->{
            LocalDate localDate =(LocalDate) time;
            if(localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                return localDate.plusDays(3);
            }else if(localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                return localDate.plusDays(2);
            }else {
                return localDate.plusDays(1);
            }

        });
        System.out.println("nextWorkDay" + nextWorkDay);
    }
}
