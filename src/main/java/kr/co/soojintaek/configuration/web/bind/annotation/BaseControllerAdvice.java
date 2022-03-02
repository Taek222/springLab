package kr.co.soojintaek.configuration.web.bind.annotation;

import kr.co.soojintaek.configuration.exception.BaseException;
import kr.co.soojintaek.configuration.http.BaseResponse;
import kr.co.soojintaek.mvc.domain.Tanent;
import kr.co.soojintaek.mvc.service.TanentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RequiredArgsConstructor
@ControllerAdvice
public class BaseControllerAdvice {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private TanentService tanentService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = {BaseException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private BaseResponse<?> handleBaseException(BaseException e, WebRequest request){
        return new BaseResponse<String>(e.getResponseCode(), messageSource.getMessage(e.getResponseCode().name(), e.getArgs(), null));
    }

    @ModelAttribute
    private Tanent getTanent(@PathVariable String domain){
        /*Tanent tanent = tanentService.getTanentDetail(domain);
        if(tanent == null){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"회사정보"});
        }
        return tanent;*/
        if(domain.contains("tanent"))
            return new Tanent(true);
        else
            return new Tanent(false);

    }

}
