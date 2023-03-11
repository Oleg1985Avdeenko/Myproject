package service.mapping;

import entity.cars.Transmission;
import service.dto.TransmissionDto;

public class MappingTrandmission implements MappingService<Transmission, TransmissionDto> {
    @Override
    public Transmission convertToEntity(TransmissionDto dto) {
        Transmission transmission = new Transmission();
        transmission.setId(dto.getId());
        transmission.setTransmissionType(dto.getType());
        transmission.setCarTransmission(dto.getCarTransmission());
        return transmission;
    }

    @Override
    public TransmissionDto convertToDTO(Transmission entity) {
        TransmissionDto transmissionDto = new TransmissionDto();
        transmissionDto.setId(entity.getId());
        transmissionDto.setType(entity.getTransmissionType());
        transmissionDto.setCarTransmission(entity.getCarTransmission());
        return transmissionDto;
    }
}
