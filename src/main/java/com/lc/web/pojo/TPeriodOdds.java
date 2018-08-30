package com.lc.web.pojo;

import javax.persistence.*;

/**
 * @author lc
 * @since 2018-08-16
 */
@Entity
@Table(name = "t_period_odds")
public class TPeriodOdds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 16)
    private Long id;

    private Long gameId;
    /**
     * 第多少期
     */
    @Column(name = "period", columnDefinition = " float(16)   COMMENT '第多少期' ")
    private String period;
    /**
     * 参与人数
     */
    @Column(name = "num_of_people", columnDefinition = " float(16)   COMMENT '参与人数' ")
    private Float numOfPeople;
    /**
     * 压大
     */
    @Column(name = "big_odds", columnDefinition = " float(16)   COMMENT '压大' ")
    private Float bigOdds;
    /**
     * 压小
     */
    @Column(name = "small_odds", columnDefinition = " float(16)   COMMENT '压小' ")
    private Float smallOdds;
    /**
     * 压单
     */
    @Column(name = "single_odds", columnDefinition = " float(16)   COMMENT '压单' ")
    private Float singleOdds;
    /**
     * 压双
     */
    @Column(name = "single_odds", columnDefinition = " float(16)   COMMENT '压单' ")
    private Float doubleOdds;
    /**
     * 压大单
     */
    @Column(name = "big_single_odds", columnDefinition = " float(16)   COMMENT '压大单' ")
    private Float bigSingleOdds;
    /**
     * 压大双
     */
    @Column(name = "big_double_odds", columnDefinition = " float(16)   COMMENT '压大双' ")
    private Float bigDoubleOdds;
    /**
     * 压小单
     */
    @Column(name = "small_single_odds", columnDefinition = " float(16)   COMMENT '压小单' ")
    private Float smallSingleOdds;
    /**
     * 压小双
     */
    @Column(name = "small_double_odds", columnDefinition = " float(16)   COMMENT '压小双' ")
    private Float smallDoubleOdds;
    /**
     * 压对子
     */
    @Column(name = "single_odds", columnDefinition = " float(16)   COMMENT '压对子' ")
    private Float coupletOdds;
    /**
     * 压顺子
     */
    @Column(name = "along_odds", columnDefinition = " float(16)   COMMENT '压顺子' ")
    private Float alongOdds;
    /**
     * 压豹子
     */
    @Column(name = "leopard_odds", columnDefinition = " float(16)   COMMENT '压豹子' ")
    private Float leopardOdds;
    /**
     * 0
     */
    @Column(name = "odds_0", columnDefinition = " float(16)   COMMENT '0' ")
    private Float odds0;
    /**
     * 1
     */
    @Column(name = "odds_1", columnDefinition = " float(16)   COMMENT '1' ")
    private Float odds1;
    /**
     * 2
     */
    @Column(name = "odds_2", columnDefinition = " float(16)   COMMENT '2' ")
    private Float odds2;
    /**
     * 3
     */
    @Column(name = "odds_3", columnDefinition = " float(16)   COMMENT '3' ")
    private Float odds3;
    /**
     * 4
     */
    @Column(name = "odds_4", columnDefinition = " float(16)   COMMENT '4' ")
    private Float odds4;
    /**
     * 5
     */
    @Column(name = "odds_5", columnDefinition = " float(16)   COMMENT '5' ")
    private Float odds5;
    /**
     * 6
     */
    @Column(name = "odds_6", columnDefinition = " float(16)   COMMENT '6' ")
    private Float odds6;
    /**
     * 7
     */
    @Column(name = "odds_7", columnDefinition = " float(16)   COMMENT '7' ")
    private Float odds7;
    /**
     * 8
     */
    @Column(name = "odds_8", columnDefinition = " float(16)   COMMENT '8' ")
    private Float odds8;
    /**
     * 9
     */
    @Column(name = "odds_9", columnDefinition = " float(16)   COMMENT '9' ")
    private Float odds9;
    /**
     * 10
     */
    @Column(name = "odds_10", columnDefinition = " float(16)   COMMENT '10' ")
    private Float odds10;
    /**
     * 11
     */
    @Column(name = "odds_11", columnDefinition = " float(16)   COMMENT '11' ")
    private Float odds11;
    /**
     * 12
     */
    @Column(name = "odds_12", columnDefinition = " float(16)   COMMENT '12' ")
    private Float odds12;
    /**
     * 13
     */
    @Column(name = "odds_13", columnDefinition = " float(16)   COMMENT '13' ")
    private Float odds13;
    /**
     * 14
     */
    @Column(name = "odds_14", columnDefinition = " float(16)   COMMENT '14' ")
    private Float odds14;
    /**
     * 15
     */
    @Column(name = "odds_15", columnDefinition = " float(16)   COMMENT '15' ")
    private Float odds15;
    /**
     * 16
     */
    @Column(name = "odds_16", columnDefinition = " float(16)   COMMENT '16' ")
    private Float odds16;
    /**
     * 17
     */
    @Column(name = "odds_17", columnDefinition = " float(16)   COMMENT '17' ")
    private Float odds17;
    /**
     * 18
     */
    @Column(name = "odds_18", columnDefinition = " float(16)   COMMENT '18' ")
    private Float odds18;
    /**
     * 19
     */
    @Column(name = "odds_19", columnDefinition = " float(16)   COMMENT '19' ")
    private Float odds19;
    /**
     * 20
     */
    @Column(name = "odds_20", columnDefinition = " float(16)   COMMENT '20' ")
    private Float odds20;
    /**
     * 21
     */
    @Column(name = "odds_21", columnDefinition = " float(16)   COMMENT '21' ")
    private Float odds21;
    /**
     * 22
     */
    @Column(name = "odds_22", columnDefinition = " float(16)   COMMENT '22' ")
    private Float odds22;
    /**
     * 23
     */
    @Column(name = "odds_23", columnDefinition = " float(16)   COMMENT '23' ")
    private Float odds23;
    /**
     * 24
     */
    @Column(name = "odds_24", columnDefinition = " float(16)   COMMENT '24' ")
    private Float odds24;
    /**
     * 25
     */
    @Column(name = "odds_25", columnDefinition = " float(16)   COMMENT '25' ")
    private Float odds25;
    /**
     * 26
     */
    @Column(name = "odds_26", columnDefinition = " float(16)   COMMENT '26' ")
    private Float odds26;
    /**
     * 27
     */
    @Column(name = "odds_27", columnDefinition = " float(16)   COMMENT '压单' ")
    private Float odds27;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Float getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(Float numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public Float getBigOdds() {
        return bigOdds;
    }

    public void setBigOdds(Float bigOdds) {
        this.bigOdds = bigOdds;
    }

    public Float getSmallOdds() {
        return smallOdds;
    }

    public void setSmallOdds(Float smallOdds) {
        this.smallOdds = smallOdds;
    }

    public Float getSingleOdds() {
        return singleOdds;
    }

    public void setSingleOdds(Float singleOdds) {
        this.singleOdds = singleOdds;
    }

    public Float getDoubleOdds() {
        return doubleOdds;
    }

    public void setDoubleOdds(Float doubleOdds) {
        this.doubleOdds = doubleOdds;
    }

    public Float getBigSingleOdds() {
        return bigSingleOdds;
    }

    public void setBigSingleOdds(Float bigSingleOdds) {
        this.bigSingleOdds = bigSingleOdds;
    }

    public Float getBigDoubleOdds() {
        return bigDoubleOdds;
    }

    public void setBigDoubleOdds(Float bigDoubleOdds) {
        this.bigDoubleOdds = bigDoubleOdds;
    }

    public Float getSmallSingleOdds() {
        return smallSingleOdds;
    }

    public void setSmallSingleOdds(Float smallSingleOdds) {
        this.smallSingleOdds = smallSingleOdds;
    }

    public Float getSmallDoubleOdds() {
        return smallDoubleOdds;
    }

    public void setSmallDoubleOdds(Float smallDoubleOdds) {
        this.smallDoubleOdds = smallDoubleOdds;
    }

    public Float getCoupletOdds() {
        return coupletOdds;
    }

    public void setCoupletOdds(Float coupletOdds) {
        this.coupletOdds = coupletOdds;
    }

    public Float getAlongOdds() {
        return alongOdds;
    }

    public void setAlongOdds(Float alongOdds) {
        this.alongOdds = alongOdds;
    }

    public Float getLeopardOdds() {
        return leopardOdds;
    }

    public void setLeopardOdds(Float leopardOdds) {
        this.leopardOdds = leopardOdds;
    }

    public Float getOdds0() {
        return odds0;
    }

    public void setOdds0(Float odds0) {
        this.odds0 = odds0;
    }

    public Float getOdds1() {
        return odds1;
    }

    public void setOdds1(Float odds1) {
        this.odds1 = odds1;
    }

    public Float getOdds2() {
        return odds2;
    }

    public void setOdds2(Float odds2) {
        this.odds2 = odds2;
    }

    public Float getOdds3() {
        return odds3;
    }

    public void setOdds3(Float odds3) {
        this.odds3 = odds3;
    }

    public Float getOdds4() {
        return odds4;
    }

    public void setOdds4(Float odds4) {
        this.odds4 = odds4;
    }

    public Float getOdds5() {
        return odds5;
    }

    public void setOdds5(Float odds5) {
        this.odds5 = odds5;
    }

    public Float getOdds6() {
        return odds6;
    }

    public void setOdds6(Float odds6) {
        this.odds6 = odds6;
    }

    public Float getOdds7() {
        return odds7;
    }

    public void setOdds7(Float odds7) {
        this.odds7 = odds7;
    }

    public Float getOdds8() {
        return odds8;
    }

    public void setOdds8(Float odds8) {
        this.odds8 = odds8;
    }

    public Float getOdds9() {
        return odds9;
    }

    public void setOdds9(Float odds9) {
        this.odds9 = odds9;
    }

    public Float getOdds10() {
        return odds10;
    }

    public void setOdds10(Float odds10) {
        this.odds10 = odds10;
    }

    public Float getOdds11() {
        return odds11;
    }

    public void setOdds11(Float odds11) {
        this.odds11 = odds11;
    }

    public Float getOdds12() {
        return odds12;
    }

    public void setOdds12(Float odds12) {
        this.odds12 = odds12;
    }

    public Float getOdds13() {
        return odds13;
    }

    public void setOdds13(Float odds13) {
        this.odds13 = odds13;
    }

    public Float getOdds14() {
        return odds14;
    }

    public void setOdds14(Float odds14) {
        this.odds14 = odds14;
    }

    public Float getOdds15() {
        return odds15;
    }

    public void setOdds15(Float odds15) {
        this.odds15 = odds15;
    }

    public Float getOdds16() {
        return odds16;
    }

    public void setOdds16(Float odds16) {
        this.odds16 = odds16;
    }

    public Float getOdds17() {
        return odds17;
    }

    public void setOdds17(Float odds17) {
        this.odds17 = odds17;
    }

    public Float getOdds18() {
        return odds18;
    }

    public void setOdds18(Float odds18) {
        this.odds18 = odds18;
    }

    public Float getOdds19() {
        return odds19;
    }

    public void setOdds19(Float odds19) {
        this.odds19 = odds19;
    }

    public Float getOdds20() {
        return odds20;
    }

    public void setOdds20(Float odds20) {
        this.odds20 = odds20;
    }

    public Float getOdds21() {
        return odds21;
    }

    public void setOdds21(Float odds21) {
        this.odds21 = odds21;
    }

    public Float getOdds22() {
        return odds22;
    }

    public void setOdds22(Float odds22) {
        this.odds22 = odds22;
    }

    public Float getOdds23() {
        return odds23;
    }

    public void setOdds23(Float odds23) {
        this.odds23 = odds23;
    }

    public Float getOdds24() {
        return odds24;
    }

    public void setOdds24(Float odds24) {
        this.odds24 = odds24;
    }

    public Float getOdds25() {
        return odds25;
    }

    public void setOdds25(Float odds25) {
        this.odds25 = odds25;
    }

    public Float getOdds26() {
        return odds26;
    }

    public void setOdds26(Float odds26) {
        this.odds26 = odds26;
    }

    public Float getOdds27() {
        return odds27;
    }

    public void setOdds27(Float odds27) {
        this.odds27 = odds27;
    }



    @Override
    public String toString() {
        return "TPeriodOdds{" +
        "id=" + id +
        ", period=" + period +
        ", numOfPeople=" + numOfPeople +
        ", bigOdds=" + bigOdds +
        ", smallOdds=" + smallOdds +
        ", singleOdds=" + singleOdds +
        ", doubleOdds=" + doubleOdds +
        ", bigSingleOdds=" + bigSingleOdds +
        ", bigDoubleOdds=" + bigDoubleOdds +
        ", smallSingleOdds=" + smallSingleOdds +
        ", smallDoubleOdds=" + smallDoubleOdds +
        ", coupletOdds=" + coupletOdds +
        ", alongOdds=" + alongOdds +
        ", leopardOdds=" + leopardOdds +
        ", odds0=" + odds0 +
        ", odds1=" + odds1 +
        ", odds2=" + odds2 +
        ", odds3=" + odds3 +
        ", odds4=" + odds4 +
        ", odds5=" + odds5 +
        ", odds6=" + odds6 +
        ", odds7=" + odds7 +
        ", odds8=" + odds8 +
        ", odds9=" + odds9 +
        ", odds10=" + odds10 +
        ", odds11=" + odds11 +
        ", odds12=" + odds12 +
        ", odds13=" + odds13 +
        ", odds14=" + odds14 +
        ", odds15=" + odds15 +
        ", odds16=" + odds16 +
        ", odds17=" + odds17 +
        ", odds18=" + odds18 +
        ", odds19=" + odds19 +
        ", odds20=" + odds20 +
        ", odds21=" + odds21 +
        ", odds22=" + odds22 +
        ", odds23=" + odds23 +
        ", odds24=" + odds24 +
        ", odds25=" + odds25 +
        ", odds26=" + odds26 +
        ", odds27=" + odds27 +
        "}";
    }
}
