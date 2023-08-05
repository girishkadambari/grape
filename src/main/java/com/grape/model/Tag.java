package com.grape.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grape.model.enums.TagType;
import lombok.Data;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tags", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Tag  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "name", length = 2000)
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TagType type;

    @Column(name = "count")
    private Integer count;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TagUse> tagUses;
}
