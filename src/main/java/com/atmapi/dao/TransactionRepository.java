package com.atmapi.dao;

import com.atmapi.model.TransactionDetails;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface  TransactionRepository extends CrudRepository<TransactionDetails,String> {


}
