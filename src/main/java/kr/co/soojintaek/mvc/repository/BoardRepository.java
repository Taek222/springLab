package kr.co.soojintaek.mvc.repository;

import kr.co.soojintaek.mvc.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    void save(Board board);
    void delete(int boardSeq);
    void update(Board board);
}
