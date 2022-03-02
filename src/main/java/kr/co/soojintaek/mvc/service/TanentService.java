package kr.co.soojintaek.mvc.service;


import kr.co.soojintaek.mvc.domain.Tanent;
import kr.co.soojintaek.mvc.repository.TanentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
*
* EmployeeService 게시판 서비스
*
* @author psjin
* @version 1.0.0
* 작성일 2022-01-26
**/
@Service
public class TanentService {

    @Autowired
    private TanentRepository tanentRepository;

    /**
    * 기능 : 게시글 1건 조회
    * 작성일 2022-01-26
    **/
    public Tanent getTanentDetail(String domain){
        return tanentRepository.getTanentDetail(domain);
    }

}
