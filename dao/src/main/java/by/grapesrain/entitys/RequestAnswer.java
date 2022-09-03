package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by PloSkiY on 10.07.2017.
 */
@Entity
@Table(name = "requestanswer")
@ToString(callSuper = true, exclude = {"request", "respondent"})
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "answer_id")
public class RequestAnswer extends Answer {

    public RequestAnswer(Request request, User respondent, String body) {
        this.request = request;
        this.respondent = respondent;
        this.setBody(body);
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
}
