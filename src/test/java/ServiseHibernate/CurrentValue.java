package ServiseHibernate;

import EntityHibernate.SellerHibernate;

import java.sql.SQLException;

public interface CurrentValue {
   SellerHibernate currentValue() throws SQLException;;
}
