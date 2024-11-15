package co.com.book.bookms.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Health {

    private String version;
    private String date;
    private String status;
}
