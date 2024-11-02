package com.dev.nistha.service.jpa;

import com.dev.nistha.dto.ResponseDTO;
import com.dev.nistha.dto.StaffDTO;
import com.dev.nistha.entity.Staff;
import com.dev.nistha.errorhandler.NoStaffFoundException;
import com.dev.nistha.mapper.StaffMapper;
import com.dev.nistha.repository.StaffRepository;
import com.dev.nistha.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public ResponseDTO createStaff(StaffDTO staffDTO) throws ParseException {
//        Convert staff dto to staff entity
        Staff transientStaff = StaffMapper.staffDTOToStaff(staffDTO);
//        Saved Entity from database
        Staff savedStaff = staffRepository.save(transientStaff);

        if (savedStaff.getId() != null)
            return ResponseDTO.builder()
                    .code("201")
                    .message("Staff Created!")
                    .build();

        return ResponseDTO.builder()
                .code("500")
                .message("Something went wrong!")
                .build();
    }

    @Override
    public StaffDTO getStaffById(Long id) throws NoStaffFoundException {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent()) return StaffMapper.staffToStaffDTO(optionalStaff.get());
        else throw new NoStaffFoundException("Staff with given id: " + id + " not found");
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        Iterable<Staff> staffs = staffRepository.findAll();
        List<StaffDTO> staffDTOList = new ArrayList<>();
        for (Staff staff : staffs) {
            staffDTOList.add(StaffMapper.staffToStaffDTO(staff));
        }
        return staffDTOList;
    }

    @Override
    public ResponseDTO updateStaff(StaffDTO staffDTO) throws NoStaffFoundException, ParseException {
        Staff updatedStaff = staffRepository.save(StaffMapper.staffDTOToStaff(staffDTO));

        if (updatedStaff.getId() != null)
            ResponseDTO.builder()
                    .code("200")
                    .message("Staff Updated!")
                    .build();

        return ResponseDTO.builder()
                .code("500")
                .message("Something went wrong!")
                .build();
    }

    @Override
    public ResponseDTO deleteStaff(Long id) throws NoStaffFoundException {
        try {
            staffRepository.deleteById(id);
        } catch (IllegalArgumentException iae) {
            throw new NoStaffFoundException("Staff with given id: " + id + " not found");
        }

        return ResponseDTO.builder()
                .code("200")
                .message("Staff Deleted!")
                .build();
    }

}
