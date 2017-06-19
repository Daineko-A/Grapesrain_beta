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
@ToString
@NoArgsConstructor
public class Announcement {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    private LocalDateTime create;
}
