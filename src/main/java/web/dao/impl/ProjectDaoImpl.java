package web.dao.impl;

import org.springframework.stereotype.Repository;
import web.dao.abtr.ProjectDao;
import web.model.Project;

@Repository
public class ProjectDaoImpl extends AbstrDaoImpl<Project, Long> implements ProjectDao {

}
