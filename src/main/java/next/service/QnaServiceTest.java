package next.service;

import static org.hamcrest. CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import next.CannotOperateException;
import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Question;
import next.model.User;

@RunWith(MockitoJUnitRunner.class)
public class QnaServiceTest {

	@Mock
	private QuestionDao questionDao;
	@Mock
	private AnswerDao anwserDao;
	
	@InjectMocks
	private QnaService qnaService;
	
	@Before
	public void setup(){
		
	}
	
	
	public void testFindById() {
		fail("Not yet implemented");
	}

	
	public void testFindAllByQuestionId() {
		fail("Not yet implemented");
	}
	

	@Test(expected=EmptyResultDataAccessException.class)
	public void testDeleteQuestion1() throws Exception {
		Question q = new Question(1,"test","title","contents",new Date(), 0);
		when(questionDao.findById(1)).thenReturn(null);
		qnaService.deleteQuestion(1, new User("hong", "pw", "name", "email"));
	}
	
	@Test(expected=CannotOperateException.class)
	public void testDeleteQuestion2() throws Exception {
		Question q = new Question(1,"test2","title","contents",new Date(), 0);
		when(questionDao.findById(1)).thenReturn(q);
		qnaService.deleteQuestion(2, new User("hong", "pw", "name", "email"));
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void testDeleteQuestion3() throws Exception {
		Question q = new Question(1,"test2","title","contents",new Date(), 0);
		when(questionDao.findById(1)).thenReturn(q);
		qnaService.deleteQuestion(2, new User("hong", "pw", "name", "email"));
	}
	

	
	public void testUpdateQuestion() {
		fail("Not yet implemented");
	}

}
