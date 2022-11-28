package web.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.abtr.PositionDao;
import web.model.Position;
import web.service.abstr.PositionService;


@Service
public class PositionServiceImpl extends AbstrServiceImpl<Position, Long> implements PositionService {

    private PositionDao positionDao;

    @Autowired
    public PositionServiceImpl(PositionDao positionDao) {
        super(positionDao);
        this.positionDao = positionDao;
    }
}
