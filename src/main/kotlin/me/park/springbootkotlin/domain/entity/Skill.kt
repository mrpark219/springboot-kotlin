package me.park.springbootkotlin.domain.entity

import jakarta.persistence.*
import me.park.springbootkotlin.domain.constant.SkillType

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null

    var name: String = name

    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type)

    var isActive: Boolean = isActive
}