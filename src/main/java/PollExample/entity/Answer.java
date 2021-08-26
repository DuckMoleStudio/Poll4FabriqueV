package PollExample.entity;
import lombok.*;

import javax.persistence.*;

//LOMBOK
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

//JPA - HIBERNATE
@Entity(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Answer_answerId")
    @SequenceGenerator(name = "Answer_answerId", sequenceName = "Answer_answerId", allocationSize = 1)
    private int answerId;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    private String answerText;
}
