package service.mapping;

import entity.cars.Transmission;
import service.MappingService;
import service.dto.TransmissionDto;

public class MappingTrandmission implements MappingService<Transmission, TransmissionDto> {
    @Override
    public Transmission convertToEntity(TransmissionDto dto) {
        Transmission transmission = new Transmission();
        transmission.setId(dto.getId());
        transmission.setType(dto.getType());
        transmission.setSelectedTransmissions(dto.getSelectedTransmissions());
        return transmission;
    }

    @Override
    public TransmissionDto convertToDTO(Transmission entity) {
        TransmissionDto transmissionDto = new TransmissionDto();
        transmissionDto.setId(entity.getId());
        transmissionDto.setType(entity.getType());
        transmissionDto.setSelectedTransmissions(entity.getSelectedTransmissions());
        return transmissionDto;
    }
}
