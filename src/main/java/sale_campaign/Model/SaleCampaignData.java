package sale_campaign.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "sale_campaign")
@NoArgsConstructor
public class SaleCampaignData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private long startDate;
    private long endDate;

    public SaleCampaignData(String title, String startDate, String endDate) {
        this.id = id;
        this.title = title;

        DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Instant startInstant= LocalDate.parse(startDate,dateFormatter).atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant endInstant= LocalDate.parse(endDate,dateFormatter).atStartOfDay().toInstant(ZoneOffset.UTC);

        this.startDate = startInstant.toEpochMilli();
        this.endDate = endInstant.toEpochMilli();
    }
}
