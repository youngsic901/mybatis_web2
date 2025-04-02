package pack.business;

import lombok.Data;

import java.util.Date;

@Data
public class DataDto {
    private String id, name, passwd;
    private Date regdate;
}
