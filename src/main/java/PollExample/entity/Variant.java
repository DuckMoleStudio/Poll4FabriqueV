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
@Entity(name = "Variant")
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Variant_variantId")
    @SequenceGenerator(name = "Variant_variantId", sequenceName = "Variant_variantId", allocationSize = 1)
    private int variantId;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    private String variantText;
}
