package qjm.data.synch.mapper;

import qjm.data.synch.modle.EducationExperience;

import java.util.List;

public interface EducationExperienceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EducationExperience record);

    int insertSelective(EducationExperience record);

    EducationExperience selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EducationExperience record);

    int updateByPrimaryKey(EducationExperience record);

    List<EducationExperience> selectAll();
}