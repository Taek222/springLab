package kr.co.soojintaek.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.soojintaek.configuration.exception.BaseException;
import kr.co.soojintaek.configuration.http.BaseResponse;
import kr.co.soojintaek.configuration.http.BaseResponseCode;
import kr.co.soojintaek.mvc.domain.Board;
import kr.co.soojintaek.mvc.parameter.BoardParameter;
import kr.co.soojintaek.mvc.service.BoardService;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
*
* BoardController 설명
*
* @author psjin
* @version 1.0.0
* 작성일 2022-01-26
**/
@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {

    @Autowired
    private BoardService boardService;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
    * 기능 : 게시글 목록 리턴
    * 작성일 2022-01-26
    **/
    @GetMapping
    @ApiOperation(value="목록조회", notes="게시물 목록")
    public BaseResponse<List<Board>> getList(){
        return new BaseResponse<List<Board>>(boardService.getList());
    }

    /**
    * 기능 : 게시글 1건 조회
    * 작성일 2022-01-26
    **/
    @GetMapping("/{boardSeq}")
    @ApiOperation(value="상세 조회", notes="게시물 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name="boardSeq", value = "게시물 번호", example = "1")
    })
    public BaseResponse<Board> get(@PathVariable int boardSeq){
        Board board = boardService.get(boardSeq);
        if(board == null){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"게시물"});
        }
        return new BaseResponse<Board>(boardService.get(boardSeq));
    }

    /**
    * 기능 : 게시글 등록/수정 처리
    * 작성일 2022-01-26
    **/
    @PutMapping("/save")
    @ApiOperation(value="등록/수정 처리", notes="신규 게시물 저장 및 기존 게시물 업데이트.")
    @ApiImplicitParams({
            @ApiImplicitParam(name="boardSeq", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name="title", value = "제목", example = "spring 강좌 제목"),
            @ApiImplicitParam(name="contents", value = "내용", example = "spring 강좌 내용")
    })
    public BaseResponse<Integer> save(BoardParameter parameter){
        if(StringUtils.isEmpty(parameter.getTitle())){
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"title", "제목"});
        }
        if(StringUtils.isEmpty(parameter.getContents())){
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"contents", "내용"});
        }
        boardService.save(parameter);
        return new BaseResponse<Integer> (parameter.getBoardSeq());
    }

    /**
    * 기능 : 게시글 삭제
    * 작성일 2022-01-26
    **/
    @DeleteMapping("/delete/{boardSeq}")
    @ApiOperation(value="삭제 처리", notes="게시물 번호에 해당하는 정보를 삭제합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name="boardSeq", value = "게시물 번호", example = "1")
    })
    public BaseResponse<Boolean> delete(@PathVariable int boardSeq){
        Board board = boardService.get(boardSeq);
        if(board == null){
            return new BaseResponse<Boolean>(false);
        }
        boardService.delete(boardSeq);
        return new BaseResponse<Boolean>(true);
    }

    public BaseResponse<Boolean> saveList(){
        int count = 0;
        //테스트를 위한 랜덤 10000건 데이터 생성
        List<BoardParameter> list = new ArrayList<BoardParameter>();
        while(true){
            count++;
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);
            list.add(new BoardParameter(title, contents));
            if(count>=10000){
                break;
            }
        }
        long start = System.currentTimeMillis();
        boardService.saveList(list);
        long end = System.currentTimeMillis();
        logger.info("대용량 동적쿼리 실행 시간 : {}", (end-start)/1000.0);

        long startRecur = System.currentTimeMillis();
        boardService.saveListRecur(list);
        long endRecur = System.currentTimeMillis();
        logger.info("서비스단 반복문 실행 시간 : {}", (endRecur-startRecur)/1000.0);

        return new BaseResponse<Boolean>(true);
    }
}
