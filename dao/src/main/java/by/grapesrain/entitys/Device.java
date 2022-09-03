package by.grapesrain.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by PloSkiY on 14.07.2017.
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Device {

    @Getter
    @Setter
    @Column(name = "model_device")
    private String modelDrvice;

    @Getter
    @Setter
    @Column(name = "mac_address")
    private String macAddress;
}
