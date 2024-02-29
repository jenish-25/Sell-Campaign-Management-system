package sale_campaign.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sale_campaign.Model.*;
import sale_campaign.Repository.CampaignRepository;
import sale_campaign.Repository.DiscountRepository;
import sale_campaign.Repository.PriceHistoryRepository;
import sale_campaign.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PriceHistoryRepository priceHistoryRepository;

    @Autowired
    DiscountRepository discountRepository;

    @Autowired
    CampaignRepository campaignRepository;
    public ResponseEntity<List<ProductData>> addProduct(List<ProductData> productDataList) {
        long currentTimeMillis=System.currentTimeMillis();
        for (ProductData pd:productDataList){
            pd.setProductId();
            long discount=((pd.getMrp()-pd.getCurrentPrice())*100)/pd.getMrp();
            pd.setDiscount(discount);
            productRepository.save(pd);

            PriceHistory priceHistory=new PriceHistory(pd.getProductId(),pd.getTitle(),pd.getCurrentPrice(),currentTimeMillis);
            priceHistoryRepository.save(priceHistory);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productDataList);
    }

    public ResponseEntity<Optional<ProductData>> getProductDetails(String productId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(productRepository.findById(productId));
    }

    public ResponseEntity<List<ProductData>> allData() {
        return ResponseEntity.status(HttpStatus.FOUND).body(productRepository.findAll());
    }

    public List<ProductData> getData(PageData pageData) {
        Pageable pageable=PageRequest.of(pageData.getPage(),pageData.getPageSize());
        Page<ProductData> page=productRepository.findAll(pageable);
        List<ProductData> returnData=page.getContent();
        return returnData;
    }

    public SaleCampaignDto addCampaignData(SaleCampaignDto saleCampaignDto) {
        SaleCampaignData saleCampaignData=new SaleCampaignData(saleCampaignDto.getTitle(),saleCampaignDto.getStartDate(),saleCampaignDto.getEndDate());
        campaignRepository.save(saleCampaignData);

        for (DiscountDetails dd:saleCampaignDto.getCampaignDiscount()){
            DiscountDetails details=new DiscountDetails(dd.getProductId(),dd.getSaleId(),dd.getDiscount(),dd.getStartDate(),dd.getEndDate());
            discountRepository.save(details);
        }
        return saleCampaignDto;
    }

    public void triggerDiscount() {
        List<DiscountDetails> discountDetails=discountRepository.findAll();
        long currentTimeMillis=System.currentTimeMillis();

        for (DiscountDetails dd: discountDetails){
            long startdate=Long.parseLong(dd.getStartDate());
            long enddate=Long.parseLong(dd.getEndDate());
            if((currentTimeMillis>startdate) && (currentTimeMillis<enddate) && !dd.isIssale()){
                dd.setIssale(true);
                discountRepository.save(dd);
                ProductData productData=productRepository.findById(dd.getProductId()).get();

                long newPrice=productData.getCurrentPrice() - ((dd.getDiscount()*productData.getCurrentPrice())/100);
                productData.setCurrentPrice(newPrice);

                long discount=((productData.getMrp()-productData.getCurrentPrice())*100)/productData.getMrp();
                productData.setDiscount(discount);

                productRepository.save(productData);

                PriceHistory productPriceHistory=new PriceHistory(productData.getProductId(),productData.getTitle(),newPrice,currentTimeMillis);
                priceHistoryRepository.save(productPriceHistory);
            }
        }
    }
    public void unTriggerDiscount(){
        List<DiscountDetails> discountDetails=discountRepository.findAll();
        long currentTimeMillis=System.currentTimeMillis();

        for (DiscountDetails dd:discountDetails){
            long enddate=Long.parseLong(dd.getEndDate());
            if(currentTimeMillis >enddate && dd.isIssale()){
                dd.setIssale(false);
                discountRepository.save(dd);
                ProductData productData = productRepository.findById(dd.getProductId()).get();

                List<PriceHistory> priceHistories=getHistory(dd.getProductId());
                long setBackPrice=priceHistories.get(priceHistories.size()-2).getPrice();
                productData.setCurrentPrice(setBackPrice);
                long discount=((productData.getMrp()-productData.getCurrentPrice())*100)/productData.getMrp();

                productData.setDiscount(discount);
                productRepository.save(productData);
                PriceHistory productPriceHistory=new PriceHistory(productData.getProductId(),productData.getTitle(),productData.getCurrentPrice(),currentTimeMillis);
                priceHistoryRepository.save(productPriceHistory);
            }
        }
    }

    public List<PriceHistory> getHistory(String productId){
        return priceHistoryRepository.findAllByProductId(productId);
    }

    public List<SaleCampaignData> pastCampaign() {
        List<SaleCampaignData> pastCampaign=new ArrayList<>();
        long currentimeMillis=System.currentTimeMillis();
        for (SaleCampaignData sd:campaignRepository.findAll()){
            if(currentimeMillis > sd.getEndDate()){
                pastCampaign.add(sd);
            }
        }
        return pastCampaign;
    }

    public List<SaleCampaignData> currCampaign() {
        List<SaleCampaignData> currCampaign=new ArrayList<>();
        long currentimeMillis=System.currentTimeMillis();
        for (SaleCampaignData sd:campaignRepository.findAll()){
            if(currentimeMillis > sd.getStartDate() && currentimeMillis < sd.getEndDate()){
                currCampaign.add(sd);
            }
        }
        return currCampaign;
    }

    public List<SaleCampaignData> upcomingCampaign() {
        List<SaleCampaignData> upcomingCampaign=new ArrayList<>();
        long currentimeMillis=System.currentTimeMillis();
        for (SaleCampaignData sd:campaignRepository.findAll()){
            if(currentimeMillis < sd.getStartDate()){
                upcomingCampaign.add(sd);
            }
        }
        return upcomingCampaign;
    }
}
