package service.daoService;

import service.Service;
import service.dto.TransmissionDto;
import service.MappingService;
import service.mapping.MappingTrandmission;
import dao.impl.DaoTransmissionImpl;
import dao.DAO;
import entity.cars.Transmission;

import java.util.List;
import java.util.stream.Collectors;

public class DaoTransmissionService  implements Service<TransmissionDto> {
    private final DAO<Transmission> transmissionDAO = new DaoTransmissionImpl();

    private final MappingService<Transmission, TransmissionDto> mappingTransmission = new MappingTrandmission();

    @Override
    public TransmissionDto save(TransmissionDto transmissionDto) {
        Transmission transmission = mappingTransmission.convertToEntity(transmissionDto);
        transmission = transmissionDAO.save(transmission);
        return mappingTransmission.convertToDTO(transmission);
    }

    @Override
    public void update(TransmissionDto transmissionDto) {
        Transmission transmission = mappingTransmission.convertToEntity(transmissionDto);
        transmissionDAO.update(transmission);
    }

    @Override
    public void delete(TransmissionDto transmissionDto) {
        Transmission transmission = mappingTransmission.convertToEntity(transmissionDto);
        transmissionDAO.delete(transmission);
    }

    @Override
    public TransmissionDto findById(TransmissionDto transmissionDto) {
        Transmission transmission = mappingTransmission.convertToEntity(transmissionDto);
        transmission = transmissionDAO.findById(transmission);
        return mappingTransmission.convertToDTO(transmission);
    }

    @Override
    public List<TransmissionDto> findAll() {
        List<Transmission> transmissions = transmissionDAO.findAll(Transmission.builder().build());
        return transmissions.stream()
                .map(mappingTransmission::convertToDTO)
                .collect(Collectors.toList());
    }
}
