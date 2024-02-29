package sale_campaign.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_history")
@AllArgsConstructor
@NoArgsConstructor
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Getter
    private String productId;
    private String title;
    @Getter
    private long price;
    @Getter
    private long date;

    public PriceHistory(String productId, String title, long price, long date) {
        this.Id = getId();
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.date = date;
    }
}
