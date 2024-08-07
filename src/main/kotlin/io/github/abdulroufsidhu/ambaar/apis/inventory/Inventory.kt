package io.github.abdulroufsidhu.ambaar.apis.inventory

import com.fasterxml.jackson.annotation.JsonIgnore
import io.github.abdulroufsidhu.ambaar.apis.branch.Branch
import io.github.abdulroufsidhu.ambaar.apis.core.BaseTable
import io.github.abdulroufsidhu.ambaar.apis.product.Product
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "inventory")
data class Inventory(

    var color: String? = null,
    var description: String? = null,
    @Column(name = "quantity_in_stock")
    var quantityInStock: Int? = null,
    @Column(name = "unit_price")
    var unitPrice: Double? = null,
    @Column(name = "allowed_discount_in_percent")
    var allowedDiscountInPercent: Int? = null,
    @Column(name = "purchase_price")
    var purchasePrice: Double? = null,

    @ManyToOne(targetEntity = Branch::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    @JsonIgnore
    var branch: Branch? = null,

    @ManyToOne(targetEntity = Product::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product: Product? = null,

    override var id: UUID? = null,
    override var createdAt: Instant? = null,
    override var updatedAt: Instant? = null,
) : BaseTable(id, createdAt, updatedAt)
