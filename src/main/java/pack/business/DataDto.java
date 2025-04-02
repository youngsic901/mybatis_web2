package pack.business;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DataDto {
    private String id, name, passwd;
    private Timestamp regdate;
}
