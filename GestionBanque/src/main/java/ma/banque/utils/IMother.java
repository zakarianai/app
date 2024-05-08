package ma.banque.utils;

import java.util.Date;

public interface IMother {

    Long getId();

    Date getUpdateDate();

    void setUpdateDate(Date updateDate);

    Date getDeleteDate();

    void setDeleteDate(Date updateDate);

}
