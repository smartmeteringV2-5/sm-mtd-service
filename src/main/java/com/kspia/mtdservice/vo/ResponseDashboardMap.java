package com.kspia.mtdservice.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 2022-12-13
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 서버로부터 대시보드 지도 데이터를 담기 위한 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-13 kkny3 : 최초 작성
 */
@Data
@NoArgsConstructor
public class ResponseDashboardMap {
    private String geoX;
    private String geoY;
    private String daumX;
    private String daumY;
    private String mngId;
    private String waterUserType;
}
