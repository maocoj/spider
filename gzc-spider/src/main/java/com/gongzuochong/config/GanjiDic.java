package com.gongzuochong.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marco on 2017/3/28.
 */
public class GanjiDic {
    public static final Map<String, Integer> cityMap;
    public static final Map<String, Integer> categoryMap;
    static {
        cityMap = Collections.unmodifiableMap(new HashMap<String, Integer>() {{
            /**
             * 北京：bj
             */
            put("bj", 1101);
        }});

        categoryMap = Collections.unmodifiableMap(new HashMap<String, Integer>(){{
            put("电话销售",251);
            put("销售代表/客户经理",251);
            put("售前工程师",251);
            put("团购业务员",251);
            put("医药代表",251);
            put("汽车销售",251);
            put("销售助理",251);
            put("销售主管/经理",259);
            put("商务主管/经理",259);
            put("区域/渠道经理",259);
            put("大客户经理",259);
            put("销售总经理/总监",259);
            put("网络销售",251);
            put("经销商",251);
            put("会籍顾问",251);
            put("业务拓展/跟单",251);
            put("招商经理/主管/总监",259);
            put("客户总监/主管/经理",259);
            put("销售行政经理",259);
            put("销售运营经理",259);
            put("销售培训师/讲师",251);
            put("销售业务分析",251);
            put("销售工程师",251);
            put("其他销售职位",251);
            put("普工/学徒工",148);
            put("电工",162);
           // put("木工",163);
           // put("焊工",164);
            put("水工",148);
            put("油漆工",148);
            put("建筑工人",148);
            put("水泥工",148);
//            put("钢筋工",164);
            put("管道工",148);
            put("瓦工",148);
            put("洗车工",148);
//            put("汽车/摩托车修理工",164);
//            put("机电维修工",164);
//            put("电器维修工",164);
//            put("锅炉工",164);
//            put("水暖工",164);
//            put("车工",164);
//            put("铣工",164);
//            put("模具工",164);
//            put("钳工",164);
//            put("钣金工",164);
//            put("切割技工",164);
//            put("操作工",164);
            put("搬运工",148);
            put("送水工",148);
            put("叉车工/铲车工",148);
            put("组装工",148);
            put("包装工",148);
//            put("印刷工",164);
//            put("缝纫工",164);
//            put("样衣工",164);
//            put("染工",164);
//            put("纺织工",164);
//            put("印花工",164);
//            put("压熨工",164);
//            put("制冷工",164);
//            put("磨床/冲床工",164);
//            put("拖压工",164);
//            put("仪表工",164);
//            put("电镀工",164);
            put("砌筑工",148);
            put("混凝土工",148);
            put("浇注工",148);
            put("抹灰工",148);
            put("施工开料工",148);
//            put("旋压工",164);
//            put("折弯工",164);
//            put("刨/钻/镗/铆工",164);
//            put("抛光工",164);
//            put("硫化/炼胶工",164);
//            put("吹膜/注塑工",164);
//            put("工长",164);
//            put("电梯工",164);
//            put("其他技工/工人职位",164);
            put("行政专员/助理",255);
            put("经理助理/秘书/文员",253);
            put("前台/总机/接待",254);
            put("后勤",299);
            put("其他行政/后勤职位",299);
            put("客服专员/助理",252);
            put("呼叫中心人员",252);
            put("售后支持工程师",252);
            put("客服主管/经理",252);
            put("客户关系管理",252);
            put("售后支持主管/经理",252);
            put("客服总监",252);
            put("投诉专员",252);
            put("其他客服职位",252);
            put("淘宝客服",252);
            put("店铺运营",252);
            put("业务支持",252);
            put("店铺管理",252);
            put("模特类",252);
            put("淘宝美工",24);
            put("其他淘宝职位",252);
//            put("财务/会计助理",262);
//            put("会计",262);
//            put("出纳",262);
//            put("财务分析员",262);
//            put("成本管理员",262);
//            put("审计专员/助理",263);
//            put("",263);
//            put("税务专员/助理",263);
//            put("资产/资金管理",263);
//            put("财务/总账主管",262);
//            put("财务经理",262);
//            put("会计主管/经理",262);
//            put("财务分析主管/经理",262);
//            put("成本主管/经理",262);
//            put("审计主管/经理",263);
//            put("税务主管/经理",263);
//            put("财务总监",262);
//            put("财务顾问",262);
//            put("首席财务官CFO",262);
//            put("其他财务职位",262);
            put("商务司机",146);
            put("客运司机",146);
            put("货运司机",146);
            put("出租车司机",146);
            put("班车司机",146);
            put("特种车司机",146);
            put("驾校教练/陪练",36);
            put("代驾",35);
            put("吊车司机/卡车司机",146);
            put("其他司机职位",146);
            put("营业员/店员",115);
            put("导购",117);
            put("收银员",116);
            put("理货员/陈列员",118);
            put("采购员/助理",120);
            put("食品加工/处理",122);
            put("店长/卖场经理",119);
            put("停车管理员",160);
            put("防损员/内保",121);
            put("督导",127);
            put("买手",115);
            put("奢侈品销售",115);
            put("品牌/连锁招商管理",119);
            put("品类管理",123);
            put("质量管理",128);
            put("其他超市/百货职位",128);
            put("服务员",100);
            put("面点师",104);
            put("茶艺师",110);
            put("配菜/打荷",103);
            put("传菜员",102);
            put("洗碗工",105);
            put("后厨杂工",106);
            put("领班",108);
            put("迎宾/礼仪",109);
            put("预订员",114);
            put("调酒师/吧台员",114);
            put("送餐员",112);
            put("主持/司仪",114);
            put("预订部主管",114);
            put("大堂经理",108);
            put("前厅部经理/主管",108);
            put("楼面经理",108);
            put("粤菜厨师",101);
            put("鲁菜厨师",101);
            put("凉菜厨师",101);
            put("日韩料理厨师",101);
            put("川菜厨师",101);
            put("湘菜厨师",101);
            put("西餐厨师",101);
            put("拉面师",104);
            put("烧烤师",101);
            put("食堂厨师",101);
            put("咖啡师",111);
            put("餐饮店长/经理",300);
            put("奶茶/饮品店员",100);
            put("行政主厨",101);
            put("品酒师",114);
            put("行李员",114);
            put("清洁服务人员",125);
            put("酒店试睡员",114);
            put("宴会管理",114);
            put("安全消防",114);
            put("其他餐饮/酒店职位",114);
            put("导游",147);
            put("计调",161);
            put("订票/订房服务",161);
            put("签证业务办理",161);
            put("旅游产品销售",251);
            put("旅游产品/线路策划",256);
            put("旅游顾问",251);
            put("潜水员",161);
            put("驯兽师/水族馆表演演员",161);
            put("机场代表",161);
            put("其他旅游职位",161);
            put("仓库管理员",124);
            put("快递员",153);
            put("跟单员",299);
            put("调度员",299);
            put("报关员",299);
            put("安检员",299);
            put("采购主管/经理",299);
            put("物流主管/经理",299);
            put("物流专员/助理",299);
            put("国际贸易专员/经理",299);
            put("国内贸易专员/经理",299);
            put("水运/空运/陆运人员",299);
            put("水运/空运/陆运销售",299);
            put("水运/空运/陆运驾驶操作",299);
            put("飞机/火车/公交/地铁乘务",299);
            put("船员/船长",299);
            put("地勤人员",299);
            put("交通管理员",299);
            put("供应商开发/管理",299);
            put("订单处理员",299);
            put("物料经理/专员",299);
            put("物流销售",299);
            put("集装箱操作/维护业务",299);
            put("海关事务管理",299);
            put("项目经理/主管",299);
            put("供应链主管/经理/专员",299);
            put("货运代理",299);
            put("运输经理/主管",299);
            put("单证员",299);
            put("理货/分拣/打包",299);
            put("物流/仓储项目管理",299);
            put("供应商/采购质量管理",299);
            put("其他贸易/物流职位",299);
            put("保洁/清洁工",141);
            put("保安",145);
            put("保姆/护工",142);
            put("月嫂/育婴",143);
            put("小时工/钟点工",140);
            put("洗衣工",150);
            put("婚礼/庆典策划服务",161);
            put("家电维修",161);
            put("手机维修",161);
            put("电脑维修",45);
            put("寻呼员/话务员",161);
            put("其他家政职位",161);
            put("物业顾问",161);
            put("物业招商/租赁/租售",161);
            put("物业维修",155);
            put("物业管理",155);
            put("物业设施管理",155);
            put("监控维护",161);
            put("停车管理",160);
            put("绿化工",161);
            put("其他物业管理职位",161);
            put("按摩师",156);
            put("足疗师",157);
            put("针灸推拿",158);
            put("其他保健按摩职位",161);
            put("健身顾问/教练",154);
            put("瑜伽教练",154);
            put("瘦身顾问",154);
            put("舞蹈老师",154);
            put("游泳教练",154);
            put("救生员",154);
            put("其他运动健身职位",154);
            put("美发师",129);
            put("美发助理",136);
            put("美容师",130);
            put("美容助理",137);
            put("美甲师",131);
            put("美体师",132);
            put("美容店长",134);
            put("美发店长",134);
            put("美容导师",135);
            put("宠物美容师",130);
            put("其他美容美发职位",139);
            put("市场专员/经理",256);
            put("市场策划专员/经理",256);
            put("市场营销专员/经理",256);
            put("市场调研与分析",256);
            put("公关媒介专员/经理",256);
            put("会务专员/经理",256);
            put("品牌专员/经理",256);
            put("促销专员/经理",256);
            put("广告创意/设计/文案",256);
            put("市场总监",256);
            put("活动策划/执行",256);
            put("网站推广/SEO/SEM",256);
            put("媒介销售",251);
            put("政府事务管理",299);
            put("学术推广",299);
            put("新店开发",299);
            put("市场通路专员/经理",299);
            put("其他市场/公关职位",299);
            put("客户主管/专员",251);
            put("业务拓展",251);
            put("会展策划/设计",261);
            put("企业策划人员",261);
            put("文案策划",261);
            put("婚礼策划服务",261);
            put("美术指导",257);
            put("制作执行",299);
            put("项目管理人员",299);
            put("媒介策划/管理",256);
            put("设计/创意管理师",257);
            put("客户经理/总监",259);
            put("设计/创意总监",257);
            put("其他广告/会展职位",299);
            put("美术编辑/设计",257);
            put("产品/包装设计",257);
            put("展示/装潢设计",257);
            put("平面设计",257);
            put("家具设计",257);
            put("多媒体/动画设计",257);
            put("工艺品/珠宝设计",257);
            put("店面/陈列/展览设计",257);
            put("印刷排版/制版",257);
            put("设计管理人员",257);
            put("设计/制图",257);
            put("创意指导/总监",257);
            put("工业设计",257);
            put("原画/绘画师",257);
            put("游戏界面设计",257);
            put("三维/3D设计/制作",257);
            put("设计/开发",257);
            put("特效设计",257);
            put("家居用品设计",257);
            put("玩具设计",257);
            put("音效设计师",257);
            put("用户体验（UE/UX）设计",257);
            put("用户界面（UI）/视觉设计",257);
            put("其他美术/设计职位",257);
            put("摄影师",40);
            put("摄像",40);
            put("编导",40);
            put("配音",40);
            put("影视策划",40);
            put("后期制作",40);
            put("化妆师",133);
            put("舞蹈演员",299);
            put("歌手",299);
            put("主持人",299);
            put("模特",23);
            put("导演助理",299);
            put("化妆助理",133);
            put("摄影助理",40);
            put("灯光助理",299);
            put("服装助理",299);
            put("驻唱/歌手",299);
            put("演员/群众演员",299);
            put("艺术指导/舞美设计",299);
            put("放映管理",299);
            put("转播工程师",299);
            put("调色员",299);
            put("音效师",299);
            put("主播/经纪人",299);
            put("保险经纪人",251);
            put("保险精算师",251);
            put("保险核保/理赔",251);
            put("保险客户服务/续期管理员",251);
            put("保险培训师",251);
            put("储备经理人",251);
            put("保险产品开发/项目策划",251);
            put("保险内勤",251);
            put("契约管理员",251);
            put("保险业务主管/经理",251);
            put("理财/保险/财务规划师",251);
            put("汽车定损/车险理赔",251);
            put("其他保险职位",251);
            put("专业/企管顾问",260);
            put("咨询员",260);
            put("调研员",260);
            put("涉外咨询师",260);
            put("咨询经理",260);
            put("咨询总监",260);
            put("数据分析师",260);
            put("情报信息分析",260);
            put("咨询项目管理",260);
            put("其他咨询/顾问职位",260);
            put("教师",200);
            put("助教",200);
            put("家教",25);
            put("幼教",201);
            put("教育产品开发",249);
            put("培训师/讲师",204);
            put("培训策划",204);
            put("教学/教务管理人员",249);
            put("招生/课程顾问",202);
            put("科研人员",249);
            put("科研管理人员",249);
            put("志愿者",249);
            put("培训生",249);
            put("实习生",249);
            put("毕业生",249);
            put("储备干部",249);
            put("音乐教师",200);
            put("英语教师",200);
            put("舞蹈教师",200);
            put("美术教师",200);
            put("体育教师/教练",200);
            put("外籍教师",200);
            put("校长/副校长",200);
            put("培训督导",203);
            put("其他教育/培训职位",249);
            put("房地产经纪人",258);
            put("房地产店长/经理",259);
            put("房地产开发/策划",256);
            put("房地产项目招投标专员",299);
            put("房地产评估师",299);
            put("房地产销售",258);
            put("房产项目配套工程师",299);
            put("房地产中介/交易",258);
            put("房地产项目管理",299);
            put("房地产资产管理",299);
            put("监察人员",299);
            put("房地产客服",252);
            put("房地产投资分析",299);
            put("其他房产服务职位",299);
            put("律师",299);
            put("法律顾问",299);
            put("律师助理",299);
            put("法务人员",299);
            put("知识产权顾问",299);
            put("合同管理",299);
            put("合规经理/主管/专员",299);
            put("其他法律职位",299);

        }});
    }




}
