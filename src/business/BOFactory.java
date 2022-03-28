
package business;

public class BOFactory {

    private static BOFactory boFactoy;

    public enum BOTypes {

        PRODUCT;
    }

    public static BOFactory getBOFactory() {
        if (boFactoy == null) {
            return new BOFactory();
        }
        return boFactoy;
    }

    public ProductBOImpl getSuperBO(BOTypes types) throws Exception {
        switch (types) {
            case PRODUCT:
                return  new ProductBOImpl();

            default:
                return null;

        }

    }
}
