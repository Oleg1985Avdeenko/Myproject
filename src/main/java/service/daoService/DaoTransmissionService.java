package service.daoService;

import service.Service;
import service.dto.TransmissionDto;
import service.mapping.MappingService;
import service.mapping.MappingTrandmission;
import dao.DaoTransmissionImpl;
import dao.interfaces.DAO;
import entity.cars.Transmission;

import java.util.List;
import java.util.stream.Collectors;

public class DaoTransmissionService  implements Service<TransmissionDto> {
    private final DAO<Transmission> daoTransmission = new DaoTransmissionImpl();

    private final MappingService<Transmission, TransmissionDto> mappingTrandmission = new MappingTrandmission();


    @Override
    public TransmissionDto save(TransmissionDto transmissionDto) {
        Transmission transmission = mappingTrandmission.convertToEntity(transmissionDto);
        daoTransmission.save(transmission);
        transmissionDto.setId(transmission.getId());
        return mappingTrandmission.convertToDTO(transmission);
    }

    @Override
    public TransmissionDto update(TransmissionDto transmissionDto) {
        Transmission transmission = mappingTrandmission.convertToEntity(transmissionDto);
        daoTransmission.update(transmission);
        return mappingTrandmission.convertToDTO(transmission);
    }

    @Override
    public TransmissionDto findById(TransmissionDto transmissionDto) {
        Transmission transmission = mappingTrandmission.convertToEntity(transmissionDto);
        transmission = daoTransmission.findById(transmission);
        return mappingTrandmission.convertToDTO(transmission);
    }

    @Override
    public void delete(TransmissionDto transmissionDto) {
        daoTransmission.findById(mappingTrandmission.convertToEntity(transmissionDto));
    }

    @Override
    public List<TransmissionDto> findAll(TransmissionDto transmissionDto) {
        List<Transmission> transmissions = daoTransmission.findAll(Transmission.builder().build());
        return transmissions.stream()
                .map(mappingTrandmission::convertToDTO)
                .collect(Collectors.toList());
    }
}
