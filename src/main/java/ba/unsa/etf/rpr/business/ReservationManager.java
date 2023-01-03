package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.TrainException;

public class ReservationManager {
    public void delete (int id) throws TrainException {
        try {
            DaoFactory.reservationDao().delete(id);
        }
        catch (TrainException e) {
            if (e.getMessage().contains("FOREIGN KEY")) {
                throw new TrainException("NO");
            }
            throw e;
        }
    }
}
