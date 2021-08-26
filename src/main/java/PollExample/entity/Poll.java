package PollExample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity(name = "Poll")
public class Poll {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="Poll_PollId")
    @SequenceGenerator(name = "Poll_PollId", sequenceName="Poll_PollId", allocationSize = 1)
    private int pollId;

    //@JsonIgnore
    @OneToMany(mappedBy="poll", orphanRemoval = true)
    private List<Question> questions;

    private String name;
    private String description;
    private Date startDate; // should be final
    private Date endDate;

/*
    @Override
    public String toString() { // need we?
        return "Poll{" +
                "pollId=" + pollId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

 */




}
