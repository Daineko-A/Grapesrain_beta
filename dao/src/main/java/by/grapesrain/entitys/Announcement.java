package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Daynekoa on 27.05.2017.
 */
@Entity
@Table(name = "announcement")
@ToString(callSuper = true)
@NoArgsConstructor
public class Announcement extends BaseEntity {

    public Announcement(String title, String body, User creator, LocalDateTime begin, LocalDateTime end, Departament departament) {
        this.title = title;
        this.body = body;
        this.creator = creator;
        this.begin = begin;
        this.end = end;
        this.departament = departament;
    }

    @Setter
    @Getter
    @Column(name = "title")
    private String title;

    @Setter
    @Getter
    @Column(name = "body")
    private String body;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "creator_user_id")
    private User creator;

    @Setter
    @Getter
    @Column(name = "begin")
    private LocalDateTime begin;

    @Setter
    @Getter
    @Column(name = "end")
    private LocalDateTime end;

    @Getter
    @Setter
    @Column(name = "an_create")
    private LocalDateTime create = LocalDateTime.now();

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "departament_id")
    private Departament departament;
}
