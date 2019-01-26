package com.muggle.poseidon.model;

import com.muggle.poseidon.core.generater.PoseidonIdGener;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-01-26 17:34
 **/
@Entity
@Table(name = "poseidon_black_list")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@DynamicUpdate
public class uploadFile {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdGener.TYPE)
    private String id;


}
