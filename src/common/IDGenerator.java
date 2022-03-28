
package common;


import java.text.NumberFormat;

public class IDGenerator {

    public static String getNewID(String tableName, String colName, String prifix) throws  Exception {
        String lastId = IDController.getLastID(tableName, colName);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prifix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(5);
            numberFormat.setGroupingUsed(false);
            int newID = Integer.parseInt(numberFormat.format(id++));
            return prifix + newID;
        } else {
            return prifix + 1;
        }
    }

}
