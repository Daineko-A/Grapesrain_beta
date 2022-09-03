package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by Alexandr on 15.07.2017.
 */
@Entity
@Table(name = "user_card")
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"user"})
public class UserCard extends BaseEntity {

    @Getter
    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "modelDrvice", column = @Column(name = "first_model_device")),
            @AttributeOverride(name = "macAddress", column = @Column(name = "first_mac_address"))
    })
    private Device firstDevice;

    @Getter
    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "modelDrvice", column = @Column(name = "second_model_device")),
            @AttributeOverride(name = "macAddress", column = @Column(name = "second_mac_address"))
    })
    private Device secondDevice;

    @Getter
    @Setter
    @Column(name = "pc_ownership")
    private String PCOwnership;

    @Version
    @Setter
    @Getter
    @Column(name = "version_card")
    private Long version;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
