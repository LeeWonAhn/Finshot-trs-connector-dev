package com.lotus.repository;

import com.lotus.entity.InformationTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<InformationTransaction, Integer> {
}
