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
@ToString(callSuper = true, exclude = {"request", "respondent"})
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "answer_id")
public class RequestAnswer extends Answer{

    public RequestAnswer(Request request, User respondent, String body) {
        this.request = request;
        this.respondent = respondent;
        this.setBody(body);
//        this.body = body;
    }

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

//    @Getter
//    @Setter
//    @Column(name = "body")
//    private String body;

//    @Getter
//    @Column(name = "publicateDate")
//    private LocalDateTime answerDate = LocalDateTime.now();
}
