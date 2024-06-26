package io.github.abdulroufsidhu.ambaar.business

import jakarta.transaction.Transactional
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.stereotype.Service

@Service
class BusinessLogic(
    private val businessDao: BusinessDao,
) {

    @Throws(
        IllegalArgumentException::class,
        OptimisticLockingFailureException::class,
        NoSuchElementException::class
    )
    @Transactional
    fun create(business: Business) = businessDao.save(business)

    @Throws(
        IllegalArgumentException::class,
        OptimisticLockingFailureException::class,
        NoSuchElementException::class
    )
    @Transactional
    fun update(business: Business): Business {
        if (business.id.isNullOrBlank()) throw IllegalArgumentException("id not provided")
        return businessDao.save(business)
    }

    fun delete(id: String): Business {
        val business = businessDao.getReferenceById(id)
        return businessDao.save(business.copy(active = false))
    }
}