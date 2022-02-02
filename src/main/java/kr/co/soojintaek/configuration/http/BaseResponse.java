package kr.co.soojintaek.configuration.http;

import lombok.Data;

/**
*
* BaseResponse 공통으로 사용할 응답 클래스
*
* @author psjin
* @version 1.0.0
* 작성일 2022-02-02
**/
@Data
public class BaseResponse<T> {

    private BaseResponseCode code;
    private String message;
    private T data;

    public BaseResponse(T data) {
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }
}
