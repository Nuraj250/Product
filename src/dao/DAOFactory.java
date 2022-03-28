
package dao;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public enum DAOTypes {
        PRODUCT;

    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();

        }
        return daoFactory;
    }

    public SuperDAO getSuperDAO(DAOTypes types) throws Exception {
        switch (types) {

            case PRODUCT:
                return new ProductDAOImpl();

            default:
                return null;

        }

    }
}
