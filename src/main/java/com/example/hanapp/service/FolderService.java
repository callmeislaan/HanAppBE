package com.example.hanapp.service;

import com.example.hanapp.entity.Folder;
import com.example.hanapp.entity.request.FolderRequest;
import com.example.hanapp.entity.response.FolderResponse;
import com.example.hanapp.repository.FolderRepository;
import com.example.hanapp.service.util.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static ch.qos.logback.classic.util.LevelToSyslogSeverity.convert;

@Service
public class FolderService {

    private final FolderRepository folderRepository;

    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public List<FolderResponse> getFolders() {
        return folderRepository.findAll()
                .stream().map(ConvertUtil::convert).collect(Collectors.toList());
    }

    public FolderResponse createFolder(FolderRequest request) {
        Folder folder = new Folder();
        BeanUtils.copyProperties(request, folder);
        return ConvertUtil.convert(folderRepository.save(folder));
    }

    public FolderResponse updateFolder(Long id, FolderRequest request) {
        Folder folder = folderRepository.findById(id).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(request, folder, "id");
        return ConvertUtil.convert(folderRepository.save(folder));
    }

    public List<FolderResponse> deleteFolder(Long id) {
        if (!folderRepository.existsById(id)) {
            folderRepository.deleteById(id);
        }
        return getFolders();
    }

}
