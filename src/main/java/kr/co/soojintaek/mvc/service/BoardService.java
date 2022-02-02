package kr.co.soojintaek.mvc.service;

import kr.co.soojintaek.mvc.domain.Board;
import kr.co.soojintaek.mvc.parameter.BoardParameter;
import kr.co.soojintaek.mvc.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* BoardService 게시판 서비스
*
* @author psjin
* @version 1.0.0
* 작성일 2022-01-26
**/
@Service
public class BoardService {

    @Autowired
    private BoardRepository repository;

    /**
    * 기능 : 게시글 목록 리턴
    * 작성일 2022-01-26
    **/
    public List<Board> getList(){
        return repository.getList();
    }

    /**
    * 기능 : 게시글 1건 조회
    * 작성일 2022-01-26
    **/
    public Board get(int boardSeq){
        return repository.get(boardSeq);
    }

    /**
    * 기능 : 게시글 저장 / 수정
    * 작성일 2022-01-26
    **/
    public void save(BoardParameter parameter){
        //조회하여 리턴된 정보 있으면 update 없으면 insert
        Board board = repository.get(parameter.getBoardSeq());
        if(board == null){
            repository.save(parameter);
        }else{
            repository.update(parameter);
        }
    }

    /**
    * 기능 : 게시글 삭제
    * 작성일 2022-01-26
    **/
    public boolean delete(int boardSeq){
        repository.delete(boardSeq);
        return true;
    }
}
