package com.example.ezports.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode {
    //  Member
    // 400 BAD_REQUEST - 잘못된 요청
    NOT_VALID_EMAIL(BAD_REQUEST, "유효하지 않은 이메일 입니다."),
    NOT_VALID_CODE(BAD_REQUEST, "유효하지 않은 코드 입니다."),

    // 401 Unauthorized - 권한 없음
    INVALID_TOKEN(UNAUTHORIZED, "토큰이 유효하지 않습니다."),
    LOGIN_REQUIRED(UNAUTHORIZED, "로그인이 필요한 서비스입니다."),
    AUTHENTICATION_REQUIRED(UNAUTHORIZED, "인증 정보가 유효하지 않습니다."),
    TOKEN_EXPIRED(UNAUTHORIZED, "토큰의 유효기간이 지났습니다."),
    INVALID_CODE(UNAUTHORIZED, "유효하지 않은 코드입니다."),
    MEMBER_NOT_AUTHORIZED(UNAUTHORIZED, "접근 권한이 있는 회원이 아닙니다."),
    // 404 Not Found - 찾을 수 없음
    NEED_AGREE_REQUIRE_TERMS(NOT_FOUND, "필수 약관에 동의해 주세요."),
    MEMBER_NOT_FOUND(NOT_FOUND, "등록된 사용자가 없습니다."),
    MEMBER_INFO_NOT_FOUND(NOT_FOUND, "등록된 사용자 정보가 없습니다."),
    // 409 CONFLICT : Resource 를 찾을 수 없음
    DUPLICATE_EMAIL(CONFLICT, "중복된 이메일이 존재합니다."),

    //  Sport
    // 404 Not Found - 찾을 수 없음
    SPORT_NOT_FOUND(NOT_FOUND, "존재하지 않는 종목입니다."),

    //Team
    //404 Not Found - 찾을 수 없음
    TEAM_NOT_FOUND(NOT_FOUND, "존재하지 않는 팀입니다."),

    //League
    //404 Not Found - 찾을 수 없음
    League_NOT_FOUND(NOT_FOUND, "존재하지 않는 리그입니다."),

    //Match
    //404 Not Found - 찾을 수 없음
    MATCH_NOT_FOUND(NOT_FOUND, "존재하지 않는 경기입니다."),
    ;




    private final HttpStatus httpStatus;
    private final String message;
}
