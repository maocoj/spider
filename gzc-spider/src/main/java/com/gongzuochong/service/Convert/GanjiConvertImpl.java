package com.gongzuochong.service.Convert;

import com.gongzuochong.config.GanjiDic;
import com.gongzuochong.entity.DistrictEntity;
import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.JobEntity;
import com.gongzuochong.entity.mongo.GanjiQzJob;
import com.gongzuochong.enums.*;
import com.gongzuochong.service.DistrictService;
import com.gongzuochong.service.JobCategoryService;
import com.gongzuochong.util.ConstUtil;
import com.gongzuochong.util.GanjiGrabUtil;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by marco on 2017/3/30.
 */
@Component
public class GanjiConvertImpl {
    @Autowired
    protected JobCategoryService jobCategoryService;
    @Autowired
    protected DistrictService districtService;

    public JobEntity convertJob(Long uid, GanjiQzJob job) {
        JobEntity jobPo = new JobEntity();
        jobPo.setUid(uid);
        //默认招聘中
        jobPo.setState(1);
        //公司名称为空，创建新用户，不用创建公司信息
        jobPo.setEmployerType(job.getCommentOwnerInfo() == null ? 0 : 1);

        jobPo.setTitle(job.getTitle().replace("58","工作虫"));
        jobPo.setCateFirst(JobCateFirst.QZ.getValue());
        Integer jobType = GanjiDic.categoryMap.get(job.getTagName().trim());
        if (jobType == null){
            throw new RuntimeException("该类别无法对应工作虫类目: "+job.getTagName());
        }
        jobPo.setJobType(jobType);
        jobPo.setCateFullpath(jobCategoryService.getFullPathText(jobType));

        jobPo.setCity(GanjiGrabUtil.getCity(job.getDomain()));
        Integer districtId = findDistrictByText(GanjiDic.cityMap.get(job.getDomain()), job.getDistrictName(), job.getStreetName());
        //Integer districtId = findDistrictByText(GanjiDic.cityMap.get(job.getDomain()), null, null);
        if (districtId == null){
            throw new RuntimeException("该区域无法转换为工作虫区域: "+job.getDomain() +" "+job.getDistrictName() +" "+ job.getStreetName());
        }
        jobPo.setDistrict(districtId);
        jobPo.setDistrictFullpath(DistrictService.getDistrictFullpath(districtId));

        jobPo.setAddress(Strings.isNullOrEmpty(job.getWorkAddress()) ? "" : job.getWorkAddress());
        boolean isMobile = ConstUtil.checkMobile(job.getCommentOwnerInfo().getPhone());
        jobPo.setPhone(isMobile ? job.getCommentOwnerInfo().getPhone() : "");
        jobPo.setTelphone(isMobile ? "" : job.getCommentOwnerInfo().getPhone());
        jobPo.setContactName(job.getCommentOwnerInfo().getCompanyName());
        jobPo.setPlaces(Integer.valueOf(Strings.isNullOrEmpty(job.getNeedNum()) ? "10" : job.getNeedNum()));
        jobPo.setSex(0);
        jobPo.setEducation(GanjiGrabUtil.getEducation(job.getStudyDegree().getV()).getGzcCode());

        //福利标签
        jobPo.setTags(this.getQzFare(job.getWelfare()));
        jobPo.setMinAge(job.getMaxAge() == null ? 0 : Integer.valueOf(job.getMaxAge()));
        jobPo.setMaxAge(job.getMinAge() == null ? 0 : Integer.valueOf(job.getMinAge()));
        jobPo.setMinHeight(0);
        jobPo.setMaxHeight(0);
        jobPo.setCheckinTime("");
        jobPo.setCheckoutTime("");
        jobPo.setWorkTime("");
        jobPo.setEntName(job.getCommentOwnerInfo().getCompanyName());
        jobPo.setPay(GanjiGrabUtil.getPay(JobCateFirst.QZ, job.getPrice().getV()));
        jobPo.setPayQz(GanjiGrabUtil.getQzPay(job.getPrice().getV()).getGzcCode());
        jobPo.setUnit(SalaryUnit.Month.getValue());
        jobPo.setIsInterview(0);
        jobPo.setWorkingYear(GanjiGrabUtil.getWorkYear(job.getWorkYear().getV()).getGzcCode());
        jobPo.setPayment(0);
        //100-200的随机数，作为浏览次数
        long viewCount = (int) Math.round((Math.random() * 100 + 100));
        jobPo.setViewCount(viewCount);
        jobPo.setPostTime(new Date());
        jobPo.setCreateTime(new Date());
        jobPo.setUpdateTime(new Date());
        jobPo.setSettlementType(SettlementType.Month.getValue());
        jobPo.setVerifyType(0);
        jobPo.setEmployCount(0);
        jobPo.setIsStudent(0);
        jobPo.setUserType(1);
        jobPo.setContent(job.getDescription());
        jobPo.setMemo("");
        jobPo.setLbsSyncTime(null);
        jobPo.setSourceId("ganji_" + job.getId());
        jobPo.setJobSource(JobSource.Ganji.getValue());//5代表赶集网抓取
        return jobPo;
    }

    public IdentEntEntity convertEnt(Long uid,  GanjiQzJob.CommentOwnerInfo sourceEnt) {
        IdentEntEntity entPo = new IdentEntEntity();
        entPo.setUid(uid);
        entPo.setEntName(sourceEnt.getCompanyName());
        entPo.setEntIcon("");
        entPo.setAlias(sourceEnt.getCompanyName());
        entPo.setEntNature(0);
        entPo.setIndustry(15);
        entPo.setScale(0);
        /**
         * 每添加一个城市需要在字典建对应关系
         */
        entPo.setDistrict(11);
        entPo.setAddress("");
        entPo.setContact(sourceEnt.getUserName());
        entPo.setTel(sourceEnt.getPhone());
        entPo.setDescription("");
        entPo.setLicensePic("");
        entPo.setState(0);
        entPo.setCreateTime(new Date());
        entPo.setUpdateTime(new Date());
        entPo.setDegree(0);
        entPo.setBackgroundPic("");
        entPo.setContactPosition(0);
        entPo.setRegNumber("");
        entPo.setLegalRep("");
        entPo.setLegalIdCard("");
        return entPo;
    }


    private String getQzFare( GanjiQzJob.Welfare welfare){
        List<String> tags = new ArrayList<>();
        if (welfare != null){
            if (welfare.getInsurance() != null){
                String[] insurance = welfare.getInsurance().split("\\s+");
                tags.addAll(Arrays.asList(insurance));
            }

            if (welfare.getRoom() != null){
                String[] room = welfare.getRoom().split("\\s+");
                tags.addAll(Arrays.asList(room));
            }

            if (welfare.getOther() != null){
                String[] other = welfare.getOther().split("\\s+");
                tags.addAll(Arrays.asList(other));
            }
        }

        List<JobTag> jobTags = GanjiGrabUtil.getTags(tags);
        if (jobTags == null || jobTags.size() == 0){
            return "";
        }
        List<String> result = jobTags.stream()
                .map(JobTag::getValue)
                .map(String::valueOf)
                .collect(Collectors.toList());
        return String.join(",", result);
    }

    private Integer findDistrictByText(Integer cityId, String district , String street){
        Objects.requireNonNull(cityId);
        List<DistrictEntity> districtEntities = districtService.findByParent(cityId);
        if (districtEntities.size() == 0){
            throw new RuntimeException("当前城市无区域");
        }

        DistrictEntity hasChildren = null;
        Optional<DistrictEntity> defDis = districtEntities
                .stream()
                .filter(d -> districtService.findByParent(d.getValue()).size() > 0)
                .findFirst();
        if (!defDis.isPresent()){
            throw new RuntimeException("该城市下无可用的区域！value:"+ cityId);
        }

        Optional<DistrictEntity> dt = Optional.empty();
        if (!Strings.isNullOrEmpty(district)){
            dt = districtEntities
                    .stream()
                    .filter(d -> d.getText().contains(district))
                    .findAny();
        }

        hasChildren = dt.orElse(defDis.get());

        List<DistrictEntity> areas = districtService.findByParent(hasChildren.getValue());

        Optional<DistrictEntity> any = Optional.empty();
        if (!Strings.isNullOrEmpty(street)){
            any = areas.stream().filter(area -> area.getText().contains(street)).findFirst();
        }
        return any.orElse(areas.get(0)).getValue();
    }
}
