package com.kspia.mtdservice.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 2022-12-13
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 서버로부터 단말기 상태별 카운트를 담기 위한 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-13 kkny3 : 최초 작성
 */
@Data
@NoArgsConstructor
public class ResponseModemCount {
    private int modemLowBatteryCnt;
    private int timeSyncCnt;
    private int disconnectCnt;
}
