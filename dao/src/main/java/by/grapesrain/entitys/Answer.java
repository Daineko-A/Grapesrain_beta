package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by Alexandr on 16.07.2017.
 */
@Entity
@Table(name = "answer")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class Answer extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "body")
    private String body;

    @Getter
    @Column(name = "publicateDate")
    private LocalDateTime answerDate = LocalDateTime.now();
}
