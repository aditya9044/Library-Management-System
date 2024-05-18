package org.gfg.jbdlMinor.repository;

import org.gfg.jbdlMinor.model.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnRepository extends JpaRepository<Txn,Integer> {
    Txn findByTxnId(String txnId);
}
