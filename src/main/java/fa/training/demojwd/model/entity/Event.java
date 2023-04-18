package fa.training.demojwd.model.entity;

import fa.training.demojwd.model.enums.EventStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Event extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    @Nationalized
    private String description;

    @Column
    private LocalDateTime openToRegistrationDateTime;

    @Column
    private LocalDateTime closeToRegistrationDateTime;

    @Column
    private LocalDateTime startDateTime;

    @Column
    private LocalDateTime endDateTime;

    @Column
    private String place;

    @Column
    private Boolean isPublic;

    @Column
    private Integer capacity;

    @Column
    @Enumerated(EnumType.STRING)
    private EventStatus status;

}

