package com.kspia.mtdservice.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 2022-12-09
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 사용자로부터 요청 받은 검색 조건을 담기 위한 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-09 kkny3 : 최초 작성
     * 2022-12-09 kkny3 : omissionType - 장치 상태를 받아오기 위한 변수 생성
 */
@Data
@NoArgsConstructor
public class RequestSearch {
    private String omissionType;
}
