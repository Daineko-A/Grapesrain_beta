package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Alexandr on 15.07.2017.
 */
@Entity
@Table(name = "faq")
@ToString(callSuper = true)
@NoArgsConstructor
public class FAQ extends RequestAnswer {

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String solution;
}
