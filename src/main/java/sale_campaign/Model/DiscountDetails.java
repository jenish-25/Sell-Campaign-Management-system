package sale_campaign.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "discount_data")
@NoArgsConstructor
public class DiscountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String productId;
    private int saleId;
    private long discount;
    private String startDate;
    private String endDate;
    @Getter
    private boolean issale;

    public void setIssale(boolean issale) {
        this.issale = issale;
    }

    public DiscountDetails(String productId, int saleId, long discount, String startDate, String endDate) {
        this.Id = getId();
        this.productId = productId;
        this.saleId = saleId;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.issale = false;
    }
}
