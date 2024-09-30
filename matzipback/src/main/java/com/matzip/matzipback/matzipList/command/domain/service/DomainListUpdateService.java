package com.matzip.matzipback.matzipList.command.domain.service;

import com.matzip.matzipback.matzipList.command.application.dto.UpdateListRequset;
import com.matzip.matzipback.matzipList.command.domain.aggregate.MyList;
import com.matzip.matzipback.matzipList.command.domain.repository.ListDomainRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainListUpdateService {

    private final ModelMapper modelMapper;
    private final ListDomainRepository listDomainRepository;


    public long updateList(UpdateListRequset updateListRequset, long listUserSeq) {

        Long listSeq = updateListRequset.getListSeq();

        MyList existList = listDomainRepository.findById(listSeq)
                .orElseThrow(() -> new IllegalArgumentException("해당 리스트가 존재하지 않습니다." + listSeq));

        modelMapper.map(updateListRequset, existList);
        existList.setListUserSeq(listUserSeq);
        existList.setListContent(updateListRequset.getListContent());
        existList.setListTitle(updateListRequset.getListTitle());
        existList.setListLevel(updateListRequset.getListLevel());

        listDomainRepository.save(existList);

        return existList.getListSeq();

    }
}