package kr.co.soojintaek.configuration.exception;

import kr.co.soojintaek.configuration.http.BaseResponseCode;

public abstract class AbstractBaseException extends RuntimeException{

    private static final long serialVersionUID = 8342235231880246631L;

    protected BaseResponseCode responseCode;
    protected Object[] args;

    public AbstractBaseException(){
    }

    public AbstractBaseException(BaseResponseCode baseResponseCode){
        this.responseCode = baseResponseCode;
    }

    public BaseResponseCode getResponseCode(){
        return responseCode;
    }

    public Object[] getArgs(){
        return args;
    }
}
