package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Alexandr on 16.07.2017.
 */
//@Entity
//@Table(name = "answer")
//@Inheritance(strategy = InheritanceType.JOINED)
//@NoArgsConstructor
//@ToString(callSuper = true)

public abstract class Answer  {

    //extends BaseEntity

    @Getter
    @Setter
    @Column(name = "body")
    private String body;

    @Getter
    @Column(name = "publicateDate")
    private LocalDateTime answerDate = LocalDateTime.now();

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
