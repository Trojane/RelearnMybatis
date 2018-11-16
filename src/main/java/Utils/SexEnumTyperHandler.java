package Utils;

import POJO.Other.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexEnumTyperHandler implements TypeHandler<SexEnum> {

    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getId());
    }

    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        int anInt = rs.getInt(columnName);
        return SexEnum.getSexById(anInt);
    }

    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        int anInt = rs.getInt(columnIndex);
        return SexEnum.getSexById(anInt);
    }

    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int anInt = cs.getInt(columnIndex);
        return SexEnum.getSexById(anInt);
    }
}
