package com.gongzuochong.util;

import com.gongzuochong.config.GanjiDic;
import com.gongzuochong.enums.*;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by marco on 2017/3/28.
 */
public class GanjiGrabUtil {


    public static GanjiQzPrice getQzPay(String v){
        GanjiQzPrice ganjiQzPrice = GanjiQzPrice.fromGJCode(v);
        return  ganjiQzPrice == null ? GanjiQzPrice.type0 : ganjiQzPrice;
    }

    public static Integer getPay(JobCateFirst jobCateFirst, String v){
        switch (jobCateFirst){
            case QZ:
                GanjiQzPrice qzPay = getQzPay(v);
                return qzPay.getDefaultPay();
            case JZ:
                //Todo
                throw new RuntimeException("未定义兼职pay,请定义");
            default:
                throw new RuntimeException("未知异常");
        }
    }

    public static GanjiWorkYear getWorkYear(String v){
        GanjiWorkYear ganjiWorkYear = GanjiWorkYear.fromGJCode(v);
        return ganjiWorkYear == null ? GanjiWorkYear.type0 : ganjiWorkYear;
    }

    public static GanjiStudyDegree getEducation(String v){
        GanjiStudyDegree ganjiStudyDegree = GanjiStudyDegree.fromGJCode(v);
        return ganjiStudyDegree == null ? GanjiStudyDegree.type0: ganjiStudyDegree;
    }

    public static List<JobTag> getTags(List<String> tags){
        /**
         *  Type1(1, "包吃"),
         Type2(2, "包住"),
         Type3(3, "包吃住"),
         Type4(4, "五险一金"),
         Type5(5, "周末双休"),
         Type6(6, "带薪年假"),
         Type7(7, "饭补"),
         Type8(8, "话补"),
         Type9(9, "加班补助"),
         Type10(10, "交通补助");
         */
        List<JobTag> jobTags = new ArrayList<>();
        tags.forEach(tagstr -> {
            if ("包吃".equals(tagstr)){
                jobTags.add(JobTag.Type1);
            }
            if ("包住".equals(tagstr)){
                jobTags.add(JobTag.Type2);
            }
            if ("做二修五".equals(tagstr)){
                jobTags.add(JobTag.Type5);
            }
            if ("带薪年假".equals(tagstr)){
                jobTags.add(JobTag.Type6);
            }
            if ("餐补".equals(tagstr)){
                jobTags.add(JobTag.Type7);
            }
            if ("话补".equals(tagstr)){
                jobTags.add(JobTag.Type8);
            }
            if ("加班补助".equals(tagstr)){
                jobTags.add(JobTag.Type10);
            }
            if ("交通补助".equals(tagstr)){
                jobTags.add(JobTag.Type10);
            }
        });

        if (jobTags.contains(JobTag.Type1) && jobTags.contains(JobTag.Type2)){
            jobTags.add(JobTag.Type3);
            jobTags.removeAll(Lists.newArrayList(JobTag.Type1, JobTag.Type2));
        }

        long baoxian = tags.stream().filter(tag -> tag.endsWith("保险")).count();
        long gongjijin = tags.stream().filter(tag -> tag.endsWith("公积金")).count();
        if (baoxian >= 5L && gongjijin >= 1){
            jobTags.add(JobTag.Type4);
        }
        //排序
        return jobTags.stream()
                .distinct()
                .sorted((Comparator.comparingInt(JobTag::getValue)))
                .limit(6)
                .collect(Collectors.toList());
    }


    public static Integer getCity(String domain) {
        Integer integer = GanjiDic.cityMap.get(domain);
        Objects.requireNonNull(integer);
        return integer;
    }

}
