package com.kspia.mtdservice.vo;

import com.kspia.mtdservice.dto.SearchListDto;
import lombok.Data;

@Data
public class UsagehistoryVO {
	private String fromDate;
	private String toDate;
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

	public SearchListDto convertToSearchListDto() {
		SearchListDto searchListDto = new SearchListDto();
		searchListDto.setDongNm(this.dongId);
		searchListDto.setDividarea(this.bunguId);
		searchListDto.setWateruserName(this.consumerName);
		searchListDto.setWateruserState(this.consumerState);
		searchListDto.setMeter_backflow(this.meteringSignalStatus);
		searchListDto.setMeter_battery(this.meteringSignalStatus);
		searchListDto.setMeter_overflow(this.meteringSignalStatus);
		searchListDto.setMeter_waterleak(this.meteringSignalStatus);
		searchListDto.setModem_rssi(this.modemSignalStatus);
		searchListDto.setModem_battery(this.modemSignalStatus);
		searchListDto.setModem_connect(this.modemSignalStatus);
		searchListDto.setTime_sync(this.modemSignalStatus);
		searchListDto.setWateruserState(this.consumerState);
		return null;
	}
}
