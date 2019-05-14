package com.todo.api;

import com.todo.common.dto.SearchDTO;
import com.todo.common.entity.Todo;
import com.todo.common.repo.TodoRepository;
import com.todo.common.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuerydslTest {

    @Autowired
    private SearchService searchService;

    @Test
    public void querydsl_기본_기능_확인(){
        //given
        String title = "할일2";
        String content = "내";
//        String afterDate = "2019-05-14T14:00:00";
        String beforeDate = "2019-05-15T16:00:00";

        SearchDTO dto = new SearchDTO();
        dto.setTitle(title);
        dto.setContent(content);
        dto.setAfterDate(null);
        dto.setBeforeDate(beforeDate);
        dto.setStatus(null);

        //when
        List<Todo> result = searchService.search(dto);

        log.info("result.size={}",result.size());
        //then
        result.stream().forEach(a->log.info("{}",a));
    }

}
