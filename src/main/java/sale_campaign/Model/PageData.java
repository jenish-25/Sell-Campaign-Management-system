package sale_campaign.Model;

import lombok.Data;

@Data
public class PageData {
    int page;
    int pageSize;

    public int getPage(){
        return page;
    }
    public int getPageSize(){
        return pageSize;
    }
}
