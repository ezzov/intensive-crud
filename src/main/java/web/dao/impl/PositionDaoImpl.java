package web.dao.impl;

import org.springframework.stereotype.Repository;
import web.dao.abtr.PositionDao;
import web.model.Position;

@Repository
public class PositionDaoImpl extends AbstrDaoImpl<Position, Long> implements PositionDao {
}
