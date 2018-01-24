package heapstark.domain.vo;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/24.
 */
public class PageParams {
    private Integer pageNumber;
    private Integer pageSize;
    private Boolean usePage;
    private Integer total;
    private Integer totalPage;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getUsePage() {
        return usePage;
    }

    public void setUsePage(Boolean usePage) {
        this.usePage = usePage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageParams{");
        sb.append("pageNumber=").append(pageNumber);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", usePage=").append(usePage);
        sb.append(", total=").append(total);
        sb.append(", totalPage=").append(totalPage);
        sb.append('}');
        return sb.toString();
    }
}
