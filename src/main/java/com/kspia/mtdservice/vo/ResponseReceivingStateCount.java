package com.kspia.mtdservice.vo;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 2022-12-13
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 서버로부터 수신 상태별 카운트를 담기 위한 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-13 kkny3 : 최초 작성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseReceivingStateCount {
    private int normalReceptionCnt;
    private int noReceptionCnt;
    private int longTermNoReceptionCnt;

    public static ResponseReceivingStateCount convertMap(Map<String, Integer> map) {
     return ResponseReceivingStateCount.builder()
         .normalReceptionCnt(map.get("normalReception"))
         .noReceptionCnt(map.get("noReception"))
         .longTermNoReceptionCnt(map.get("longTermNoReception"))
         .build();
    }
}
