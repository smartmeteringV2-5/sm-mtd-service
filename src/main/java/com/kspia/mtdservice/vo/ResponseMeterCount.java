package com.kspia.mtdservice.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 2022-12-14
 * @author MINHYE
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 서버로부터 계량기 상태별 카운트를 담기 위한 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-14 MINHYE : 최초 작성
 */
@Data
@NoArgsConstructor
public class ResponseMeterCount {
    private int meterLowBatteryCnt;
    private int overflowCnt;
    private int waterLeakCnt;
}
