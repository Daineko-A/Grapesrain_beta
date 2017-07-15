package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Alexandr on 15.07.2017.
 */
@Entity
@Table(name = "user_card")
@NoArgsConstructor
@ToString(callSuper = true)
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
}
