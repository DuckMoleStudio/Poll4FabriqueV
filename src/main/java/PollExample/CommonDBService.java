package PollExample;

import PollExample.entity.Poll;
import PollExample.entity.Question;
import PollExample.repository.AnswerRepository;
import PollExample.repository.PollRepository;
import PollExample.repository.QuestionRepository;
import PollExample.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonDBService {
    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private VariantRepository variantRepository;

    @Autowired
    private AnswerRepository answerRepository;

    //poll
    public List<Poll> listPolls() {
    return pollRepository.findAll();
}
    public int createPoll(Poll poll) {return pollRepository.save(poll).getPollId();}
    public Poll findPollById(Integer id) {
        return pollRepository.findById(id).get();
    }
    public void deletePollById(Integer id) {
        pollRepository.deleteById(id);
    }
    public Poll updatePollById(Integer id, Poll poll) {
        poll.setPollId(id);
        createPoll(poll);
        return pollRepository.findById(id).get();
    }

    //question
    public List<Question> listQuestions() {
        return questionRepository.findAll();
    }
    public int createQuestion(Question question) {return questionRepository.save(question).getQuestionId();}
    public Question findQuestionById(Integer id) {
        return questionRepository.findById(id).get();
    }
    public void deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
    }
    public Question updateQuestionById(Integer id, Question question) {
        question.setQuestionId(id);
        createQuestion(question);
        return questionRepository.findById(id).get();
    }


}
