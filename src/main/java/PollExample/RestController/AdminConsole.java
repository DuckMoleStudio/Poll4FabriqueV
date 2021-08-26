package PollExample.RestController;

import PollExample.CommonDBService;
import PollExample.entity.Poll;
import PollExample.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/poll")
public class AdminConsole {
    @Autowired
    private CommonDBService service;


    // poll
    @GetMapping("/listPolls")
    public List<Poll> listPolls() {
        return service.listPolls();
    }

    @GetMapping("/PollById/{id}")
    public Poll pollById(@PathVariable("id") Integer id) {
        return service.findPollById(id);
    }

    @GetMapping("/DeletePollById/{id}")
    public void deletePollById(@PathVariable("id") Integer id) {
       service.deletePollById(id);
    }

    @PostMapping("/newPoll")
    @ResponseStatus(HttpStatus.CREATED)
    public int createPoll(@RequestBody Poll poll) {
        //Preconditions.checkNotNull(pilot.getName(),"Name");
        return service.createPoll(poll);
    }

    // question
    @GetMapping("/listQuestions")
    public List<Question> listQuestions() {
        return service.listQuestions();
    }

    @GetMapping("/QuestionById/{id}")
    public Question questionById(@PathVariable("id") Integer id) {
        return service.findQuestionById(id);
    }

    @GetMapping("/DeleteQuestionById/{id}")
    public void deleteQuestionById(@PathVariable("id") Integer id) {
        service.deleteQuestionById(id);
    }

    @PostMapping("/newQuestion")
    @ResponseStatus(HttpStatus.CREATED)
    public int createQuestion(@RequestBody Question question) {
                return service.createQuestion(question);
    }
}
