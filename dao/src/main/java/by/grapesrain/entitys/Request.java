package by.grapesrain.entitys;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.*;

/**
 * Created by Daynekoa on 27.05.2017.
 */

@Entity
@Table(name = "request")
@ToString(callSuper = true, exclude = "creator, executor")
@NoArgsConstructor
public class Request extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    @Getter
    @Setter
    @Column(name = "body")
    private String body;

    @Getter
    @Setter
    @Column(name = "req_create")
    private LocalDateTime create;

    @Getter
    @Setter
    @Column(name = "req_close")
    private LocalDateTime close;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "creator_user_id")
    private User creator;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "executor_user_id")
    private User executor;

    @Getter
    @Setter
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @Setter
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;
}
