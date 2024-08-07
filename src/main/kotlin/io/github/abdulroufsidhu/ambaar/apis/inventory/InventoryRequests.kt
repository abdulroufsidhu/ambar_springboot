package io.github.abdulroufsidhu.ambaar.apis.inventory

import io.github.abdulroufsidhu.ambaar.apis.core.Responser
import io.github.abdulroufsidhu.ambaar.apis.employee.Employee
import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Transactional
@RestController
@RequestMapping("/api/inventory")
@CrossOrigin
class InventoryRequests(
    private val inventoryLogics: InventoryLogics
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/{page}")
    fun getInventory(
        @PathVariable("page") page: Int,
        @RequestAttribute("employee") employee: Employee,
    ) = Responser.success {
        logger.info("Getting inventory for branch ${employee.branch.id}")
        inventoryLogics.find(employee.branch.id, page - 1)
    }

    @PutMapping("")
    fun putInventory(
        inventory: Inventory, @RequestAttribute("employee") employee: Employee,
    ) = Responser.success {
        logger.info("Saving inventory $inventory")
        inventoryLogics.save(inventory.copy(branch = employee.branch))
    }

    @PatchMapping("")
    fun updateInventory(
        inventory: Inventory
    ) = Responser.success {
        inventoryLogics.update(inventory)
    }

    @DeleteMapping("/{id}")
    fun deleteInventory(
        @PathVariable("id") id: String
    ) = Responser.success { inventoryLogics.delete(id) }

}