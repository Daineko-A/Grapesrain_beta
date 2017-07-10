package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by PloSkiY on 10.07.2017.
 */
@Entity
@Table(name = "requestanswer")
@ToString(callSuper = true)
@NoArgsConstructor
public class RequestAnswer extends BaseEntity{

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "respondent_user_id")
    private User respondent;

    @Getter
    @Setter
    @Column(name = "body")
    private String body;

    @Getter
    @Setter
    @Column(name = "answerDate")
    private LocalDateTime answerDate;

}
