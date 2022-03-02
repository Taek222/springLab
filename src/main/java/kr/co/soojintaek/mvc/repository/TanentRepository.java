package kr.co.soojintaek.mvc.repository;

import kr.co.soojintaek.mvc.domain.Tanent;
import org.springframework.stereotype.Repository;


/**
*
* TanentRepository
*
* @author psjin
* @version 1.0.0
* 작성일 2022-01-26
**/
@Repository
public interface TanentRepository {

    Tanent getTanentDetail(String domain);

}
