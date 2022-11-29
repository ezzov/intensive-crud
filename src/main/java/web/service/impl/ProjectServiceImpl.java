package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.abtr.ProjectDao;
import web.model.Project;
import web.service.abstr.ProjectService;


@Service
public class ProjectServiceImpl extends AbstrServiceImpl<Project, Long> implements ProjectService {

    private ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        super(projectDao);
        this.projectDao = projectDao;
    }

}
