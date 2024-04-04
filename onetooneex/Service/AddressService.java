package com.example.onetooneex.Service;

import com.example.onetooneex.Api.ApiException;
import com.example.onetooneex.DTO.AddressDTO;
import com.example.onetooneex.Model.Address;
import com.example.onetooneex.Model.Teacher;
import com.example.onetooneex.Repository.AddressRepository;
import com.example.onetooneex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher t=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(t==null){
            throw new ApiException("not found");
        }
        //مررت نول لان الايدي تمت تغطيته
        Address address=new Address(null,addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingnum(),t);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address a=addressRepository.findAddressById(addressDTO.getTeacher_id());

        if(a==null){
            throw new ApiException("not found");
        }

        a.setArea(addressDTO.getArea());
        a.setStreet(addressDTO.getStreet());
        a.setBuildingnum(addressDTO.getBuildingnum());
        addressRepository.save(a);
    }

    public void deleteAddress(Integer id){
        Address a=addressRepository.findAddressById(id);
        if(a==null){
            throw new ApiException("not found");
        }
        addressRepository.delete(a);
    }



}
