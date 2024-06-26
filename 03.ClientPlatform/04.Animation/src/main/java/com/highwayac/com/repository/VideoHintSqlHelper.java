package com.highwayac.com.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class VideoHintSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("workspace", table, columnPrefix + "_workspace"));
        columns.add(Column.aliased("creator", table, columnPrefix + "_creator"));
        columns.add(Column.aliased("creation_content", table, columnPrefix + "_creation_content"));
        columns.add(Column.aliased("background_music", table, columnPrefix + "_background_music"));

        return columns;
    }
}
