package QA.Enums;

public enum SQL_QUERY {

    SELECT_EVENT_ATTENDANCE("SELECT * FROM `event_attendance` ORDER BY `event_attendance`.`created` DESC"),
    SELECET_MY_EVENT_INFO("SELECT * FROM `event` ORDER BY `event`.`created` DESC"),
    SELECET_EVENT_CHECK_OUT("SELECT * FROM `event_check_out` ORDER BY `event_check_out`.`created_at` DESC"),


    ;
    private String sql;

    SQL_QUERY(String sql) {
        this.sql=sql;
    }

    public String getSql() {
        return sql;
    }
}
