package com.kspia.mtdservice.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kspia.mtdservice.dto.SearchListDto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * @since 2022. 12. 12
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회 Vo 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12.12 jung: 최초 작성
 * 2022.12.08 jung : 실시간 현황 조회 vo 생성
 */
@Data
public class RequestUsageHistoryVO {

	private int page;
	private int size;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime fromDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime toDate;
	private String areaId;  // - 사업소
	private String dongId;  // - 동
	private String bunguId;  // - 분구
	private String mngId;  //- 고객번호
	private String consumerName;  // - 고객명
	private String newAddress;  // - 도로명 주소
	private String oldAddress;  // - 지번 주소
	private String consumerState;  // - 급수전 구분
	private String meteringSignalStatus;  // - 계량기 상태
	private String modemSignalStatus;  // -  단말기 상태
	private String consumerCaliber;  // - 구경
	private String blockL;  // - 대구역
	private String blockM;  // - 중구역
	private String employerNo;  // - 검침원 번호
	private String employerName;  // - 검침원이름
	private String pageInfo;  // - 페이지 화면 정보
	private String meterId;
	private String checkDay;
	private String modemRssiCode;

//	public SearchListDto convertToSearchListDto() {
//		SearchListDto searchListDto = new SearchListDto();
//		searchListDto.setDongNm(this.dongId);
//		searchListDto.setBunguId(this.bunguId);
//		searchListDto.setConsumerName(this.consumerName);
//		searchListDto.setConsumerState(this.consumerState);
//		searchListDto.setBackflow(this.meteringSignalStatus);
//		searchListDto.setMeterBattery(this.meteringSignalStatus);
//		searchListDto.setOverflow(this.meteringSignalStatus);
//		searchListDto.setWaterleak(this.meteringSignalStatus);
//		searchListDto.setModem_rssi(this.modemSignalStatus);
//		searchListDto.setModemBattery(this.modemSignalStatus);
//		searchListDto.setDisconnected(this.modemSignalStatus);
//		searchListDto.setTimeSync(this.modemSignalStatus);
//		searchListDto.setConsumerCaliber(this.consumerCaliber);
//		return null;
//
//	}

}
