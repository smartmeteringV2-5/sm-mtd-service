package com.kspia.mtdservice.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 2022-12-14
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 사용자로부터 요청 받은 수신 상태를 담기 위한 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-13 kkny3 : 최초 작성
 */
@Data
@NoArgsConstructor
public class RequestReceivingState {
    private String stateType;
}
