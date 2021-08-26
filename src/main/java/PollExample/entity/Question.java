package PollExample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor


@Entity(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Question_questionId")
    @SequenceGenerator(name = "Question_questionId", sequenceName = "Question_questionId", allocationSize = 1)
    private int questionId;

    @OneToMany(mappedBy = "question", orphanRemoval = true)
    private List<Variant> variants;

    @OneToMany(mappedBy = "question", orphanRemoval = true)
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "pollId", nullable = false)
    private Poll poll;

    private String questionText;
}
