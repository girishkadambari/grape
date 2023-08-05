package com.grape.model;




import com.grape.model.enums.TagType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name = "tag_uses")
@Data
public class TagUse  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TagType type;

    @ManyToOne
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "tag_id", referencedColumnName = "id", insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Tag tag;

    @ManyToOne
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @NotFound(action = NotFoundAction.IGNORE)
    @WhereJoinTable(clause = "type ='FEED'")
    private Feed feed;


    public TagUse() {
        super();
    }

    public String getTagName() {
        return getTag() != null ? getTag().getName() : null;
    }
}
