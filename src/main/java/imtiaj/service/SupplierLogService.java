package imtiaj.service;

import imtiaj.model.SupplierLogEntity;
import imtiaj.repository.SupplierLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SupplierLogService {

    @Autowired
    private SupplierLogRepository supplierLogRepository;

    public void create(SupplierLogEntity supplierLog) {
        supplierLogRepository.create(supplierLog);
    }


    public SupplierLogEntity findById(int id) {
        return supplierLogRepository.findById(id);
    }

    public List<SupplierLogEntity> findAll() {
        return supplierLogRepository.getAll();
    }

    public void updateSupplierLog(SupplierLogEntity supplierLog) {
        supplierLogRepository.edit(supplierLog);
    }

    public void deleteSupplierLog(SupplierLogEntity supplierLog) {
        supplierLogRepository.delete(supplierLog.getSupplierId());
    }



}
