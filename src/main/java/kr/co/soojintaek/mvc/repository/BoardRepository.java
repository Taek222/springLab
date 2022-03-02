package kr.co.soojintaek.mvc.repository;

import kr.co.soojintaek.mvc.domain.Board;
import kr.co.soojintaek.mvc.parameter.BoardParameter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
*
* BoardRepository
*
* @author psjin
* @version 1.0.0
* 작성일 2022-01-26
**/
@Repository
public interface BoardRepository {

    List<Board> getList();
    Board get(int boardSeq);
    void save(BoardParameter board);
    void delete(int boardSeq);
    void update(BoardParameter board);

    void saveList(Map<String, Object> paramMap);
}
