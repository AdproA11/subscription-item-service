package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "subscription_boxes")
public class SubscriptionBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private BoxType type;

    @OneToMany(mappedBy = "subscriptionBox", cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();
}