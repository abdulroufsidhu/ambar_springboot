package io.github.abdulroufsidhu.orgolink.core.business

import io.github.abdulroufsidhu.orgolink.core.config.BaseTable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


@Entity
@Table(name = "businesses")
data class Business(
    @Column(unique = true)
    @field:NotNull
    @field:NotBlank
    var name: String? = null,
    var description: String? = null,
    @Column(name = "licence_number", unique = true, nullable = false)
    @field:NotNull
    @field:NotBlank
    var licence: String? = null,

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE NOT NULL")
    var active: Boolean = true,

    ) : BaseTable()
