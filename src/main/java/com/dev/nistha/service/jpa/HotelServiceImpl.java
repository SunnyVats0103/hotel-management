package com.dev.nistha.service.jpa;

import com.dev.nistha.dto.HotelDTO;
import com.dev.nistha.entity.Hotel;
import com.dev.nistha.errorhandler.NoHotelFoundException;
import com.dev.nistha.mapper.HotelMapper;
import com.dev.nistha.repository.HotelRepository;
import com.dev.nistha.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

    @RequiredArgsConstructor
    @Service
    public class HotelServiceImpl implements HotelService {

        private final HotelRepository hotelRepository;
        private final HotelMapper hotelMapper;

        @Override
        public HotelDTO getHotelById(Long id) throws NoHotelFoundException {
            Optional<Hotel> savedHotel = hotelRepository.findById(id);

            if (savedHotel.isEmpty())
                throw new NoHotelFoundException("No hotel found with id: " + id);

            return hotelMapper.hotelToHotelDTO(savedHotel.get());
        }

        @Override
        public List<HotelDTO> getHotels() {
            List<Hotel> savedHotels = hotelRepository.findAllHotel();
            return savedHotels.stream().map(hotelMapper::hotelToHotelDTO).toList();
        }

        @Override
        @Transactional
        public HotelDTO createHotel(HotelDTO hotelDTO) {
            Hotel savedHotel = hotelRepository.save(hotelMapper.hotelDTOToHotel(hotelDTO));
            return hotelMapper.hotelToHotelDTO(savedHotel);
        }

        @Override
        @Transactional
        public HotelDTO updateHotel(HotelDTO hotelDTO) throws NoHotelFoundException {
            Optional<Hotel> existingHotel = hotelRepository.findById(hotelDTO.getId());
            if (existingHotel.isEmpty())
                throw new NoHotelFoundException("No hotel found with hotel number: " + hotelDTO.getId());

            Hotel updatedHotel = hotelRepository.save(hotelMapper.hotelDTOToHotel(hotelDTO));
            return hotelMapper.hotelToHotelDTO(updatedHotel);
        }

        @Override
        @Transactional
        public void deleteHotel(Long id) {
            hotelRepository.deleteById(id);
        }

    }
